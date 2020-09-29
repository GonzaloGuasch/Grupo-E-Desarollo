package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import javax.persistence.*;

import java.time.LocalDate;

@Entity
public class User {

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nickName;

    @Column
    private Integer amountOfPoints;

    @Column
    @OneToOne
    private DonationRegistry donationRegistry;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public User(){}

    public User(String userName, String email, String password, String nickName){
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.amountOfPoints = 0;
        this.donationRegistry = new DonationRegistry();
    }

    public Integer getAmountOfPoints() { return amountOfPoints; }
    private DonationRegistry getDonationRegistry() { return donationRegistry; }

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

    public Long getId(){ return id;}
}
