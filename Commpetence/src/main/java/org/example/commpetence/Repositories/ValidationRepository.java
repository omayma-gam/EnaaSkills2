package org.example.commpetence.Repositories;


import org.example.commpetence.Models.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Long> {
    List<Validation> findByApprenantId(Long apprenantId);
    List<Validation> findByCompetenceId(Long competenceId);
    List<Validation> findByBriefId(Long briefId);
}