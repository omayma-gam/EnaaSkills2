package com.example.resourceservice.service;

import com.example.resourceservice.entity.Resource;
import com.example.resourceservice.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    
    @Autowired
    private ResourceRepository resourceRepository;
    
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
    
    public Optional<Resource> getResourceById(Long id) {
        return resourceRepository.findById(id);
    }
    
    public List<Resource> getResourcesByCreatedBy(String createdBy) {
        return resourceRepository.findByCreatedBy(createdBy);
    }
    
    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }
    
    public Resource updateResource(Long id, Resource resource) {
        if (resourceRepository.existsById(id)) {
            resource.setId(id);
            return resourceRepository.save(resource);
        }
        throw new RuntimeException("Ressource non trouvée avec l'id : " + id);
    }
    
    public void deleteResource(Long id) {
        if (resourceRepository.existsById(id)) {
            resourceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ressource non trouvée avec l'id : " + id);
        }
    }
}