package ar.edu.unq.desapp.grupoE.backEnddesappapi;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.LocalityRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.ProjectRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LocalityRepository localityRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        userRepository.save(new User("usuarioUno", "usario@gmail.com", "1234", "nickname"));

        Locality localidadUno = new Locality("localidad uno", "tucuman", 100, false);
        Locality localidadDos = new Locality("localidad dos", "chaco", 3200, true);
        Locality localidadTres = new Locality("localidad tres", "san juan", 800, false);
        Locality localidadCuatro = new Locality("localidad cuatro", "lanus", 1100, false);
        Locality localidadCinco = new Locality("localidad cinco", "la pampa", 400000, false);
        Locality localidadSeis = new Locality("localidad seis", "la rioja", 120000, true);
        Locality localidadSiete = new Locality("localidad siete", "salta", 50, true);
        Locality localidadOcho = new Locality("localidad ocho", "misiones", 8000, false);

        localityRepository.save(localidadUno);
        localityRepository.save(localidadDos);
        localityRepository.save(localidadTres);
        localityRepository.save(localidadCuatro);
        localityRepository.save(localidadCinco);
        localityRepository.save(localidadSeis);
        localityRepository.save(localidadSiete);
        localityRepository.save(localidadOcho);

        projectRepository.save(new Project("tucuman conecta2", 90,  LocalDate.now(), LocalDate.now().plusYears(1), 7600, localidadUno));
        projectRepository.save(new Project("trato chacho", 10,  LocalDate.now(), LocalDate.now().plusYears(1),1000, localidadDos));
        projectRepository.save(new Project("san wifi", 90,  LocalDate.now(), LocalDate.now().plusYears(1), 1000, localidadTres));
        projectRepository.save(new Project("lanus con luz y wifi", 90,  LocalDate.now(), LocalDate.now().plusYears(1), 1000, localidadCuatro));
        projectRepository.save(new Project("pampa la", 90,  LocalDate.now(), LocalDate.now().plusYears(1), 140, localidadCinco));
        projectRepository.save(new Project("la rioja no se sonrioja", 90,  LocalDate.now(), LocalDate.now().plusYears(1), 12000, localidadSeis));
        projectRepository.save(new Project("ataca salta", 90,  LocalDate.now(), LocalDate.now().plusYears(1), 10, localidadSiete));
        projectRepository.save(new Project("Acciones de misiones", 90,  LocalDate.now(), LocalDate.now().plusYears(1), 5000, localidadOcho));
    }
}