package org.example.apprenant.Services;


import org.example.apprenant.Entity.Brief;
import org.example.apprenant.Repositorie.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BriefService {

    @Autowired
    private BriefRepository briefRepository;

    public List<Brief> getAllBriefs() {
        return briefRepository.findAll();
    }

    public Optional<Brief> getBriefById(Long id) {
        return briefRepository.findById(id);
    }

    public Brief saveBrief(Brief brief) {
        return briefRepository.save(brief);
    }
}