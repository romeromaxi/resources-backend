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

@ContextConfiguration(classes = MainApp.class)
@CucumberContextConfiguration
@SpringBootTest
public class HoursIntegrationServiceTest {

    @Autowired
    private HoursService hoursService;

    public Hours createHours(Integer file, Integer quantHours, Integer idTask, Integer date){
        return new Hours(file, idTask, quantHours, date);
    }

    public Hours saveHours(Hours hours){
        return hoursService.saveHours(hours);
    }

    public Hours changeHours(Long id, Integer newQuantHours) { return hoursService.changeHours(id, newQuantHours);}

}
