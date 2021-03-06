package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.Month;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class DonationRecordEntry {

    @Column
    @NotBlank(message = "Project Name is required")
    private String projectDonatedName;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Donation Date is required")
    private LocalDate donationDate;

    @Column
    @NotNull(message = "Donation Amount is required")
    @Min(value = 1, message = "Minimum amount is 1")
    private Integer donatedAmount;

    @Column
    private String comment;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="donation_record_entry_id")
    private Long id;

    public DonationRecordEntry(){ }

    public DonationRecordEntry(String projectDonatedName, LocalDate donationDate, Integer amountDonated, String comment) {
        this.projectDonatedName = projectDonatedName;
        this.donationDate = donationDate;
        this.donatedAmount = amountDonated;
        this.comment = comment;
    }

    public Boolean itsMonth(Month monthOfDonation) {
        return this.donationDate.getMonth() == monthOfDonation;
    }
    public Integer getDonatedAmount(){ return donatedAmount; }
    public String getprojectName(){ return projectDonatedName; }
    public Long getId(){ return id; }
    public String getProjectDonatedName() { return projectDonatedName; }
    public LocalDate getDonationDate() { return donationDate; }
    public String getComment() { return comment; }
}
