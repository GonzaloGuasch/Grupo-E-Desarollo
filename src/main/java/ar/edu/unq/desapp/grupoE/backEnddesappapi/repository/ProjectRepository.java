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


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query( value=  "SELECT email " +
                    "FROM \"user_of_app\" as u " +
                    "JOIN donation_registry as d " +
                    "ON u.donation_registry_id = d.id " +
                    "JOIN donation_registry_donations_registry_record as rr " +
                    "ON rr.donation_registry_id = d.id " +
                    "JOIN donation_record_entry as dr " +
                    "ON dr.donation_record_entry_id = rr.donations_registry_record_donation_record_entry_id " +
                    "JOIN project as p " +
                    "ON p.project_name = dr.project_name; ",
            nativeQuery = true)
    List<String> getAllMailsOfDonors();

    @Modifying(clearAutomatically = true)
    @Query( value=  "SELECT * " +
                    "FROM project " +
                    "LIMIT 3 " +
                    "OFFSET :page_number",
            nativeQuery = true)
    List<Project> getPageProjects(@Param("page_number") Integer page_number);

    @Modifying(clearAutomatically = true)
    @Query( value=  "SELECT * " +
                    "FROM project " +
                    "WHERE project.project_name " +
                    "LIKE %:projectString%",
            nativeQuery = true)
    List<Project> getProjectsThatMatches(@Param("projectString") String projectString);
}
