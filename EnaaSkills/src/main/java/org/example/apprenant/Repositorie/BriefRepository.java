package org.example.apprenant.Repositorie;

import org.example.apprenant.Entity.Brief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefRepository extends JpaRepository<Brief, Long> {
}