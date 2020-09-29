package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.exceptions.ProjectNotFinalizableException;

import java.time.LocalDate;

public class ProjectMock extends Project {
    private LocalDate finishDate;
    private LocalDate startDate;
    private Integer raisedMoney;
    private Integer moneyRaised;

    public ProjectMock(String projectName, Integer minimunPorcentage, LocalDate startDate, LocalDate finishDate, Integer factor, Locality locality) {
        super(projectName, minimunPorcentage, startDate, finishDate, factor, locality);
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.raisedMoney = 100;
        this.moneyRaised = 90;
    }

    public ProjectMock(LocalDate startDate, LocalDate finishDate, Integer minimunCollected, Integer collected) {
        super(null, minimunCollected, startDate, finishDate, null ,null);
        this.startDate = startDate;
        this.finishDate = finishDate;

        this.raisedMoney = 100;
        this.moneyRaised = 90;
    }
    public void receiveDonation(Integer amountOfMoney){
    }

    public void endTheDayOf(LocalDate finishDate) {
        if(noEsProyectoFinalizable(finishDate)){
            throw new ProjectNotFinalizableException("The project nither reach the collected money nor finish date");
        }
    }

    private boolean noEsProyectoFinalizable(LocalDate fechaDeFinalizacion) {
        return fechaDeFinalizacion.isBefore(this.finishDate) || this.raisedMoney < this.moneyRaised;
    }
}
