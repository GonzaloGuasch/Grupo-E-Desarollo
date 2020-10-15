package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.NewDonationWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.ProjectWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/all")
    public List<Project> getAllProjects(){
        return projectService.getAll();
    }

    @PostMapping("/save")
    public Project save_new_project(@RequestBody ProjectWrapper project_to_save) {
        return this.projectService.save(project_to_save);
    }

    @PostMapping("/makeDonation")
    public void makeNewDonation(@RequestBody NewDonationWrapper newDonation) {
        this.projectService.makeDonation(newDonation);
    }
}
