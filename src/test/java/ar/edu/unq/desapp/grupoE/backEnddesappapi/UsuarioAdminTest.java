package ar.edu.unq.desapp.grupoE.backEnddesappapi;


import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.ProyectoMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.ProyectoNoFinalizableException;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.UsuarioAdmin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;

public class UsuarioAdminTest {

    private ProyectoMock proyectoSinFinalizarMock;
    private UsuarioAdmin usuarioAdmin;

    @BeforeEach
    public void setUp() {
        LocalDate fechaDeFinProyecto = LocalDate.of(2021, 1, 1);
        LocalDate fechaDeInicioProyecto = LocalDate.of(2020, 12, 10);
        proyectoSinFinalizarMock = new ProyectoMock(fechaDeInicioProyecto, fechaDeFinProyecto);

        usuarioAdmin = new UsuarioAdmin("usuarioAdmin", "email@gmail.com", "1234", "admin");
    }

    @Test
    void test001_cuando_un_admin_quiere_cerrar_un_proyecto_que_no_llego_a_su_recaudacion_ni_a_su_fecha_de_fin_se_levanta_un_error() {
        assertThrows(ProyectoNoFinalizableException.class, () -> {
            usuarioAdmin.finalizarProyecto(proyectoSinFinalizarMock, LocalDate.now());
        });
    }
}
