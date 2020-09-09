package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import java.time.LocalDate;
import java.time.Month;

public class EntradaDeRegistroDeDonacion {
    private String nombreProyecto;
    private LocalDate fechaDeDonacion;
    private Integer montoDonado;

    public EntradaDeRegistroDeDonacion(String nombreProyecto, LocalDate fechaDeDonacion, Integer montoDonado) {
        this.nombreProyecto = nombreProyecto;
        this.fechaDeDonacion = fechaDeDonacion;
        this.montoDonado = montoDonado;
    }

    public Boolean esDeMes(Month mesDeLaDonacion) {
        return this.fechaDeDonacion.getMonth() == mesDeLaDonacion;
    }
}
