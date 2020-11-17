package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.CloseProjectWrapper;
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

    @GetMapping("/get/{page_number}")
    public List<Project> getPageNumber(@PathVariable Integer page_number){return projectService.getPageNumber(page_number);}
    @GetMapping("/moneyToCollect/{projectName}")
    public Integer getTotalAmountOfMoney(@PathVariable String projectName){ return projectService.getTotalOfMoneyNeeded(projectName);}
    @PostMapping("/save")
    public Project save_new_project(@RequestBody ProjectWrapper project_to_save) {
        return this.projectService.save(project_to_save);
    }

    @PostMapping("/makeDonation")
    public Integer makeNewDonation(@RequestBody NewDonationWrapper newDonation) {
        return this.projectService.makeDonation(newDonation);
    }

    @GetMapping("/getProjectsNearEndDate/")
    public List<Project> getProjectsNearEndDate() {return this.projectService.getProjectsNearEndDate();}

    @PostMapping("/closeProject")
    public void closeProject(@RequestBody CloseProjectWrapper closeProjectWrapper) throws Exception {this.projectService.closeProject(closeProjectWrapper);}
}
