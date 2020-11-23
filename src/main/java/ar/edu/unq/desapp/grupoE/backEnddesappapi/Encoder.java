package ar.edu.unq.desapp.grupoE.backEnddesappapi;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;


public class Encoder {

        private BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder(10, new SecureRandom());

        public String encoder(String plainTextPassWord ){
            return this.encoder.encode(plainTextPassWord);
        }

        public Boolean decode(String passWord, User user) {
            return this.encoder.matches(passWord, user.getPassword());
        }
}
