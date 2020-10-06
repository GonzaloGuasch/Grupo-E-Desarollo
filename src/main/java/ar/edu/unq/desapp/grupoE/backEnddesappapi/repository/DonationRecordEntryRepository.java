package ar.edu.unq.desapp.grupoE.backEnddesappapi.repository;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.DonationRecordEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRecordEntryRepository extends JpaRepository<DonationRecordEntry, Long> {

    @Query( value= "SELECT * FROM donation_record_entry ORDER BY donated_amount DESC LIMIT 10",
            nativeQuery = true)
    List<DonationRecordEntry> getTopTen();
}
