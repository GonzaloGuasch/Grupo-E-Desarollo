package ar.edu.unq.desapp.grupoE.backEnddesappapi.model.wrappers;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;


public class ProjectWrapper {

    private String projectName;
    private Integer porcentageMin;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Integer factor;
    private String localityName;

    public String getProjectName() {
        return projectName;
    }

    public Integer getPorcentageMin() {
        return porcentageMin;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Integer getFactor() {
        return factor;
    }

    public String getLocalityName() {
        return localityName;
    }
}
