package ar.edu.unq.desapp.grupoE.backEnddesappapi.repository;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
