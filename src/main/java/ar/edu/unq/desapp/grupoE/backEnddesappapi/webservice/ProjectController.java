package ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.CloseProjectWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.NewDonationWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.ProjectWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.service.ProjectService;
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
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/all")
    public List<Project> getAllProjects(){
        return projectService.getAll();
    }

    @GetMapping("/getAnyProjectWith/{projectString}")
    public List<Project> getProjectThatMatch(@PathVariable String projectString){return projectService.getProjectsThatMatches(projectString);}

    @GetMapping("/get/{page_number}")
    public List<Project> getPageNumber(@PathVariable Integer page_number){return projectService.getPageNumber(page_number);}

    @GetMapping("/getByName/{projectName}")
    public Project getProyect(@PathVariable String projectName){return projectService.getProjetsByName(projectName);}
    @GetMapping("/moneyToCollect/{projectName}")
    public Integer getTotalAmountOfMoney(@PathVariable String projectName){ return projectService.getTotalOfMoneyNeeded(projectName);}

    @PostMapping("/save")
    public Project save_new_project(@RequestBody ProjectWrapper project_to_save) {
        return this.projectService.save(project_to_save);
    }

    @PostMapping("/makeDonation")
    public Integer makeNewDonation(@Valid @RequestBody NewDonationWrapper newDonation) {
        return this.projectService.makeDonation(newDonation);
    }
    @GetMapping("getComments/{project_name}")
    public List<String> getCommentsOf(@PathVariable String project_name){return this.projectService.getCommentsOf(project_name);}

    @GetMapping("/getProjectsNearEndDate/")
    public List<Project> getProjectsNearEndDate() {return this.projectService.getProjectsNearEndDate();}

    @PostMapping("/closeProject")
    public Object closeProject(@RequestBody CloseProjectWrapper closeProjectWrapper) throws Exception {return this.projectService.closeProject(closeProjectWrapper);}

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
