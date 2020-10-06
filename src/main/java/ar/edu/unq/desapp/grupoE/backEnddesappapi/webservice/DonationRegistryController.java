package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;


import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.DonationRegistry;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.DonationRegistryWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.service.UserDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donationRegistry")
public class DonationRegistryController {


    @Autowired
    private UserDonationService userDonationService;

    @RequestMapping("create")
    public DonationRegistry create(@RequestBody DonationRegistryWrapper donationRegistryWrapper){ return this.userDonationService.createDonationRegistry(donationRegistryWrapper);}
}
