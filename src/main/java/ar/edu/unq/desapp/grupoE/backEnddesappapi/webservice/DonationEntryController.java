package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.DonationRecordEntry;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.service.UserDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donationEntry")
public class DonationEntryController {

    @Autowired
    private UserDonationService userDonationService;

    @GetMapping("/all")
    public List<DonationRecordEntry> getAll(){
        return this.userDonationService.getAll();
    }

    @PostMapping("/create")
    public DonationRecordEntry create(@RequestBody DonationRecordEntry donationRecordEntryToSave){
        return this.userDonationService.save(donationRecordEntryToSave);
    }
}
