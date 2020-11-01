package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RestController
@RequestMapping("/mail")
@CrossOrigin
public class MailController {

    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/sendEmail")
    public void sendEmail() throws Exception {
        this.sendEmail("gonzaloguasch98@gmail.com", "prueba", "prueba");
    }

    @Scheduled(cron = "0 0 12 * * ?")
    private void sendEmail(String to, String subject, String body) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(to);
        helper.setText(subject);
        helper.setSubject(body);

        sender.send(message);
    }

}

