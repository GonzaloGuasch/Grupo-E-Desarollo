package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import java.time.LocalDate;

public class Project {
    private String projectName;
    private Integer porcentageMin;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer factor;
    private Localidad locality;
    private Integer amountCollected;
    private Integer bonusMultiplier;

    public Project(String projectName, Integer porcentageMin, LocalDate startDate, LocalDate endDate, Integer factor, Localidad locality) {
        this.projectName = projectName;
        this.porcentageMin = porcentageMin;
        this.startDate = startDate;
        this.endDate = endDate;
        this.factor = factor;
        this.locality = locality;
        this.amountCollected = 0;

        if(locality != null && locality.getCantidadDePoblacion() < 2000){
            this.bonusMultiplier = 2;
        }else{
            this.bonusMultiplier = 1;
        }
    }

    public Project(String projectName, LocalDate startDate, LocalDate endDate, Localidad locality) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.locality = locality;

        this.amountCollected = 0;
        this.porcentageMin = 100;
        this.factor = 1000;
    }

    public String getProjectName() { return projectName; }
    public Integer getFactor() { return factor; }
    public Localidad getLocality()
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
    public Integer getCantidadDePoblacionParaProyecto() {
        return this.getLocality().getCantidadDePoblacion();
    }
    private Integer getBonusMultiplier() {return this.bonusMultiplier;}

    public Integer givePointsForDonation(int amountOfMoneyToDonate) {
        if(amountOfMoneyToDonate < 1000){
            return 0;
        }else{
            return amountOfMoneyToDonate * this.getBonusMultiplier();
        }
    }

    public void receiveDonation(Integer amountOfMoney){
        this.setAmountCollected(this.getAmountCollected() + amountOfMoney);
    }

    public Integer calculateMoneyBasedOnfactor() {
        return this.getCantidadDePoblacionParaProyecto() * (this.getFactor());
    }

    public Integer calculateMoneyDefault() {
        return this.getCantidadDePoblacionParaProyecto() * 1000;
    }

    public boolean haveFactorCustom() {
        return this.getFactor() != 0;
    }

    public void endTheDayOf(LocalDate finishDate) {
        if(itIsNotFinalizableProject(finishDate)){
            throw new ProyectoNoFinalizableException("El proyecto no llego ni a la recaudacion ni a la fecha de fin");
        }
    }

    private boolean itIsNotFinalizableProject(LocalDate finishDate) {
        return finishDate.isBefore(this.endDate) || this.getAmountCollected() < this.calculateMoneyDefault();
    }


}




