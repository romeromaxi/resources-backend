package com.aninfo.recursos;

import com.aninfo.recursos.model.Resource;
import com.aninfo.recursos.service.ResourceService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })  //puede generar quilombo...
@RestController
public class DemoApplication {

    private ResourceService resourceService = new ResourceService();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/resources")
    public Vector<Resource> readFromExternalSystem() {
        return resourceService.readFromExternalSystem();
    }

}
