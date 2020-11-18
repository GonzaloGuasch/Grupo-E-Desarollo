package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Locality {

    @Column(unique=true)
    @NotBlank(message = "Name is required")
    private String name;

    @Column
    @NotBlank(message = "Province is required")
    private String province;

    @Column
    @NotNull(message = "Amount Of Population is required")
    private Integer amountOfPopulation;

    @Column
    private Boolean isConnected;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Locality() {}
    public Locality(String name, String province, Integer amountOfPopulation, Boolean isConnected) {
        this.name = name;
        this.province = province;
        this.amountOfPopulation = amountOfPopulation;
        this.isConnected = isConnected;
    }

    public String getName() {
        return this.name;
    }
    public String getProvince() {return this.province;}
    public Integer getAmountOfPopulation() {
        return this.amountOfPopulation;
    }
    public Boolean getisConnected() { return this.isConnected; }
    public Long getId(){ return id; }
}
