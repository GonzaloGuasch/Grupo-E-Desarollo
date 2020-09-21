package ar.edu.unq.desapp.grupoE.backEnddesappapi;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalidadMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest {
    Project project;
    LocalidadMock localidad;
    LocalDate fechaInicio;
    LocalDate fechaFin;

    @BeforeEach
    public void setUp(){
        fechaInicio = LocalDate.of(2019,10,01);
        fechaFin = LocalDate.of(2020,10,01);
        localidad = new LocalidadMock(null,null,500,null);
        project = new Project("ProyectoInicial",10, fechaInicio, fechaFin,2000,localidad);
    }
    @Test
    public void test01SeCreaUnProyectoNuevoYVerificoQueSuNombreSeaElCorrecto(){
        assertEquals(project.getProjectName(),"ProyectoInicial");
    }

    @Test
    void test02DadoUnProyectoConFactorDosmilVerificoQueSeaElCorrecto(){
        assertEquals(project.getFactor(), 2000);
    }

    @Test
    void test03DadoUnProyectoConLocalidadVerificoQueSeaLaCorrecta(){
        assertEquals(project.getLocality(), localidad);
    }

    @Test
    void test04DadoUnProyectoQueRecibeUnaDonacionDe10000VerificoQueSuCantidadDeDineroSeaLaCorrecta(){
        project.receiveDonation(10000);
        assertEquals(project.getAmountCollected(), 10000);
    }

    @Test
    void test05DadoUnProyectoConFactor2000VerificoQueSuDineroEnBaseAlFactorSeaElCorrecto(){
        assertEquals(project.calculateMoneyBasedOnfactor(),1000000);
    }

    @Test
    void test006PorDefectoUnProyectoTieneFactorMilY100PorcientoParaCompletarlo() {
        Project project_por_defecto = new Project("Proyecto default", fechaInicio, fechaFin, localidad);

        assertEquals(project_por_defecto.getFactor(), 1000);
        assertEquals(project_por_defecto.getPorcentageMin(), 100);
    }

}
