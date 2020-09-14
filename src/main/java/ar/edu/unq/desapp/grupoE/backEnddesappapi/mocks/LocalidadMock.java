package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;

public class LocalidadMock {
    private String nombre;
    private String provincia;
    private Integer cantidadDePoblacion;
    private Boolean estaConectada;

    public LocalidadMock(String nombre, String provincia, Integer cantidadDePoblacion, Boolean estaConectada) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.cantidadDePoblacion = cantidadDePoblacion;
        this.estaConectada = estaConectada;
    }

    public Integer getCantidadDePoblacion() {
        return cantidadDePoblacion;
    }

}
