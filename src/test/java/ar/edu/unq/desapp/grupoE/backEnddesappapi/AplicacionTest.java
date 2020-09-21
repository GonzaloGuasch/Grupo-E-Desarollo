package ar.edu.unq.desapp.grupoE.backEnddesappapi;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalidadMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.UsuarioMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Aplicacion;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
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
    Project projectQ, projectB, projectBE, projectDB, projectAV, projectVA, projectSO, projectHU, projectEZ, projectGU, projectBQ, projectEP;
    Aplicacion aplicacion = new Aplicacion();
    List<Project> projects = new ArrayList<>();
    UsuarioMock usuario;
    List<UsuarioMock> usuarios = new ArrayList<>();


    @BeforeAll
    public void setUp() {
        fechaInicio = LocalDate.of(2019, 10, 01);
        fechaFin = LocalDate.of(2020, 10, 01);

        localidadQuilmes = new LocalidadMock("Quilmes", "Buenos Aires", 1500, false);

        projectQ = new Project("ProyectoQuilmes", 10, fechaInicio, fechaFin, 2000, localidadQuilmes);
        projectB = new Project("ProyectoBernal", 20, fechaInicio, fechaFin, 2000, localidadBernal);
        projectBE = new Project("ProyectoBerazategui", 30, fechaInicio, fechaFin, 2000, localidadBegui);
        projectDB = new Project("ProyectoDonBosco", 40, fechaInicio, fechaFin, 2000, localidadDonBosco);
        projectAV = new Project("ProyectoAvellaneda", 50, fechaInicio, fechaFin, 2000, localidadAvellaneda);
        projectVA = new Project("ProyectoVarela", 60, fechaInicio, fechaFin, 2000, localidadVarela);
        projectSO = new Project("ProyectoSolano", 20, fechaInicio, fechaFin, 2000, localidadSolano);
        projectHU = new Project("ProyectoHudson", 30, fechaInicio, fechaFin, 2000, localidadHudson);
        projectEZ = new Project("ProyectoEzpeleta", 40, fechaInicio, fechaFin, 2000, localidadEzpeleta);
        projectGU = new Project("ProyectoGutierrez", 50, fechaInicio, fechaFin, 2000, localidadGutierrez);
        projectBQ = new Project("ProyectoBosques", 10, fechaInicio, fechaFin, 2000, localidadBosques);
        projectEP = new Project("ProyectoElPato", 20, fechaInicio, fechaFin, 2000, localidadElPato);


        projects = new ArrayList<>();
        projects.add(projectQ);

        usuario = new UsuarioMock("Willy", "willy@gmail.com", "willy", "willy");
        usuarios = new ArrayList<>();
        usuarios.add(usuario);

        aplicacion = new Aplicacion();
        aplicacion.agregarProyecto(projectQ);
        aplicacion.agregarProyecto(projectAV);
        aplicacion.agregarProyecto(projectB);
        aplicacion.agregarProyecto(projectBE);
        aplicacion.agregarProyecto(projectBQ);
        aplicacion.agregarProyecto(projectDB);
        aplicacion.agregarProyecto(projectEP);
        aplicacion.agregarProyecto(projectEZ);
        aplicacion.agregarProyecto(projectSO);
        aplicacion.agregarProyecto(projectGU);
        aplicacion.agregarProyecto(projectHU);
        aplicacion.agregarProyecto(projectVA);

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
        aplicacionNueva.agregarProyecto(projectQ);
        aplicacionNueva.agregarUsuarios(usuario);
        assertEquals(aplicacionNueva.getUsuarios().size(),1);
        assertEquals(aplicacionNueva.getProyectos().size(),1);

    }


    @Test
    public void testDadoUnaAplicacionYUnProyectoVerificoElDineroNecesarioParaProveerInternet(){
        assertEquals(aplicacion.calcularDineroNecesarioParaProveerInternet(projectQ),3000000);
    }

    @Test
    public void testDadoUnaAplicacionConDoceProyectosVerificoElTopDiezDeDonaciones(){
        assertEquals(aplicacion.topDiezDeDonaciones().size(),10);
    }

    @Test
    public void asd(){

    }
}
