package ar.edu.unq.desapp.grupoE.backEnddesappapi;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalidadMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.UsuarioMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Aplicacion;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Proyecto;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AplicacionTest {

    LocalidadMock localidad;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    Proyecto proyecto;
    Aplicacion aplicacion = new Aplicacion();
    List<Proyecto> proyectos = new ArrayList<>();
    UsuarioMock usuario;
    List<UsuarioMock> usuarios = new ArrayList<>();


    @Before
    public void setUp() {
        fechaInicio = LocalDate.of(2019, 10, 01);
        fechaFin = LocalDate.of(2020, 10, 01);

        localidad = new LocalidadMock("Quilmes", "Buenos Aires", 1500, false);

        proyecto = new Proyecto("ProyectoInicial", 10, fechaInicio, fechaFin, 2000, localidad);

        proyectos = new ArrayList<>();
        proyectos.add(proyecto);

        usuario = new UsuarioMock("Willy", "willy@gmail.com", "willy", "willy");
        usuarios = new ArrayList<>();
        usuarios.add(usuario);

        aplicacion = new Aplicacion();
        aplicacion.agregarProyecto(proyecto);
        aplicacion.agregarUsuarios(usuario);

    }

    @Test
    public void test01SeCreaUnaAplicacionInicialConUnProyectoYUnUsuarios(){
        Aplicacion aplicacionRecienCreada = new Aplicacion();

        assertEquals(aplicacionRecienCreada.getUsuarios().size(),0);
        assertEquals(aplicacionRecienCreada.getProyectos().size(),0);

    }

    @Test
    public void test03CreoUnaAplicacionYAgregoUnUsuarioYUnProyecto(){
        assertEquals(aplicacion.getUsuarios().size(),1);
        assertEquals(aplicacion.getProyectos().size(),1);

    }


    @Test
    public void test02DadoUnaAplicacionYUnProyectoVerificoElDineroNecesarioParaProveerInternet(){
        assertEquals(aplicacion.calcularDineroNecesarioParaProveerInternet(proyecto),3000000);
    }

}
