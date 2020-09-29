package ar.edu.unq.desapp.grupoE.backEnddesappapi;


import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.ProjectMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.exceptions.ProjectNotFinalizableException;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.UserAdmin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;

public class UserAdminTest {

    private ProjectMock proyectoSinFinalizarMock;
    private UserAdmin usuarioAdmin;

    @BeforeEach
    public void setUp() {
        LocalDate dateFinishProject = LocalDate.of(2021, 1, 1);
        LocalDate dateStartProject = LocalDate.of(2020, 12, 10);
        proyectoSinFinalizarMock = new ProjectMock("prueba", 35,  dateStartProject, dateFinishProject, 0, null);

        usuarioAdmin = new UserAdmin("usuarioAdmin", "email@gmail.com", "1234", "admin");
    }

    @Test
    void test001AnAdminCannotCloseAProjectIfItDinNotReachTheFinishDate() {
        assertThrows(ProjectNotFinalizableException.class, () -> {
            usuarioAdmin.finishProject(proyectoSinFinalizarMock, LocalDate.now());
        });
    }

    @Test
    void test002AnAdminCanCloseAProjectIfItReachTheRaiseMoney() {
        ProjectMock proyectoConRecaudacion = new ProjectMock(LocalDate.of(2008, 1, 1), LocalDate.of(2019, 1, 1), 110, 100);
        usuarioAdmin.finishProject(proyectoConRecaudacion, LocalDate.now());

        assertEquals(usuarioAdmin.getNumberOfProjectsClosed(), 1);
    }
}
