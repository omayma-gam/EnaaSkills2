package org.example.apprenant.Repositorie;

import org.example.apprenant.Entity.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepo extends JpaRepository<Apprenant,Long> {
}
