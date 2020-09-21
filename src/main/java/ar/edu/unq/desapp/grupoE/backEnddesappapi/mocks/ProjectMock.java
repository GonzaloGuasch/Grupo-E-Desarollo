package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.ProjectNotFinalizableException;

import java.time.LocalDate;

public class ProjectMock extends Project {
    private LocalDate fechaFin;
    private LocalDate fechaInicio;
    private Integer montoRecadudao;
    private Integer montoTotal;

    public ProjectMock(String projectName, Integer minimunPorcentage, LocalDate startDate, LocalDate finishDate, Integer factor, Locality locality) {
        super(projectName, minimunPorcentage, startDate, finishDate, factor, locality);
        this.fechaInicio = startDate;
        this.fechaFin = finishDate;
        this.montoRecadudao = 100;
        this.montoTotal = 90;
    }

    public ProjectMock(LocalDate startDate, LocalDate finishDate, Integer minimunCollected, Integer collected) {
        super(null, minimunCollected, startDate, finishDate, null ,null);
        this.fechaInicio = startDate;
        this.fechaFin = finishDate;

        this.montoRecadudao = 100;
        this.montoTotal = 90;
    }
    public void receiveDonation(Integer amountOfMoney){
    }

    public void endTheDayOf(LocalDate finishDate) {
        if(noEsProyectoFinalizable(finishDate)){
            throw new ProjectNotFinalizableException("The project nither reach the collected money nor finish date");
        }
    }

    private boolean noEsProyectoFinalizable(LocalDate fechaDeFinalizacion) {
        return fechaDeFinalizacion.isBefore(this.fechaFin) || this.montoRecadudao < this.montoTotal;
    }
}
