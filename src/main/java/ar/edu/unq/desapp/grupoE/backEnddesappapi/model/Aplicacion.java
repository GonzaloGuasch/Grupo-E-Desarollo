package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.UsuarioMock;

import java.util.ArrayList;
import java.util.List;


public class Aplicacion  {
    private List<Proyecto> proyectos;
    private List<UsuarioMock> usuarios;

    public Aplicacion() {
        this.proyectos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public List<UsuarioMock> getUsuarios() {
        return usuarios;
    }

    public void agregarProyecto(Proyecto proyecto){
        this.getProyectos().add(proyecto);
    }

    public void agregarUsuarios(UsuarioMock usuario){
        this.getUsuarios().add(usuario);
    }

    public Integer calcularDineroNecesarioParaProveerInternet(Proyecto proyecto){
        if(proyecto.getFactor() != 0){
            return (proyecto.getLocalidad().getCantidadDePoblacion()) * (proyecto.getFactor());
        }
            else{
                return (proyecto.getLocalidad().getCantidadDePoblacion() * 1000);
        }
    }

    public List<Proyecto> topDiezDeDonaciones(){
        List<Proyecto> topDeProyectos = new ArrayList<>();
        Proyecto proyectoAComparar = proyectos.get(0);
        Integer contador = 10;
        for (Proyecto proyecto : proyectos){
            if (proyecto.getMontoRecaudado() > proyectoAComparar.getMontoRecaudado() && contador > 0){
                    topDeProyectos.add(proyecto);
                    contador -= 1;
            }
            if (contador > 0){
                topDeProyectos.add(proyectoAComparar);
                contador -= 1;
            }

        }
        return topDeProyectos;
    }
}
