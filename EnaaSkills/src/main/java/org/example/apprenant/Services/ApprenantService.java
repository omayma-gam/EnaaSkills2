package org.example.apprenant.Services;

import org.example.apprenant.Entity.Apprenant;
import org.example.apprenant.Repositorie.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ApprenantService {

    @Autowired
    private ApprenantRepository apprenantRepository;

    public List<Apprenant> getAllApprenants() {
        return apprenantRepository.findAll();
    }

    public Optional<Apprenant> getApprenantById(Long id) {
        return apprenantRepository.findById(id);
    }

    public Apprenant saveApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }
}