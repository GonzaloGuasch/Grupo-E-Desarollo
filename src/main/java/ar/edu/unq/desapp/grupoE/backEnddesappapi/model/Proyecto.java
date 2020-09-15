package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalidadMock;

import java.time.LocalDate;

public class Proyecto {
    private String nombreProyecto;
    private Integer porcentajeMin;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer factor = 1000;
    private LocalidadMock localidad;

    public Proyecto(String nombreProyecto, Integer porcentajeMin, LocalDate fechaInicio, LocalDate fechaFin, Integer factor, LocalidadMock localidad) {
        this.nombreProyecto = nombreProyecto;
        this.porcentajeMin = porcentajeMin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.factor = factor;
        this.localidad = localidad;
    }



    public String getNombreProyecto() {

        return nombreProyecto;
    }


    public Integer getFactor() {

        return factor;
    }

    public LocalidadMock getLocalidad()
    {
        return localidad;
    }



}
