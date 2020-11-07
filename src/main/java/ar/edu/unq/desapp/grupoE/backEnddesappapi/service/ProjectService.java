package ar.edu.unq.desapp.grupoE.backEnddesappapi.service;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.UserAdmin;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.CloseProjectWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.NewDonationWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.ProjectWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.LocalityRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.ProjectRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.UserAdminRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private LocalityRepository localityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAdminRepository userAdminRepository;
    @Autowired
    private JavaMailSender sender;

    public List<Project> getAll(){
        return this.projectRepository.findAll();
    }

    public Project save(ProjectWrapper project_to_save) {
        Locality locality_of_project = localityRepository.getLocalityByName(project_to_save.getLocalityName());
        Project project = new Project(project_to_save.getProjectName(), project_to_save.getPorcentageMin(), project_to_save.getStartDate(), project_to_save.getEndDate(), project_to_save.getFactor(), locality_of_project);
        return this.projectRepository.save(project);
    }

    public Integer makeDonation(NewDonationWrapper newDonation) {
        Project projectToDonate = this.projectRepository.findByprojectName(newDonation.getProjectName());
        User userWhoDonated = this.userRepository.findByuserName(newDonation.getUsername());

        userWhoDonated.donateFor(projectToDonate, newDonation.getAmountDonated());
        this.projectRepository.save(projectToDonate);
        this.userRepository.save(userWhoDonated);
        return projectToDonate.getAmountCollected();
    }

    public Integer getTotalOfMoneyNeeded(String projectName) {
        Project projectToDonate = this.projectRepository.findByprojectName(projectName);
        return projectToDonate.calculateMoneyBasedOnfactor();
    }

    public List<Project> getProjectsNearEndDate() {
        LocalDate dateToday = LocalDate.now();
        LocalDate oneMonthFromToday = LocalDate.now().plusMonths(1);
        return this.projectRepository.getProjectThatEndInAMonth(dateToday, oneMonthFromToday);
    }

    public void closeProject(CloseProjectWrapper closeProjectWrapper) throws Exception {
        Project projectToClose = this.projectRepository.findByprojectName(closeProjectWrapper.getProjectName());
        UserAdmin userAdmin = this.userAdminRepository.findByuserName(closeProjectWrapper.getUserAdmin());
        List<String> allUsersEmails = this.projectRepository.getAllMailsOfDonors();
        this.sendEmailWhenProjectIsClosed(allUsersEmails);
        userAdmin.finishProject(projectToClose, LocalDate.now());
        this.projectRepository.save(projectToClose);
        this.userAdminRepository.save(userAdmin);
    }

    private void sendEmailWhenProjectIsClosed(List<String> usersToSendEmails) throws Exception {
        for(int i = 0; i < usersToSendEmails.size(); i++){
            this.sendEmail(usersToSendEmails.get(i),  "The project that you donated know is closed, thanks so much to helping our country to grow!", "Project close");
        }
    }

    private void sendEmail(String to, String subject, String body) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(to);
        helper.setText(subject);
        helper.setSubject(body);

        sender.send(message);
    }
}
