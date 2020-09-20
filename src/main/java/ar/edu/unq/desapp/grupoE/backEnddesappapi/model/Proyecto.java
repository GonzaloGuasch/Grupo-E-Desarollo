package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalidadMock;
import java.time.LocalDate;

public class Proyecto {
    private String nombreProyecto;
    private Integer porcentajeMin;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer factor;
    private Localidad localidad;
    private Integer montoRecaudado;
    private Integer multiplicadorDeBono;

    public Proyecto(String nombreProyecto, Integer porcentajeMin, LocalDate fechaInicio, LocalDate fechaFin, Integer factor, Localidad localidad) {
        this.nombreProyecto = nombreProyecto;
        this.porcentajeMin = porcentajeMin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.factor = factor;
        this.localidad = localidad;
        this.montoRecaudado = 0;

        if(localidad != null && localidad.getCantidadDePoblacion() < 2000){
            this.multiplicadorDeBono = 2;
        }else{
            this.multiplicadorDeBono = 1;
        }
    }

    public Proyecto(String nombreProyecto, LocalDate fechaInicio, LocalDate fechaFin, Localidad localidad) {
        this.nombreProyecto = nombreProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.localidad = localidad;

        this.montoRecaudado = 0;
        this.porcentajeMin = 100;
        this.factor = 1000;
    }

    public String getNombreProyecto() { return nombreProyecto; }
    public Integer getFactor() { return factor; }
    public Localidad getLocalidad()
    {
        return localidad;
    }
    public void setMontoRecaudado(Integer montoRecaudado) {
        this.montoRecaudado = montoRecaudado;
    }
    public Integer getPorcentageMin() { return this.porcentajeMin; }
    public Integer getMontoRecaudado(){
        return montoRecaudado;
    }
    public Integer getCantidadDePoblacionParaProyecto() {
        return this.getLocalidad().getCantidadDePoblacion();
    }
    private Integer getMultiplicadorDeBono() {return this.multiplicadorDeBono;}

    public Integer darPuntosPorDonacion(int cantidadDeDineroADonar) {
        if(cantidadDeDineroADonar < 1000){
            return 0;
        }else{
            return cantidadDeDineroADonar * this.getMultiplicadorDeBono();
        }
    }

    public void recibirDonancion(Integer cantidadDeDinero){
        this.setMontoRecaudado(this.getMontoRecaudado() + cantidadDeDinero);
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

    public void finalizarElDiaDe(LocalDate fechaDeFinalizacion) {
        if(noEsProyectoFinalizable(fechaDeFinalizacion)){
            throw new ProyectoNoFinalizableException("El proyecto no llego ni a la recaudacion ni a la fecha de fin");
        }
    }

    private boolean noEsProyectoFinalizable(LocalDate fechaDeFinalizacion) {
        return fechaDeFinalizacion.isBefore(this.fechaFin) || this.getMontoRecaudado() < this.calcularDineroDefault();
    }


}




