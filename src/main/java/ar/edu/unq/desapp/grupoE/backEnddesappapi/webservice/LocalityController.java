package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.LocalityWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public Locality create_locality(@RequestBody LocalityWrapper new_locality) {
        return localityService.save_locality(new_locality);
    }

    @GetMapping("/topOldestDonation")
    public List<Locality> getTopTenOfOldestDonation(){return this.localityService.getTopTenOldestdonation();}
}
