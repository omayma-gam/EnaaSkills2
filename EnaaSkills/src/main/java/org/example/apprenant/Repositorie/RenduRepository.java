package org.example.apprenant.Repositorie;



import org.example.apprenant.Entity.Rendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface RenduRepository extends JpaRepository<Rendu, Long> {
    @Query(value = "SELECT count(R) FROM Rendu R WHERE Apprenant.id=:id")
     int getnumberOfRendu(@PathVariable int id);
}