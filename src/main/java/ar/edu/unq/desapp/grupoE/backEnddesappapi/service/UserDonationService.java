package ar.edu.unq.desapp.grupoE.backEnddesappapi.service;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.Encoder;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.DonationRecordEntry;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.UserAdmin;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.UserCreateWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.UserLoginWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.DonationRecordEntryRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.UserAdminRepository;
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
    @Autowired
    private UserAdminRepository userAdminRepository;
    private Encoder encoder = new Encoder();


    public List<DonationRecordEntry> getAll(){
        return this.donationRecordEntryRepository.findAll();
    }

    public DonationRecordEntry save(DonationRecordEntry donationRecordEntry){
        return this.donationRecordEntryRepository.save(donationRecordEntry);
    }

    public List<User> getAllNormalUsers() { return this.userRepository.findAll(); }

    public String createUser(UserCreateWrapper user) {
        User userToSave = new User(user.getUserName(),user.getEmail(), user.getPassword(), user.getNickName());
        this.userRepository.save(userToSave);
        return user.getUserName();
    }

    public List deleteUserByName(String name) {
        this.userRepository.deleteByName(name);
        return new ArrayList();
    }

    public List<DonationRecordEntry> getTopTenDonations() {
        return this.donationRecordEntryRepository.getTopTen();
    }


    public Integer amountOfPointsFor(String userName) {
        User user = this.userRepository.findByuserName(userName);
        return user.getAmountOfPoints();
    }

    public List<DonationRecordEntry> getDonationRecordsOf(String username) {
        User user = this.userRepository.findByuserName(username);
        return user.getAllDonationsRecords();
    }

    public List<UserAdmin> getAllAdmins() {
        return this.userAdminRepository.findAll(); }

    public String tryLogIn(UserLoginWrapper userLoginWrapper) {
        User user = this.userRepository.findByuserName(userLoginWrapper.getusername());
        if(userLoginWrapper.getPassword().equals(user.getPassword())) {
            return user.getUserName();
        }
        return null;
    }

    public User isUserRegister(String userEmail) {
        return this.userRepository.findByemail(userEmail);
    }

    public Boolean isUserAdmin(String username) {
        User user = this.userRepository.findByuserName(username);
        return user.isAdmin();
    }
}
