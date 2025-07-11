package org.example.commpetence.Services;


import org.example.commpetence.Client.RenduClient;
import org.example.commpetence.DTO.ApprenantDTO;
import org.example.commpetence.DTO.BriefDTO;
import org.example.commpetence.Models.Competence;
import org.example.commpetence.Models.Validation;
import org.example.commpetence.Repositories.CompetenceRepo;
import org.example.commpetence.Repositories.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ValidationService {

    @Autowired
    private ValidationRepository validationRepository;

    @Autowired
    private CompetenceRepo competenceRepository;


    private RenduClient renduClient;



    public List<Validation> getValidationsByApprenantId(Long apprenantId) {
        return validationRepository.findByApprenantId(apprenantId);
    }

    public List<Validation> getValidationsByCompetenceId(Long competenceId) {
        return validationRepository.findByCompetenceId(competenceId);
    }

    public List<Validation> getAllValidations() {
        return validationRepository.findAll();
    }

    public Validation saveValidation(Validation validation) {
        Optional<Competence> competence = competenceRepository.findById(validation.getCompetenceId());
        if (competence.isEmpty()) {
            throw new RuntimeException("Compétence non trouvée avec l'ID : " + validation.getCompetenceId());
        }

        // Communication avec le service rendu pour vérifier l'apprenant et le brief
        try {
            ApprenantDTO apprenant = renduClient.getApprenantById(validation.getApprenantId());
            BriefDTO brief = renduClient.getBriefById(validation.getBriefId());

            System.out.println("Validation créée pour :");
            System.out.println("- Apprenant : " + apprenant.getPrenom() + " " + apprenant.getNom());
            System.out.println("- Brief : " + brief.getTitre());
            System.out.println("- Compétence : " + competence.get().getNom());

        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération des données du service rendu : " + e.getMessage());
            // On continue quand même la validation même si la communication échoue
        }

        return validationRepository.save(validation);
    }

    public void deleteValidation(Long id) {
        validationRepository.deleteById(id);
    }
}