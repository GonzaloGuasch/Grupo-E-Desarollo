package ar.edu.unq.desapp.grupoE.backEnddesappapi;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalityMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.UserMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.App;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest {

    LocalityMock localityQuilmes, localityBernal, localityBegui, localityDonBosco, localityAvellaneda, localityVarela, localitySolano, localityHudson, localityBosques, localityElPato, localityEzpeleta, localityGutierrez;
    LocalDate startDate;
    LocalDate endDate;
    Project projectQ, projectB, projectBE, projectDB, projectAV, projectVA, projectSO, projectHU, projectEZ, projectGU, projectBQ, projectEP;
    App app = new App();
    List<Project> projects = new ArrayList<>();
    UserMock usuario;
    List<UserMock> usuarios = new ArrayList<>();


    @BeforeAll
    public void setUp() {
        startDate = LocalDate.of(2019, 10, 01);
        endDate = LocalDate.of(2020, 10, 01);

        localityQuilmes = new LocalityMock("Quilmes", "Buenos Aires", 1500, false);

        projectQ = new Project("ProyectoQuilmes", 10, startDate, endDate, 2000, localityQuilmes);
        projectB = new Project("ProyectoBernal", 20, startDate, endDate, 2000, localityBernal);
        projectBE = new Project("ProyectoBerazategui", 30, startDate, endDate, 2000, localityBegui);
        projectDB = new Project("ProyectoDonBosco", 40, startDate, endDate, 2000, localityDonBosco);
        projectAV = new Project("ProyectoAvellaneda", 50, startDate, endDate, 2000, localityAvellaneda);
        projectVA = new Project("ProyectoVarela", 60, startDate, endDate, 2000, localityVarela);
        projectSO = new Project("ProyectoSolano", 20, startDate, endDate, 2000, localitySolano);
        projectHU = new Project("ProyectoHudson", 30, startDate, endDate, 2000, localityHudson);
        projectEZ = new Project("ProyectoEzpeleta", 40, startDate, endDate, 2000, localityEzpeleta);
        projectGU = new Project("ProyectoGutierrez", 50, startDate, endDate, 2000, localityGutierrez);
        projectBQ = new Project("ProyectoBosques", 10, startDate, endDate, 2000, localityBosques);
        projectEP = new Project("ProyectoElPato", 20, startDate, endDate, 2000, localityElPato);


        projects = new ArrayList<>();
        projects.add(projectQ);

        usuario = new UserMock("Willy", "willy@gmail.com", "willy", "willy");
        usuarios = new ArrayList<>();
        usuarios.add(usuario);

        app = new App();
        app.addProject(projectQ);
        app.addProject(projectAV);
        app.addProject(projectB);
        app.addProject(projectBE);
        app.addProject(projectBQ);
        app.addProject(projectDB);
        app.addProject(projectEP);
        app.addProject(projectEZ);
        app.addProject(projectSO);
        app.addProject(projectGU);
        app.addProject(projectHU);
        app.addProject(projectVA);

        app.addUser(usuario);

    }

    @Test
    public void testAnInitialAppIsCreatedWithAProjectAndAUser(){
        App appInitial = new App();

        assertEquals(appInitial.getUsers().size(),0);
        assertEquals(appInitial.getProjects().size(),0);

    }

    @Test
    public void testIcreateAnAppAndAddAUserAndAProject(){
        App newApp = new App();
        newApp.addProject(projectQ);
        newApp.addUser(usuario);
        assertEquals(newApp.getUsers().size(),1);
        assertEquals(newApp.getProjects().size(),1);

    }


    @Test
    public void testGivenAnAppAndAProjectVerifyTheMoneyNeededToProvideInternet(){
        assertEquals(app.calculateMoneyNeededToProvideInternet(projectQ),3000000);
    }

    @Test
    public void testGivenAnAppWithTwelveProjectsIVerifyTheTopTenDonations(){
        assertEquals(app.topTenDonations().size(),10);
    }

}
