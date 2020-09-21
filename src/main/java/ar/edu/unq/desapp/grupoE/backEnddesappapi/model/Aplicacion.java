package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import java.util.ArrayList;
import java.util.List;


public class Aplicacion  {
    private List<Project> projects;
    private List<Usuario> usuarios;

    public Aplicacion() {
        this.projects = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public List<Project> getProyectos() {
        return projects;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarProyecto(Project project){
        this.getProyectos().add(project);
    }

    public void agregarUsuarios(Usuario usuario){
        this.getUsuarios().add(usuario);
    }

    public Integer calcularDineroNecesarioParaProveerInternet(Project project){
        if(project.haveFactorCustom()){
            return (project.calculateMoneyBasedOnfactor());
        }
            else{
                return (project.calculateMoneyDefault());
        }
    }

    public List<Project> topDiezDeDonaciones(){
        List<Project> topDeProjects = new ArrayList<>();
        Project projectAComparar = projects.get(0);
        Integer contador = 10;
        for (Project project : projects){
            if (project.getAmountCollected() > projectAComparar.getAmountCollected() && contador > 0){
                    topDeProjects.add(project);
                    contador -= 1;
            }
            if (contador > 0){
                topDeProjects.add(projectAComparar);
                contador -= 1;
            }

        }
        return topDeProjects;
    }
}
