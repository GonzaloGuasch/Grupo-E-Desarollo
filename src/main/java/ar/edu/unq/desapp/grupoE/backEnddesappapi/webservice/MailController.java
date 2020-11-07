package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.util.List;

@RestController
@RequestMapping("/mail")
@CrossOrigin
@EnableScheduling
public class MailController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private JavaMailSender sender;


    @Scheduled(cron = "0 0 9 * * ?")
    public void sendEmail() throws Exception {
        List<User> allUsers = userRepository.findAll();
        for(int i = 0; i < allUsers.size(); i++) {
            this.sendEmail(allUsers.get(i).getEmail(), "Daily email", "Hi, we want to know if you are okey. Have a good day!");
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

