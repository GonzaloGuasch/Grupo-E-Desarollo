package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class DonationRegistry {

    @OneToMany(cascade=CascadeType.ALL)
    private List<DonationRecordEntry> donationsRegistryRecord;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public DonationRegistry(){
        this.donationsRegistryRecord = new ArrayList<>();
    }

    public Integer giveBonusIfItIsTheSecondDonationOfTheMonth(Month monthOfDonation) {
        Integer bonusAmount = 0;
         for(DonationRecordEntry donationRecordEntry : this.donationsRegistryRecord){
             if(donationRecordEntry.itsMonth(monthOfDonation)){
                 bonusAmount = 500;
             }
         }

        return bonusAmount;
    }
    public void registerNewDonation(String projectNameToDonate, Integer amountMoneyToDonate) {
        DonationRecordEntry newDonation = new DonationRecordEntry(projectNameToDonate, LocalDate.now(), amountMoneyToDonate);
        this.donationsRegistryRecord.add(newDonation);
    }


    public Integer amountOfRecords() {
        return this.donationsRegistryRecord.size();
    }

    public Long getId(){ return id;}
}
