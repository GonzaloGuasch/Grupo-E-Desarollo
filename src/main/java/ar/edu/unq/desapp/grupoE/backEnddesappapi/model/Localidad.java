package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

public class Localidad {
    private String nombre;
    private String provincia;
    private Integer cantidadDePoblacion;
    private Boolean estaConectada;

    public Localidad(String nombre, String provincia, Integer cantidadDePoblacion, Boolean estaConectada) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.cantidadDePoblacion = cantidadDePoblacion;
        this.estaConectada = estaConectada;
    }

    public String getnombre() {
        return this.nombre;
    }

    public Integer getCantidadDePoblacion() {
        return this.cantidadDePoblacion;
    }
}
