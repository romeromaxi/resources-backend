package com.aninfo;

import com.aninfo.recursos.model.Resource;
import com.aninfo.recursos.service.ResourceService;

import com.aninfo.hours.model.Hours;
import com.aninfo.hours.service.HoursService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Collection;
import java.util.Vector;
import java.util.Optional;

@RestController
@SpringBootApplication
public class MainApp extends SpringBootServletInitializer {
    private ResourceService resourceService = new ResourceService();

    @Autowired
    private HoursService hoursService;

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @GetMapping("/resources")
    public Vector<Resource> readFromExternalSystem() {
        return resourceService.readFromExternalSystem();
    }

    @PostMapping("/hours")
    @ResponseStatus(HttpStatus.CREATED)
    public Hours createAccount(@RequestBody Hours hours) {
        return hoursService.saveHours(hours);
    }

    @GetMapping("/hours")
    public Collection<Hours> getHours(){
        return hoursService.getHours();
    }

    @GetMapping("/hours/{id}")
    public ResponseEntity<Hours> getHours(@PathVariable long id){
        Optional<Hours> hoursOptional = hoursService.findById(id);
        return ResponseEntity.of(hoursOptional);
    }

    @DeleteMapping("/hours/{id}")
    public void deleteHours(@PathVariable Long id) {
        hoursService.deleteById(id);
    }

    @PutMapping("hours/{id}")
    public ResponseEntity<Hours> updateHours(@RequestBody Hours hours, @PathVariable Long id){
        Optional<Hours> hoursOptional = hoursService.findById(id);

        if (!hoursOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        hours.setId(id);
        hoursService.saveHours(hours);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/hours/{id}/changeHours")
    public Hours changeHours(@RequestBody Integer hoursToChange, @PathVariable Long id) {
        return hoursService.changeHours(id, hoursToChange);
    }

    @PatchMapping("/hours/{id}/changeDate")
    public Hours changeDate(@RequestBody Integer newDate, @PathVariable Long id){
        return hoursService.changeDate(id, newDate);
    }

    @PatchMapping("/hours/{id}/changeIdTask")
    public Hours changeTask(@RequestBody Integer newIdTask, @PathVariable Long id){
        return hoursService.changeTask(id, newIdTask);
    }

}
