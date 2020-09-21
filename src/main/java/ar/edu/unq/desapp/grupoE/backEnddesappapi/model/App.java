package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import java.util.ArrayList;
import java.util.List;


public class App {
    private List<Project> projects;
    private List<User> users;

    public App() {
        this.projects = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addProject(Project project){
        this.getProjects().add(project);
    }

    public void addUser(User user){
        this.getUsers().add(user);
    }

    public Integer calculateMoneyNeededToProvideInternet(Project project){
        if(project.haveFactorCustom()){
            return (project.calculateMoneyBasedOnfactor());
        }
            else{
                return (project.calculateMoneyDefault());
        }
    }

    public List<Project> topTenDonations(){
        List<Project> topProjects = new ArrayList<>();
        Project projectToCompare = projects.get(0);
        Integer count = 10;
        for (Project project : projects){
            if (project.getAmountCollected() > projectToCompare.getAmountCollected() && count > 0){
                    topProjects.add(project);
                    count -= 1;
            }
            if (count > 0){
                topProjects.add(projectToCompare);
                count -= 1;
            }

        }
        return topProjects;
    }
}
