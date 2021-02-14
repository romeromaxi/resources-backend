package com.aninfo.hours;

import com.aninfo.MainApp;
import com.aninfo.hours.model.Hours;
import com.aninfo.hours.service.HoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = MainApp.class)
@WebAppConfiguration
public class HoursIntegrationServiceTest {

    @Autowired
    HoursService hoursService;

    public Hours createHours(Integer file, Integer quantHours, Integer idTask){
        return new Hours(file, quantHours, idTask);
    }

    public Hours saveHours(Hours hours){
        return hoursService.saveHours(hours);
    }

}
