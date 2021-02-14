package com.aninfo.hours.service;

import com.aninfo.hours.model.Hours;
import com.aninfo.hours.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class HoursService {

    @Autowired
    private HoursRepository hoursRepository;

    public Hours saveHours(Hours hours) {
        return hoursRepository.save(hours);
    }

    public Collection<Hours> getHours(){
        Collection<Hours> hours = new ArrayList<>();
        hoursRepository.findAll().forEach(hours::add);
        return hours;
    }
}
