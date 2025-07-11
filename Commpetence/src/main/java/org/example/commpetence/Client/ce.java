package org.example.commpetence.Client;


import org.example.commpetence.DTO.ApprenantDTO;
import org.example.commpetence.DTO.BriefDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "rendu-service", url = "http://localhost:8082")
public interface RenduClient {

    @GetMapping("/apprenants/{id}")
    ApprenantDTO getApprenantById(@PathVariable Long id);

    @GetMapping("/briefs/{id}")
    BriefDTO getBriefById(@PathVariable Long id);
}