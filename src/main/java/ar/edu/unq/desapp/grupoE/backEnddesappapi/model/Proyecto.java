package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalidadMock;

import java.time.LocalDate;

public class Proyecto {
    private String nombreProyecto;
    private Integer porcentajeMin;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer factor;
    private LocalidadMock localidad;
    private Integer montoRecaudado;

    public Proyecto(String nombreProyecto, Integer porcentajeMin, LocalDate fechaInicio, LocalDate fechaFin, Integer factor, LocalidadMock localidad) {
        this.nombreProyecto = nombreProyecto;
        this.porcentajeMin = porcentajeMin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.factor = factor;
        this.localidad = localidad;
        this.montoRecaudado = 0;
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

    public void setMontoRecaudado(Integer montoRecaudado) {
        this.montoRecaudado = montoRecaudado;
    }

    public Integer getMontoRecaudado(){
        return montoRecaudado;
    }

    public Integer recibirDonancion(Integer cantidadDeDinero){
        this.setMontoRecaudado(this.getMontoRecaudado() + cantidadDeDinero);
        if(cantidadDeDinero < 1000){
            return 0;
        }else{
            return cantidadDeDinero;
        }
    }


    public Integer getCantidadDePoblacionParaProyecto() {
        return this.getLocalidad().getCantidadDePoblacion();
    }

    public Integer calcularDineroEnBaseAFactor() {
        return this.getCantidadDePoblacionParaProyecto() * (this.getFactor());
    }

    public Integer calcularDineroDefault() {
        return this.getCantidadDePoblacionParaProyecto() * 1000;
    }

    public boolean tieneFactorCustom() {
        return this.getFactor() != 0;
    }
}




