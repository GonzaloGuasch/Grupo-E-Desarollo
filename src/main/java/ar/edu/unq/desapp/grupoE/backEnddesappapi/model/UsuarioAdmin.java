package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.ProyectoMock;

import java.time.LocalDate;

public class UsuarioAdmin extends Usuario{
    private Integer cantidadDeProyectosCerrados;
    public UsuarioAdmin(String nombreUsuario, String email, String contraseña, String apodo) {
        super(nombreUsuario, email, contraseña, apodo);
        cantidadDeProyectosCerrados = 0;
    }

    public void finalizarProyecto(ProyectoMock proyectoSinFinalizarMock, LocalDate fechaDeFinalizacion) {
        proyectoSinFinalizarMock.finalizarElDiaDe(fechaDeFinalizacion);
        this.cantidadDeProyectosCerrados = this.cantidadDeProyectosCerrados + 1;
    }

    public Integer getCantidadDeProyectosCerrados() {
        return this.cantidadDeProyectosCerrados;
    }
}
