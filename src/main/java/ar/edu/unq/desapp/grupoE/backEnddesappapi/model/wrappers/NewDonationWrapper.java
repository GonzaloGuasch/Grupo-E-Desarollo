package ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers;

public class NewDonationWrapper {
    private String username;
    private Integer amountDonated;
    private String projectName;
    private String comment;

    public String getUsername() {
        return username;
    }
    public String getComment() { return comment; }
    public Integer getAmountDonated() {
        return amountDonated;
    }
    public String getProjectName() {
        return projectName;
    }
}
