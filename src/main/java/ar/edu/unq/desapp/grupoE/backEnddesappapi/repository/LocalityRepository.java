package ar.edu.unq.desapp.grupoE.backEnddesappapi.repository;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {

    @Query( value= "SELECT * FROM locality WHERE name = :locality_name",
            nativeQuery = true)
    Locality getLocalityByName(@Param("locality_name") String locality_name);

}
