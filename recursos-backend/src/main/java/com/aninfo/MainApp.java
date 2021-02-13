package com.aninfo;

import com.aninfo.recursos.model.Resource;
import com.aninfo.recursos.service.ResourceService;

import com.aninfo.hours.model.Hours;
import com.aninfo.hours.service.HoursService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })  //puede generar quilombo...
@RestController
class MainApp {
    private ResourceService resourceService = new ResourceService();

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @GetMapping("/resources")
    public Vector<Resource> readFromExternalSystem() {
        return resourceService.readFromExternalSystem();
    }
}
