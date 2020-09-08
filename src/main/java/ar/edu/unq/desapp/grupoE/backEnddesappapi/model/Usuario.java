package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

public class Usuario {
    private String nombreUsuario;
    private String email;
    private String contraseña;
    private String apodo;
    private Integer cantidadDePuntos;


    public Usuario(String nombreUsuario, String email, String contraseña, String apodo){
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contraseña = contraseña;
        this.apodo = apodo;
        cantidadDePuntos = 0;
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public String getEmail() { return email; }
    public String getContraseña() { return contraseña; }
    public String getApodo() { return apodo; }
    public Integer getCantidadDePuntos() { return cantidadDePuntos; }

}
