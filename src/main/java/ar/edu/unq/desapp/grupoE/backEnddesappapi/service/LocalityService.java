package ar.edu.unq.desapp.grupoE.backEnddesappapi.service;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    public List<Locality> getAll() {
        return localityRepository.findAll();
    }

    public Locality save_locality(Locality new_locality) {
        return this.localityRepository.save(new_locality);
    }
}
