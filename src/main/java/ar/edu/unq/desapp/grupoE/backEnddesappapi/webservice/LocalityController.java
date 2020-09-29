package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("locality")
public class LocalityController {

    @Autowired
    private LocalityService localityService;

    @GetMapping("/all")
    public List<Locality> getAll(){
        return localityService.getAll();
    }

    @PostMapping("/create")
    public Locality create_locality(@RequestBody Locality new_locality) { return localityService.save_locality(new_locality);}
}
