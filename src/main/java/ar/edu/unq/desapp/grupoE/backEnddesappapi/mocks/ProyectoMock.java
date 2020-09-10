package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.ProyectoNoFinalizableException;

import java.time.LocalDate;

public class ProyectoMock {
    private LocalDate fechaFin;
    private LocalDate fechaInicio;
    private Integer montoRecadudao;
    private Integer montoTotal;

    public ProyectoMock(LocalDate fechaInicio, LocalDate fechaFin, Integer recaudado, Integer montoTotal) {
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.montoRecadudao = recaudado;
        this.montoTotal = montoTotal;
    }

    public Integer recibirDonancion(Integer cantidadDeDinero){
        if(cantidadDeDinero < 1000){
            return 0;
        }else{
            return cantidadDeDinero;
        }
    }

    public String getNombre() {
        return "Nombre generico";
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
