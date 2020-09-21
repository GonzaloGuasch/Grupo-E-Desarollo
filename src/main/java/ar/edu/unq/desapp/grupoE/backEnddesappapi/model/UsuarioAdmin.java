package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import java.time.LocalDate;

public class UsuarioAdmin extends Usuario{
    private Integer cantidadDeProyectosCerrados;
    public UsuarioAdmin(String nombreUsuario, String email, String contraseña, String apodo) {
        super(nombreUsuario, email, contraseña, apodo);
        cantidadDeProyectosCerrados = 0;
    }

    public void finalizarProyecto(Project projectSinFinalizarMock, LocalDate fechaDeFinalizacion) {
        projectSinFinalizarMock.endTheDayOf(fechaDeFinalizacion);
        this.cantidadDeProyectosCerrados = this.cantidadDeProyectosCerrados + 1;
    }

    public Integer getCantidadDeProyectosCerrados() {
        return this.cantidadDeProyectosCerrados;
    }
}
