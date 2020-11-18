package ar.edu.unq.desapp.grupoE.backEnddesappapi.service;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.LocalityWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.LocalityRepository;
//import jdk.vm.ci.meta.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    public List<Locality> getAll() {
        return localityRepository.findAll();
    }

    public Locality save_locality(LocalityWrapper new_locality) {
        Locality locality_to_save = new Locality(new_locality.getName(), new_locality.getProvince(), new_locality.getAmountOfPopulation(), new_locality.getIsConnected());
        return this.localityRepository.save(locality_to_save);
    }

    public Locality getByName(String name) { return this.localityRepository.getLocalityByName(name);
    }

    public List deleteByName(String name) {
         this.localityRepository.deleteByName(name);
         return new ArrayList();
    }

    public List<Locality> getTopTenOldestdonation() {
        return this.localityRepository.getTopTenWithOldestDonation();
    }
}
