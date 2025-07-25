package org.example.commpetence.Config;

import org.example.commpetence.Models.Competence;
import org.example.commpetence.Models.Sous_Competence;
import org.example.commpetence.Repositories.CompetenceRepo;
import org.example.commpetence.Repositories.Sous_CompetenceRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedData(CompetenceRepo competenceRepo, Sous_CompetenceRepo sousCompetenceRepo) {
        return args -> {
            if (competenceRepo.count() > 0) return; // Empêche la duplication si déjà rempli

            List<Competence> allCompetences = new ArrayList<>();

            for (int i = 1; i <= 100; i++) {
                Competence competence = new Competence();
                competence.setNom("Compétence " + i);
                competence.setDescription("Description de la compétence " + i);
                competence.setEtatValidation(false);

                // Crée 4 sous-compétences
                List<Sous_Competence> sousCompetences = new ArrayList<>();
                for (int j = 1; j <= 4; j++) {
                    Sous_Competence sous = new Sous_Competence();
                    sous.setNom("Sous-compétence " + j + " de compétence " + i);
                    sous.setDescription("Description de la sous-compétence " + j);
                    sous.setEtatValidation(false);
                    sous.setCompetence(competence); // association
                    sousCompetences.add(sous);
                }

                competence.setSousCompetences(sousCompetences);
                allCompetences.add(competence);
            }

            competenceRepo.saveAll(allCompetences); // Cascade ne gère pas OneToMany sans persist explicite
            sousCompetenceRepo.saveAll(
                    allCompetences.stream()
                            .flatMap(c -> c.getSousCompetences().stream())
                            .toList()
            );

            System.out.println("✅ Base de données peuplée avec 100 compétences et 400 sous-compétences.");
        };
    }
}
