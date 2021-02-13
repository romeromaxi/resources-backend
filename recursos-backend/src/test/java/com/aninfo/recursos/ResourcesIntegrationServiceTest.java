package com.aninfo.recursos;

import com.aninfo.recursos.model.Resource;
import com.aninfo.recursos.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Vector;

public class ResourcesIntegrationServiceTest {

    private ResourceService resourceService = new ResourceService();

    public Vector<Resource> readFromExternalSystem(){
        return resourceService.readFromExternalSystem();
    }
}
