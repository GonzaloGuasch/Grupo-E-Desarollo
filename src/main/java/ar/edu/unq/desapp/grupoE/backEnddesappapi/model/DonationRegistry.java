package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DonationRegistry {
    private List<DonationRecordEntry> donationRegistry;


    public DonationRegistry(){
        this.donationRegistry = new ArrayList<>();
    }

    public Integer giveBonusIfItIsTheSecondDonationOfTheMonth(Month monthOfDonation) {
        Integer bonusAmount = 0;
         for(DonationRecordEntry donationRecordEntry : this.donationRegistry){
             if(donationRecordEntry.itsMonth(monthOfDonation)){
                 bonusAmount = 500;
             }
         }

        return bonusAmount;
    }
    public void registerNewDonation(String projectNameToDonate, Integer amountMoneyToDonate) {
        DonationRecordEntry newDonation = new DonationRecordEntry(projectNameToDonate, LocalDate.now(), amountMoneyToDonate);
        this.donationRegistry.add(newDonation);
    }


    public Integer amountOfRecords() {
        return this.donationRegistry.size();
    }
}
