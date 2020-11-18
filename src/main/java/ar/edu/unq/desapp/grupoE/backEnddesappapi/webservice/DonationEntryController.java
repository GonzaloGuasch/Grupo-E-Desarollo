package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.DonationRecordEntry;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.service.UserDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public DonationRecordEntry create(@Valid @RequestBody DonationRecordEntry donationRecordEntryToSave){
        return this.userDonationService.save(donationRecordEntryToSave);
    }

    @GetMapping("/topTenDonation")
    public List<DonationRecordEntry> getTopTen(){return this.userDonationService.getTopTenDonations();}

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
