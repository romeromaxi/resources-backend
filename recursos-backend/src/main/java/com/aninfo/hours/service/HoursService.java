package com.aninfo.hours.service;

import com.aninfo.hours.model.Hours;
import com.aninfo.hours.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoursService {

    @Autowired(required=true)
    private HoursRepository hoursRepository;

    public Hours saveHours(Hours hours) {
        return hoursRepository.save(hours);
    }

}
