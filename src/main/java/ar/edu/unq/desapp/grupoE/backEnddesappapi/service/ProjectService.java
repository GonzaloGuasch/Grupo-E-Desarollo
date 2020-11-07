package ar.edu.unq.desapp.grupoE.backEnddesappapi.service;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.NewDonationWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.ProjectWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.LocalityRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.ProjectRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
