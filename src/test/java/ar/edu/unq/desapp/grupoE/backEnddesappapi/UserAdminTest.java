package ar.edu.unq.desapp.grupoE.backEnddesappapi;


import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.ProjectMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.ProjectNotFinalizableException;
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
        LocalDate fechaDeFinProyecto = LocalDate.of(2021, 1, 1);
        LocalDate fechaDeInicioProyecto = LocalDate.of(2020, 12, 10);
        proyectoSinFinalizarMock = new ProjectMock("prueba", 35,  fechaDeInicioProyecto, fechaDeFinProyecto, 0, null);

        usuarioAdmin = new UserAdmin("usuarioAdmin", "email@gmail.com", "1234", "admin");
    }

    @Test
    void test001_cuando_un_admin_quiere_cerrar_un_proyecto_que_no_llego_a_su_recaudacion_ni_a_su_fecha_de_fin_se_levanta_un_error() {
        assertThrows(ProjectNotFinalizableException.class, () -> {
            usuarioAdmin.finishProject(proyectoSinFinalizarMock, LocalDate.now());
        });
    }

    @Test
    void test002_un_admin_puede_cerrar_un_proyecto_si_este_llego_a_lo_recaudad_pero_no_a_la_fecha_de_fin() {
        ProjectMock proyectoConRecaudacion = new ProjectMock(LocalDate.of(2008, 1, 1), LocalDate.of(2019, 1, 1), 110, 100);
        usuarioAdmin.finishProject(proyectoConRecaudacion, LocalDate.now());

        assertEquals(usuarioAdmin.getNumberOfProjectsClosed(), 1);
    }
}
