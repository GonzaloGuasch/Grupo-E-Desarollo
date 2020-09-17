package ar.edu.unq.desapp.grupoE.backEnddesappapi;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalidadMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.UsuarioMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Aplicacion;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Proyecto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AplicacionTest {

    LocalidadMock localidadQuilmes,localidadBernal,localidadBegui,localidadDonBosco,localidadAvellaneda,localidadVarela,localidadSolano,localidadHudson,localidadBosques,localidadElPato,localidadEzpeleta,localidadGutierrez;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    Proyecto proyectoQ,proyectoB,proyectoBE,proyectoDB,proyectoAV,proyectoVA,proyectoSO,proyectoHU,proyectoEZ,proyectoGU,proyectoBQ,proyectoEP;
    Aplicacion aplicacion = new Aplicacion();
    List<Proyecto> proyectos = new ArrayList<>();
    UsuarioMock usuario;
    List<UsuarioMock> usuarios = new ArrayList<>();


    @BeforeAll
    public void setUp() {
        fechaInicio = LocalDate.of(2019, 10, 01);
        fechaFin = LocalDate.of(2020, 10, 01);

        localidadQuilmes = new LocalidadMock("Quilmes", "Buenos Aires", 1500, false);

        proyectoQ = new Proyecto("ProyectoQuilmes", 10, fechaInicio, fechaFin, 2000, localidadQuilmes);
        proyectoB = new Proyecto("ProyectoBernal", 20, fechaInicio, fechaFin, 2000, localidadBernal);
        proyectoBE = new Proyecto("ProyectoBerazategui", 30, fechaInicio, fechaFin, 2000, localidadBegui);
        proyectoDB = new Proyecto("ProyectoDonBosco", 40, fechaInicio, fechaFin, 2000, localidadDonBosco);
        proyectoAV = new Proyecto("ProyectoAvellaneda", 50, fechaInicio, fechaFin, 2000, localidadAvellaneda);
        proyectoVA = new Proyecto("ProyectoVarela", 60, fechaInicio, fechaFin, 2000, localidadVarela);
        proyectoSO = new Proyecto("ProyectoSolano", 20, fechaInicio, fechaFin, 2000, localidadSolano);
        proyectoHU = new Proyecto("ProyectoHudson", 30, fechaInicio, fechaFin, 2000, localidadHudson);
        proyectoEZ = new Proyecto("ProyectoEzpeleta", 40, fechaInicio, fechaFin, 2000, localidadEzpeleta);
        proyectoGU = new Proyecto("ProyectoGutierrez", 50, fechaInicio, fechaFin, 2000, localidadGutierrez);
        proyectoBQ = new Proyecto("ProyectoBosques", 10, fechaInicio, fechaFin, 2000, localidadBosques);
        proyectoEP = new Proyecto("ProyectoElPato", 20, fechaInicio, fechaFin, 2000, localidadElPato);


        proyectos = new ArrayList<>();
        proyectos.add(proyectoQ);

        usuario = new UsuarioMock("Willy", "willy@gmail.com", "willy", "willy");
        usuarios = new ArrayList<>();
        usuarios.add(usuario);

        aplicacion = new Aplicacion();
        aplicacion.agregarProyecto(proyectoQ);
        aplicacion.agregarProyecto(proyectoAV);
        aplicacion.agregarProyecto(proyectoB);
        aplicacion.agregarProyecto(proyectoBE);
        aplicacion.agregarProyecto(proyectoBQ);
        aplicacion.agregarProyecto(proyectoDB);
        aplicacion.agregarProyecto(proyectoEP);
        aplicacion.agregarProyecto(proyectoEZ);
        aplicacion.agregarProyecto(proyectoSO);
        aplicacion.agregarProyecto(proyectoGU);
        aplicacion.agregarProyecto(proyectoHU);
        aplicacion.agregarProyecto(proyectoVA);

        aplicacion.agregarUsuarios(usuario);

    }

    @Test
    public void testSeCreaUnaAplicacionInicialConUnProyectoYUnUsuarios(){
        Aplicacion aplicacionRecienCreada = new Aplicacion();

        assertEquals(aplicacionRecienCreada.getUsuarios().size(),0);
        assertEquals(aplicacionRecienCreada.getProyectos().size(),0);

    }

    @Test
    public void testCreoUnaAplicacionYAgregoUnUsuarioYUnProyecto(){
        Aplicacion aplicacionNueva = new Aplicacion();
        aplicacionNueva.agregarProyecto(proyectoQ);
        aplicacionNueva.agregarUsuarios(usuario);
        assertEquals(aplicacionNueva.getUsuarios().size(),1);
        assertEquals(aplicacionNueva.getProyectos().size(),1);

    }


    @Test
    public void testDadoUnaAplicacionYUnProyectoVerificoElDineroNecesarioParaProveerInternet(){
        assertEquals(aplicacion.calcularDineroNecesarioParaProveerInternet(proyectoQ),3000000);
    }

    @Test
    public void testDadoUnaAplicacionConDoceProyectosVerificoElTopDiezDeDonaciones(){
        assertEquals(aplicacion.topDiezDeDonaciones().size(),10);
    }
}
