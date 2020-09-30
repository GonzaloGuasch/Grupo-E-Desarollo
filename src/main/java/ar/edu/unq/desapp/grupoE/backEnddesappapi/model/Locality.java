package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;
import javax.persistence.*;

@Entity
public class Locality {

    @Column(unique=true)
    private String name;

    @Column
    private String province;

    @Column
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
