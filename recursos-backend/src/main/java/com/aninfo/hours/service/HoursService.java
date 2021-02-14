package com.aninfo.hours.service;

import com.aninfo.hours.exceptions.InvalidHoursException;
import com.aninfo.hours.model.Hours;
import com.aninfo.hours.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class HoursService {

    @Autowired
    private HoursRepository hoursRepository;

    public Hours saveHours(Hours hours) {
        if(hours.getQuantityHours() > 24 || hours.getQuantityHours() <= 0)
            throw new InvalidHoursException("Hours loaded must be between 1 and 24");

        return hoursRepository.save(hours);
    }

    public Collection<Hours> getHours(){
        Collection<Hours> hours = new ArrayList<>();
        hoursRepository.findAll().forEach(hours::add);
        return hours;
    }

    public void deleteById(Long idHours) {
        hoursRepository.deleteById(idHours);
    }

    public Optional<Hours> findById(Long idHours) {
        return hoursRepository.findById(idHours);
    }

    @Transactional
    public Hours changeHours(Long id, Integer hoursToChange) {
        Hours hours = hoursRepository.findHoursById(id);

        if (hoursToChange + hours.getQuantityHours() > 24 || hoursToChange + hours.getQuantityHours() < 1){
            throw new InvalidHoursException("Hours loaded must be between 1 and 24");
        }

        hours.setQuantityHours(hours.getQuantityHours() + hoursToChange);
        hoursRepository.save(hours);

        return hours;
    }

    @Transactional
    public Hours changeDate(Long id, Integer newDate) {
        Hours hours = hoursRepository.findHoursById(id);

        hours.setDate(newDate);
        hoursRepository.save(hours);

        return hours;
    }
}
