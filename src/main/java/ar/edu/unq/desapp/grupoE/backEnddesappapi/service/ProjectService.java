package ar.edu.unq.desapp.grupoE.backEnddesappapi.service;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers.ProjectWrapper;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.LocalityRepository;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private LocalityRepository localityRepository;

    public List<Project> getAll(){
        return this.projectRepository.findAll();
    }

    public Project save(ProjectWrapper project_to_save) {
        Locality locality_of_project = localityRepository.getLocalityByName(project_to_save.getLocali_name());
        Project project = new Project(project_to_save.getProjectName(), project_to_save.getPorcentageMin(), project_to_save.getStartDate(), project_to_save.getEndDate(), project_to_save.getFactor(), locality_of_project);
        return this.projectRepository.save(project);
    }
}
