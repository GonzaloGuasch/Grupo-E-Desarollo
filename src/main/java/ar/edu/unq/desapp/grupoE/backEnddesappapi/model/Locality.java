package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

public class Locality {
    private String name;
    private String province;
    private Integer amountOfPopulation;
    private Boolean isConnected;

    public Locality(String name, String province, Integer amountOfPopulation, Boolean isConnected) {
        this.name = name;
        this.province = province;
        this.amountOfPopulation = amountOfPopulation;
        this.isConnected = isConnected;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAmountOfPopulation() {
        return this.amountOfPopulation;
    }
}
