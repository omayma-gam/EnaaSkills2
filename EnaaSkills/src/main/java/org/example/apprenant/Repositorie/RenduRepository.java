package org.example.apprenant.Repositorie;


import org.example.apprenant.Entity.Rendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenduRepository extends JpaRepository<Rendu, Long> {
}