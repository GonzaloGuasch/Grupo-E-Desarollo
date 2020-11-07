package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.DonationRecordEntry;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.UserAdmin;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.service.UserDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    @Autowired
    private UserDonationService userDonationService;

    @GetMapping("/allUsers")
    public List<User> getAllNormalUsers(){ return userDonationService.getAllNormalUsers();}

    @GetMapping("/allAdmins")
    public List<UserAdmin> getAllAdmins(){ return userDonationService.getAllAdmins();}

    @GetMapping("amountOfPoints/{userName}")
    public Integer getPoints(@PathVariable String userName){ return userDonationService.amountOfPointsFor(userName);}

    @PostMapping("/create")
    public User create(@Valid @RequestBody User user){ return userDonationService.createUser(user);}

    @DeleteMapping("/delete/{name}")
    public List deleteByName(@PathVariable String name){return userDonationService.deleteUserByName(name);}

    @GetMapping("/GetDonationsRecords/{username}")
    public List<DonationRecordEntry> getDonationsRecordsOf(@PathVariable String username) {return userDonationService.getDonationRecordsOf(username);}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
