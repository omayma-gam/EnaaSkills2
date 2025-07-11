package org.example.apprenant.Repositorie;


import org.example.apprenant.Entity.BriefCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefCompetenceRepository extends JpaRepository<BriefCompetence, Long> {
}