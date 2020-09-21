package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;

public class UserMock extends User {
        private Integer cantidadDePuntos;

        public UserMock(String nombreUsuario, String email, String contrasenia, String apodo){
            super(nombreUsuario, email, contrasenia, apodo);
            this.cantidadDePuntos = 0;

    }
}
