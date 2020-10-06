package ar.edu.unq.desapp.grupoE.backEnddesappapi.service;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.DonationRecordEntry;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.DonationRegistry;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.DonationRegistryWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.DonationRecordEntryRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDonationService {

    @Autowired
    private DonationRecordEntryRepository donationRecordEntryRepository;
    @Autowired
    private UserRepository userRepository;

    public List<DonationRecordEntry> getAll(){
        return this.donationRecordEntryRepository.findAll();
    }

    public DonationRecordEntry save(DonationRecordEntry donationRecordEntry){
        return this.donationRecordEntryRepository.save(donationRecordEntry);
    }

    public DonationRegistry createDonationRegistry(DonationRegistryWrapper donationRegistryWrapper) {
        //todo ver si es necesario hacer este metodo
        return null;
    }

    public List<User> getAllUsers() { return this.userRepository.findAll(); }

    public User createUser(User user) { return this.userRepository.save(user); }

    public List deleteUserByName(String name) {
        this.userRepository.deleteByName(name);
        return new ArrayList();
    }

    public List<DonationRecordEntry> getTopTenDonations() {
        return this.donationRecordEntryRepository.getTopTen();
    }
}
