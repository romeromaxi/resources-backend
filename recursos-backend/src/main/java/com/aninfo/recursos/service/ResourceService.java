package com.aninfo.recursos.service;

import com.aninfo.recursos.model.Resource;
import com.aninfo.recursos.repository.ResourceRepository;
import org.springframework.http.ResponseEntity;

import java.util.Vector;

public class ResourceService {

    ResourceRepository resourceRepository = new ResourceRepository();

    public Vector<Resource> readFromExternalSystem(){
        ResponseEntity<Vector<Resource>> response = resourceRepository.readFromExternalSystem();
        Vector<Resource> resources = response.getBody();

        return resources;
    }
}
