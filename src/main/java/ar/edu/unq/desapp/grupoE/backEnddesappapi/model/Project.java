package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.exceptions.ProjectCloseException;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.exceptions.ProjectNotFinalizableException;
import net.bytebuddy.implementation.bytecode.Throw;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Project {

    @Column(unique=true)
    @NotBlank(message = "Project Name is required")
    private String projectName;

    @Column
    @NotNull(message = "Porcentage Min is required")
    private Integer porcentageMin;

    @Column
    @NotNull(message = "Start Date is required")
    private LocalDate startDate;

    @Column
    @NotNull(message = "End Date is required")
    private LocalDate endDate;

    @Column
    @NotNull(message = "Factor is required")
    private Integer factor;

    @OneToOne
    private Locality locality;

    @Column
    @NotNull(message = "Amount Collected is required")
    private Integer amountCollected;

    @Column
    @NotNull(message = "Bonus Multiplier is required")
    private Integer bonusMultiplier;

    @Column
    private Boolean isFinished;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Project(){}

    public Project(String projectName, Integer porcentageMin, LocalDate startDate, LocalDate endDate, Integer factor, Locality locality) {
        this.projectName = projectName;
        this.porcentageMin = porcentageMin;
        this.startDate = startDate;
        this.endDate = endDate;
        this.factor = factor;
        this.locality = locality;
        this.amountCollected = 0;
        this.isFinished = false;
        if(locality != null && locality.getAmountOfPopulation() < 2000){
            this.bonusMultiplier = 2;
        }else{
            this.bonusMultiplier = 1;
        }
    }

    public Project(String projectName, LocalDate startDate, LocalDate endDate, Locality locality) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.locality = locality;

        this.amountCollected = 0;
        this.porcentageMin = 100;
        this.factor = 1000;
    }
    public Long getId(){return id;}
    public String getProjectName() { return projectName; }
    public Integer getFactor() { return factor; }
    public Locality getLocality()
    {
        return locality;
    }
    public void setAmountCollected(Integer amountCollected) {
        this.amountCollected = amountCollected;
    }
    public Integer getPorcentageMin() { return this.porcentageMin; }
    public Integer getAmountCollected(){
        return amountCollected;
    }
    public Integer getAmountOfPopulationForProject() {
        return this.getLocality().getAmountOfPopulation();
    }
    private Integer getBonusMultiplier() {return this.bonusMultiplier;}
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    public Integer givePointsForDonation(int amountOfMoneyToDonate) {
        if(amountOfMoneyToDonate < 1000){
            return 0;
        }else{
            return amountOfMoneyToDonate * this.getBonusMultiplier();
        }
    }

    public void receiveDonation(Integer amountOfMoney) {
        if(this.isFinished){
            throw new ProjectCloseException("This project is alredy close, you cannot donate anymore");
        }else {
            this.setAmountCollected(this.getAmountCollected() + amountOfMoney);
        }
    }

    public Integer calculateMoneyBasedOnfactor() {
        return this.getAmountOfPopulationForProject() * (this.getFactor());
    }

    public Integer calculateMoneyDefault() {
        return this.getAmountOfPopulationForProject() * 1000;
    }

    public boolean haveFactorCustom() {
        return this.getFactor() != 0;
    }

    public void endTheDayOf(LocalDate finishDate) {
        if(itIsNotFinalizableProject(finishDate)){
            throw new ProjectNotFinalizableException("El proyecto no llego ni a la recaudacion ni a la fecha de fin");
        } else {
            this.isFinished = true;
        }
    }

    private boolean itIsNotFinalizableProject(LocalDate finishDate) {
        return this.isFinished || finishDate.isBefore(this.endDate) || this.getAmountCollected() < this.calculateMoneyBasedOnfactor();
    }


}




