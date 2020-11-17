package ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers;

public class LocalityWrapper {
    private String name;
    private String province;
    private Integer amountOfPopulation;
    private Boolean isConnected;

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }

    public Integer getAmountOfPopulation() {
        return amountOfPopulation;
    }

    public Boolean getIsConnected() {
        return isConnected;
    }
}
