package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;


import java.time.LocalDate;


public class User {
    private String userName;
    private String email;
    private String password;
    private String nickName;
    private Integer amountOfPoints;
    private DonationRegistry donationRegistry;


    public User(String userName, String email, String password, String nickName){
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.amountOfPoints = 0;
        this.donationRegistry = new DonationRegistry();
    }

    public Integer getAmountOfPoints() { return amountOfPoints; }
    public DonationRegistry getDonationRegistry() { return donationRegistry; }

    public void donateFor(Project projectToDonate, int amountOfMoneyToDonate) {
        Integer  pointsForDonation = projectToDonate.givePointsForDonation(amountOfMoneyToDonate);
        Integer pointsForBonus = this.getDonationRegistry().giveBonusIfItIsTheSecondDonationOfTheMonth(LocalDate.now().getMonth());

        projectToDonate.receiveDonation(amountOfMoneyToDonate);
        this.getDonationRegistry().registerNewDonation(projectToDonate.getProjectName(), amountOfMoneyToDonate);


        this.scorePoints(pointsForDonation + pointsForBonus);
    }

    private void scorePoints(Integer amountOfPointsToAdd) {
        this.amountOfPoints = this.getAmountOfPoints() + amountOfPointsToAdd;
    }

    public Integer amountOfHistoricalDonations() {
        return this.getDonationRegistry().amountOfRecords();
    }
}
