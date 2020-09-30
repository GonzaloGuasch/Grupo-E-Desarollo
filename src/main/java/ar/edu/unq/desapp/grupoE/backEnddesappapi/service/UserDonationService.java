package ar.edu.unq.desapp.grupoE.backEnddesappapi.service;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.DonationRecordEntry;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.DonationRecordEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDonationService {

    @Autowired
    private DonationRecordEntryRepository donationRecordEntryRepository;

    public List<DonationRecordEntry> getAll(){
        return this.donationRecordEntryRepository.findAll();
    }

    public DonationRecordEntry save(DonationRecordEntry donationRecordEntry){
        return this.donationRecordEntryRepository.save(donationRecordEntry);
    }
}
