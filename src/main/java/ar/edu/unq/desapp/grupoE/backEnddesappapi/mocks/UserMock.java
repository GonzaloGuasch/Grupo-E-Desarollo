package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;

public class UserMock extends User {
        private Integer amountOfPoints;

        public UserMock(String username, String email, String password, String nickname){
            super(username, email, password, nickname);
            this.amountOfPoints = 0;

    }
}
