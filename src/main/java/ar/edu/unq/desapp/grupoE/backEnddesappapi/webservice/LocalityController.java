package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.LocalityWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.service.LocalityService;
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
@RequestMapping("/locality")
@CrossOrigin
public class LocalityController {

    @Autowired
    private LocalityService localityService;

    @GetMapping("/all")
    public List<Locality> getAll(){
        return localityService.getAll();
    }

    @GetMapping("getByName/{name}")
    public Locality getByName(@PathVariable String name) {return localityService.getByName(name);}

    @DeleteMapping("delete/{name}")
    public List deleteByName(@PathVariable String name) {return localityService.deleteByName(name);}

    @PostMapping("/create")
    public Locality create_locality(@Valid @RequestBody LocalityWrapper new_locality) {
        return localityService.save_locality(new_locality);
    }

    @GetMapping("/topOldestDonation")
    public List<Locality> getTopTenOfOldestDonation(){return this.localityService.getTopTenOldestdonation();}

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
