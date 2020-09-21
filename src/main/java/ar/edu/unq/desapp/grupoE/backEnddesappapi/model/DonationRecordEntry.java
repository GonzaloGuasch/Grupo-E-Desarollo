package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import java.time.LocalDate;
import java.time.Month;

public class DonationRecordEntry {
    private String projectName;
    private LocalDate donationDate;
    private Integer donatedAmount;

    public DonationRecordEntry(String projectName, LocalDate donationDate, Integer donatedAmount) {
        this.projectName = projectName;
        this.donationDate = donationDate;
        this.donatedAmount = donatedAmount;
    }

    public Boolean itsMonth(Month mesDeLaDonacion) {
        return this.donationDate.getMonth() == mesDeLaDonacion;
    }
}
