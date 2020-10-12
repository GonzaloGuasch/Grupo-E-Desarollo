package ar.edu.unq.desapp.grupoE.backEnddesappapi.modelTest;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalityMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest {
    Project project;
    LocalityMock locality;
    LocalDate startDate;
    LocalDate endDate;

    @BeforeEach
    public void setUp(){
        startDate = LocalDate.of(2019,10,01);
        endDate = LocalDate.of(2020,10,01);
        locality = new LocalityMock(null,null,500,null);
        project = new Project("Initial Project",10, startDate, endDate,2000, locality);
    }
    @Test
    public void testANewProjectIsCreatedAndIVerifyThatItsNameIsCorrect(){
        assertEquals(project.getProjectName(),"Initial Project");
    }

    @Test
    void testGivenAProjectWithAFactorOfTwoThousandIVerifyThatItIsTheCorrect()
    {
        assertEquals(project.getFactor(), 2000);
    }

    @Test
    void testGivenAProjectWithALocalityIVerifyThatItIsTheCorrect(){
        assertEquals(project.getLocality(), locality);
    }

    @Test
    void testGivenAProjectThatReceivesADonationOf10000IVerifyThatYourAmountOfMoneyIsCorrect(){
        project.receiveDonation(10000);
        assertEquals(project.getAmountCollected(), 10000);
    }

    @Test
    void testGivenAProjectWithFactor2000IVerifyThatYourMoneyBasedOnTheFactorIsCorrect(){
        assertEquals(project.calculateMoneyBasedOnfactor(),1000000);
    }

    @Test
    void testByDefaultAProjectHasAThousandAnd100PercentFactorToCompleteIt() {
        Project project_default = new Project("Project default", startDate, endDate, locality);

        assertEquals(project_default.getFactor(), 1000);
        assertEquals(project_default.getPorcentageMin(), 100);
    }

    @Test
    public void testGivenAProjectWithoutVerifyTheMoneyNeededToProvideInternet(){
        Project projectWithOutFactor = new Project("Project WithoutFactor",startDate,endDate,locality);

        assertEquals(projectWithOutFactor.calculateMoneyDefault(),500000);
    }


}
