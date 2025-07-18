package com.example.resourceservice.controller;

import com.example.resourceservice.entity.Resource;
import com.example.resourceservice.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "*")
public class ResourceController {
    
    @Autowired
    private ResourceService resourceService;
    
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('FORMATEUR') or hasRole('APPRENANT')")
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FORMATEUR') or hasRole('APPRENANT')")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        Optional<Resource> resource = resourceService.getResourceById(id);
        return resource.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/my")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FORMATEUR') or hasRole('APPRENANT')")
    public ResponseEntity<List<Resource>> getMyResources(Authentication authentication) {
        String email = authentication.getName();
        List<Resource> resources = resourceService.getResourcesByCreatedBy(email);
        return ResponseEntity.ok(resources);
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('FORMATEUR')")
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource, Authentication authentication) {
        String email = authentication.getName();
        resource.setCreatedBy(email);
        Resource createdResource = resourceService.createResource(resource);
        return ResponseEntity.ok(createdResource);
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FORMATEUR')")
    public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody Resource resource) {
        try {
            Resource updatedResource = resourceService.updateResource(id, resource);
            return ResponseEntity.ok(updatedResource);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        try {
            resourceService.deleteResource(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Accès réservé aux administrateurs");
    }
    
    @GetMapping("/formateur")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FORMATEUR')")
    public ResponseEntity<String> formateurOnly() {
        return ResponseEntity.ok("Accès réservé aux formateurs et administrateurs");
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Resource Service is running");
    }
}