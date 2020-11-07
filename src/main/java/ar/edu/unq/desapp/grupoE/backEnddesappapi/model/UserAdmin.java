package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import javax.persistence.*;

import java.time.LocalDate;

@Entity
public class UserAdmin extends User {

    @Column
    private Integer numberOfProjectsClosed;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public UserAdmin(){}

    public UserAdmin(String nombreUsuario, String email, String contrasenia, String apodo) {
        super(nombreUsuario, email, contrasenia, apodo);
        numberOfProjectsClosed = 0;
    }

    public void finishProject(Project unfinishedProjectMock, LocalDate finishDate) {
        unfinishedProjectMock.endTheDayOf(finishDate);
        this.numberOfProjectsClosed =+ 1;
    }

    public Integer getNumberOfProjectsClosed() {
        return this.numberOfProjectsClosed;
    }
    public Long getId(){ return id;}
}
