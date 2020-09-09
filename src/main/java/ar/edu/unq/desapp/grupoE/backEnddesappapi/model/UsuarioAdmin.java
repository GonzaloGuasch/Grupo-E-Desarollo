package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.ProyectoMock;

import java.time.LocalDate;

public class UsuarioAdmin extends Usuario{

    public UsuarioAdmin(String nombreUsuario, String email, String contraseña, String apodo) {
        super(nombreUsuario, email, contraseña, apodo);
    }

    public void finalizarProyecto(ProyectoMock proyectoSinFinalizarMock, LocalDate fechaDeFinalizacion) {
        proyectoSinFinalizarMock.finalizarElDiaDe(fechaDeFinalizacion);
    }
}
