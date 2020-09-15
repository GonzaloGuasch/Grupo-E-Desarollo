package ar.edu.unq.desapp.grupoE.backEnddesappapi;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalidadMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Proyecto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProyectoTest {
    Proyecto proyecto;
    LocalidadMock localidad;
    LocalDate fechaInicio;
    LocalDate fechaFin;

    @BeforeEach
    public void setUp(){
        fechaInicio = LocalDate.of(2019,10,01);
        fechaFin = LocalDate.of(2020,10,01);
        localidad = new LocalidadMock(null,null,null,null);
        proyecto = new Proyecto("ProyectoInicial",10, fechaInicio, fechaFin,2000,localidad);
    }
    @Test
    public void test01SeCreaUnProyectoNuevoYVerificoQueSuNombreSeaElCorrecto(){
        assertEquals(proyecto.getNombreProyecto(),"ProyectoInicial");
    }

    @Test
    void test02DadoUnProyectoConFactorDosmilVerificoQueSeaElCorrecto(){
        assertEquals(proyecto.getFactor(), 2000);
    }

}
