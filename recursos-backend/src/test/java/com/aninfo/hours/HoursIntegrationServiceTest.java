package com.aninfo.hours;

import com.aninfo.MainApp;
import com.aninfo.hours.model.Hours;
import com.aninfo.hours.service.HoursService;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;
import java.util.Collection;

@ContextConfiguration(classes = MainApp.class)
@CucumberContextConfiguration
@SpringBootTest
public class HoursIntegrationServiceTest {

    @Autowired
    private HoursService hoursService;

    public Hours createHours(Integer file, Integer quantHours, Integer minutes, Integer idProject, Integer idTask, Integer date){
        return new Hours(file, idProject, idTask, quantHours, minutes, date);
    }

    public Hours saveHours(Hours hours){
        return hoursService.saveHours(hours);
    }

    public Hours changeHours(Long id, Integer newQuantHours) { return hoursService.changeHours(id, newQuantHours);}

    public Hours changeMinutes(Long id, Integer newQuantMinutes) { return hoursService.changeMinutes(id, newQuantMinutes);}

    public void deleteById(Long id){
        hoursService.deleteById(id);
    }

    public Optional<Hours> findById(Long idHours) {
        return hoursService.findById(idHours);
    }

    public Collection<Hours> findByFile(Integer file) {
        return hoursService.findByFile(file);
    }
}
