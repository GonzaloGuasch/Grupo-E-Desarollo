package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import java.time.LocalDate;

public class UserAdmin extends User {
    private Integer numberOfProjectsClosed;

    public UserAdmin(String nombreUsuario, String email, String contrasenia, String apodo) {
        super(nombreUsuario, email, contrasenia, apodo);
        numberOfProjectsClosed = 0;
    }

    public void finishProject(Project unfinishedProjectMock, LocalDate finishDate) {
        unfinishedProjectMock.endTheDayOf(finishDate);
        this.numberOfProjectsClosed = this.numberOfProjectsClosed + 1;
    }

    public Integer getNumberOfProjectsClosed() {
        return this.numberOfProjectsClosed;
    }
}
