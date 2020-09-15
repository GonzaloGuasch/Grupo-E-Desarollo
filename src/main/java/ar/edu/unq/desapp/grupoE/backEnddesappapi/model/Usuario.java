package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.ProyectoMock;


public class Usuario {
    private String nombreUsuario;
    private String email;
    private String contrasenia;
    private String apodo;
    private Integer cantidadDePuntos;
    private RegistroDeDonaciones registrodeDonaciones;


    public Usuario(String nombreUsuario, String email, String contrasenia, String apodo){
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasenia = contrasenia;
        this.apodo = apodo;
        this.cantidadDePuntos = 0;
        this.registrodeDonaciones = new RegistroDeDonaciones();
    }

    public Integer getCantidadDePuntos() { return cantidadDePuntos; }
    public RegistroDeDonaciones getRegistrodeDonaciones() { return registrodeDonaciones; }

    public void donarAPor(ProyectoMock proyectoParaDonar, int cantidadDeDineroADonar) {
        Integer  puntosPorDonacion = proyectoParaDonar.recibirDonancion(cantidadDeDineroADonar);
        Integer puntosPorBono = this.getRegistrodeDonaciones().registrarNuevaDonacion(proyectoParaDonar.getNombre(), cantidadDeDineroADonar);
        this.sumarPuntos(puntosPorDonacion + puntosPorBono);

    }

    private void sumarPuntos(Integer cantidadDePuntosParaSumar) {
        this.cantidadDePuntos = this.getCantidadDePuntos() + cantidadDePuntosParaSumar;
    }

    public Integer cantidadDeDonacionesHistoricas() {
        return this.getRegistrodeDonaciones().cantidadDeRegistros();
    }
}
