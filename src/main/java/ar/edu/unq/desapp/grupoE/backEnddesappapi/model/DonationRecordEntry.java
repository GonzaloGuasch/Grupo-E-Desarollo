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
    private String projectName;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Donation Date is required")
    private LocalDate donationDate;

    @Column
    @NotNull(message = "Donation Amount is required")
    @Min(value = 2, message = "Minimum amount is 2")
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
