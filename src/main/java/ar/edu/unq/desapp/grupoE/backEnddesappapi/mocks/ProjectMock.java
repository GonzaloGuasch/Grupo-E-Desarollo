package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Localidad;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.ProyectoNoFinalizableException;

import java.time.LocalDate;

public class ProjectMock extends Project {
    private LocalDate fechaFin;
    private LocalDate fechaInicio;
    private Integer montoRecadudao;
    private Integer montoTotal;

    public ProjectMock(String nombreProyecto, Integer porcentajeMin, LocalDate fechaInicio, LocalDate fechaFin, Integer factor, Localidad localidad) {
        super(nombreProyecto, porcentajeMin, fechaInicio, fechaFin, factor, localidad);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoRecadudao = 100;
        this.montoTotal = 90;
    }

    public ProjectMock(LocalDate fechaInicio, LocalDate fechaFin, Integer recaudacionMin, Integer recaudado) {
        super(null, recaudacionMin, fechaInicio, fechaFin, null ,null);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

        this.montoRecadudao = 100;
        this.montoTotal = 90;
    }
    public void receiveDonation(Integer amountOfMoney){
    }

    public void endTheDayOf(LocalDate finishDate) {
        if(noEsProyectoFinalizable(finishDate)){
            throw new ProyectoNoFinalizableException("El proyecto no llego ni a la recaudacion ni a la fecha de fin");
        }
    }

    private boolean noEsProyectoFinalizable(LocalDate fechaDeFinalizacion) {
        return fechaDeFinalizacion.isBefore(this.fechaFin) || this.montoRecadudao < this.montoTotal;
    }
}
