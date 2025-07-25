package org.example.apprenant.Repositorie;

import org.example.apprenant.Entity.Brief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BriefRepository extends JpaRepository<Brief, Long> {

    @Query("SELECT b from Brief b where b.dateDebut between :date1 and :date2 ")
    List<Brief> getdatebetwenn(LocalDate date1, LocalDate date2);
}