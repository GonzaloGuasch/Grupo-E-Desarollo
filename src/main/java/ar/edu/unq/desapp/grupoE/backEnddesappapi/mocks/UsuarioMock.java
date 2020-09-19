package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Usuario;

public class UsuarioMock extends Usuario {
        private Integer cantidadDePuntos;

        public UsuarioMock(String nombreUsuario, String email, String contrasenia, String apodo){
            super(nombreUsuario, email, contrasenia, apodo);
            this.cantidadDePuntos = 0;

    }
}
