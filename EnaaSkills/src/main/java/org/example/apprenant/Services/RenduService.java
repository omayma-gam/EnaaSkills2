package org.example.apprenant.Services;

import org.example.apprenant.DTO.RenduDto;
import org.example.apprenant.Entity.Rendus;
import org.example.apprenant.Mapper.RenduMapper;
import org.example.apprenant.Repositorie.RenduRepo;

import java.util.List;

public class RenduService {

    private final RenduRepo renduRepo;
    private RenduMapper renduMapper;

    public RenduService(RenduRepo renduRepo, RenduMapper renduMapper) {
        this.renduRepo = renduRepo;
        this.renduMapper = renduMapper;
    }

    public RenduDto AjouterRendu(RenduDto renduDto){
        Rendus rendus=renduMapper.dtoToEntity(renduDto);
        Rendus rendus1=renduRepo.save(rendus);

        return  renduMapper.entityToDto(rendus1);
    }

    public List<Rendus> ListRendus(){
        return renduRepo.findAll();
    }

    public RenduDto modifierRendus(RenduDto renduDto,Long id){
        Rendus rendus=renduRepo.findById(id).orElse(null);
        if (rendus==null){
            throw new RuntimeException("Aucune Compétence");
        }
        rendus.setDatDepot(renduDto.getDatDepot());
        rendus.setBrief(renduDto.getBrief());
        rendus.setApprenant(renduDto.getApprenant());

        return renduMapper.entityToDto(rendus);
    }


    public void supprimerApprenant(Long id){
        renduRepo.deleteById(id);
    }

}
