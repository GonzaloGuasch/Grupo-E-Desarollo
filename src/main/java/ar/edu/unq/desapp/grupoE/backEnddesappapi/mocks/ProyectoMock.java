package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Proyecto;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.ProyectoNoFinalizableException;

import java.time.LocalDate;

public class ProyectoMock extends Proyecto {
    private LocalDate fechaFin;
    private LocalDate fechaInicio;
    private Integer montoRecadudao;
    private Integer montoTotal;

    public ProyectoMock(String nombreProyecto, Integer porcentajeMin, LocalDate fechaInicio, LocalDate fechaFin, Integer factor, LocalidadMock localidad) {
        super(nombreProyecto, porcentajeMin, fechaInicio, fechaFin, factor, localidad);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoRecadudao = 100;
        this.montoTotal = 90;
    }

    public ProyectoMock(LocalDate fechaInicio, LocalDate fechaFin, Integer recaudacionMin, Integer recaudado) {
        super(null, recaudacionMin, fechaInicio, fechaFin, null ,null);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

        this.montoRecadudao = 100;
        this.montoTotal = 90;
    }
    public void recibirDonancion(Integer cantidadDeDinero){
    }

    public void finalizarElDiaDe(LocalDate fechaDeFinalizacion) {
        if(noEsProyectoFinalizable(fechaDeFinalizacion)){
            throw new ProyectoNoFinalizableException("El proyecto no llego ni a la recaudacion ni a la fecha de fin");
        }
    }

    private boolean noEsProyectoFinalizable(LocalDate fechaDeFinalizacion) {
        return fechaDeFinalizacion.isBefore(this.fechaFin) || this.montoRecadudao < this.montoTotal;
    }
}
