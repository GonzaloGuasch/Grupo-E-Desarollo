package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.Month;
import javax.persistence.*;

@Entity
public class DonationRecordEntry {

    @Column
    private String projectName;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate donationDate;

    @Column
    private Integer donatedAmount;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="donation_record_entry_id")
    private Long id;

    public DonationRecordEntry(){ }


    public DonationRecordEntry(String projectName, LocalDate donationDate, Integer amountDonated) {
        this.projectName = projectName;
        this.donationDate = donationDate;
        this.donatedAmount = amountDonated;
    }

    public Boolean itsMonth(Month monthOfDonation) {
        return this.donationDate.getMonth() == monthOfDonation;
    }
    public Integer getDonatedAmount(){ return donatedAmount; }
    public String getprojectName(){ return projectName; }
    public Long getId(){ return id; }
}
