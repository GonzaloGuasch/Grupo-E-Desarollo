package ar.edu.unq.desapp.grupoE.backEnddesappapi.repository;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {

    @Query( value= "SELECT * FROM locality WHERE name = :locality_name",
            nativeQuery = true)
    Locality getLocalityByName(@Param("locality_name") String locality_name);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query( value= "DELETE FROM locality WHERE name = :locality_name",
            nativeQuery = true)
    Integer deleteByName(@Param("locality_name") String locality_name);

    @Query(value =  "SELECT l1.id, l1.amount_of_population, l1.is_connected, l1.name, l1.province  " +
                    "FROM donation_record_entry " +
                        "FULL JOIN project as p1  ON donation_record_entry.project_name = p1.project_name " +
                        "FULL JOIN locality as l1 ON p1.project_name = l1.name " +
            "ORDER BY donation_date " +
            "DESC " +
            "LIMIT 10", nativeQuery = true)
    List<Locality> getTopTenWithOldestDonation();
}
