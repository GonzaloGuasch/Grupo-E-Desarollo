package ar.edu.unq.desapp.grupoE.backEnddesappapi;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.UserAdmin;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.LocalityRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.ProjectRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.UserAdminRepository;
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
    private UserAdminRepository userAdminRepository;
    @Autowired
    private LocalityRepository localityRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        userRepository.save(new User("usuarioUno", "gonzaloguasch98@gmail.com", "1234", "nickname"));
        userAdminRepository.save(new UserAdmin("usuarioAdmin", "gonzaloguasch98@gmail.com", "1234", "el+kpo"));
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

        LocalDate endDateOne = LocalDate.of(2020, 7, 10);
        LocalDate endDateTwo = LocalDate.of(2020, 1, 12);
        LocalDate endDateThree = LocalDate.of(2024, 2, 5);
        LocalDate endDateFour = LocalDate.of(2032, 2, 28);
        LocalDate endDateFive = LocalDate.of(2020, 1, 1);
        LocalDate endDateSix = LocalDate.of(2120, 12, 5);
        LocalDate endDateSeven = LocalDate.now();
        LocalDate endDateEight = LocalDate.now().plusMonths(1);

        Project projectSeven = new Project("ataca salta", 90,  LocalDate.now().plusDays(30), endDateSeven, 10, localidadSiete);
        projectSeven.receiveDonation(20000);
        projectRepository.save(new Project("tucuman conecta2", 90,  LocalDate.now().plusDays(1), endDateOne, 7600, localidadUno));
        projectRepository.save(new Project("trato chacho", 10,  LocalDate.now().plusDays(20), endDateTwo,1000, localidadDos));
        projectRepository.save(new Project("san wifi", 90,  LocalDate.now().plusDays(25), endDateThree, 1000, localidadTres));
        projectRepository.save(new Project("lanus con luz y wifi", 90,  LocalDate.now().plusDays(12), endDateFive, 1000, localidadCuatro));
        projectRepository.save(new Project("pampa la", 90,  LocalDate.now().plusDays(8), endDateFour, 140, localidadCinco));
        projectRepository.save(new Project("la rioja no se sonrioja", 90, LocalDate.now().plusDays(9), endDateSix, 12000, localidadSeis));
        projectRepository.save(projectSeven);
        projectRepository.save(new Project("Acciones de misiones", 90,  LocalDate.now().plusDays(1), endDateEight, 5000, localidadOcho));
    }
}