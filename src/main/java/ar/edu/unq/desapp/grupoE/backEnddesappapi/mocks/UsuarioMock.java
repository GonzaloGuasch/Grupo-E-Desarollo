package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;

public class UsuarioMock {
        private String nombreUsuario;
        private String email;
        private String contrasenia;
        private String apodo;
        private Integer cantidadDePuntos;


        public UsuarioMock(String nombreUsuario, String email, String contrasenia, String apodo){
            this.nombreUsuario = nombreUsuario;
            this.email = email;
            this.contrasenia = contrasenia;
            this.apodo = apodo;
            this.cantidadDePuntos = 0;

    }

}
