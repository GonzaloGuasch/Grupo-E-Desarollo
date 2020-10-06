package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.service.UserDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDonationService userDonationService;

    @GetMapping("/all")
    public List<User> getAll(){ return userDonationService.getAllUsers();}

    @PostMapping("/create")
    public User create(@RequestBody User user){ return userDonationService.createUser(user);}

    @DeleteMapping("/delete/{name}")
    public List deleteByName(@PathVariable String name){return userDonationService.deleteUserByName(name);}
}
