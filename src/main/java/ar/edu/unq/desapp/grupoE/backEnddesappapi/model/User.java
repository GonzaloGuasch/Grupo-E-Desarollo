package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="\"user_of_app\"")
public class User {

    @Column(unique=true)
    @NotBlank(message = "Name is required")
    @Size(min=4, max = 20)
    private String userName;

    @Column
    @NotBlank(message = "Email is required")
    @Email(message = "Incorrect email")
    private String email;

    @Column
    private String password;

    @Column
    @NotBlank(message = "Nickname is required")
    @Size(min = 4, max = 10)
    private String nickName;

    @Column
    private Integer amountOfPoints;

    @OneToOne(cascade = CascadeType.ALL)
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
    public String getUserName(){return userName;}
    public String getEmail(){return email;}
    public String password(){return password;}
    public String getNickName(){return nickName;}
    public Integer getAmountOfPoints() { return amountOfPoints; }
    public DonationRegistry getDonationRegistry() { return donationRegistry; }

    public List<DonationRecordEntry> getAllDonationsRecords() {
        return this.donationRegistry.getAllRecords();
    }
}
