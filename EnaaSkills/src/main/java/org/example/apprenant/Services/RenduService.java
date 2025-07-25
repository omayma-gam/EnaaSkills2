package org.example.apprenant.Services;


import org.example.apprenant.Entity.Rendu;
import org.example.apprenant.Repositorie.RenduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenduService {


    private final RenduRepository renduRepository;

    public RenduService(RenduRepository renduRepository) {
        this.renduRepository = renduRepository;
    }

    public Rendu saveRendu(Rendu rendu) {
        return renduRepository.save(rendu);
    }
}