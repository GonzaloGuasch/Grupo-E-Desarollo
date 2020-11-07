package ar.edu.unq.desapp.grupoE.backEnddesappapi.repository;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {


    Project findByprojectName(String projectName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query( value= "SELECT * FROM project WHERE end_date >= :today AND end_date <= :oneMonthFromToday",
            nativeQuery = true)
    List<Project> getProjectThatEndInAMonth(@Param("today")LocalDate today, @Param("oneMonthFromToday") LocalDate oneMonthFromToday);
}
