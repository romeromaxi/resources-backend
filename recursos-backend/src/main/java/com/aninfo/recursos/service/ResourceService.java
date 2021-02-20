package com.aninfo.recursos.service;

import com.aninfo.recursos.exceptions.ResourceNotFoundException;
import com.aninfo.recursos.model.Resource;
import com.aninfo.recursos.repository.ResourceRepository;
import org.springframework.http.ResponseEntity;

import java.util.Vector;

public class ResourceService {

    ResourceRepository resourceRepository = new ResourceRepository();

    public Vector<Resource> readAllFromExternalSystem(){
        ResponseEntity<Vector<Resource>> response = resourceRepository.readFromExternalSystem();
        Vector<Resource> resources = response.getBody();

        return resources;
    }

    public Resource readOneFromExternalSystem(int file){
        ResponseEntity<Vector<Resource>> response = resourceRepository.readFromExternalSystem();
        Vector<Resource> resources = response.getBody();

        for (Resource resource : resources){
            if(resource.getFile() == file)
                return resource;
        }

        throw new ResourceNotFoundException("There is no resource with that file number");
    }
}
