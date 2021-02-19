package com.aninfo.hours.service;

import com.aninfo.hours.exceptions.InvalidHoursException;
import com.aninfo.hours.exceptions.InvalidMinutesException;
import com.aninfo.hours.exceptions.NoLoadedHoursException;
import com.aninfo.hours.model.Hours;
import com.aninfo.hours.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
        LocalDate today = LocalDate.now();
        int todayInt = today.getYear() * 10000 + today.getMonthValue() * 100 + today.getDayOfMonth();
        hours.setLoadingDate(todayInt);
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

    public Collection<Hours> findByFile(Integer file) {

        Collection<Hours> hoursList = hoursRepository.findByFile(file);
        if(hoursList.isEmpty())
            throw new NoLoadedHoursException("There are no hours loaded for that resource");

        return hoursList;
    }

    @Transactional
    public Hours changeHours(Long id, Integer newQuantHours) {
        Hours hours = hoursRepository.findHoursById(id);

        if (newQuantHours > 24 || newQuantHours < 1){
            throw new InvalidHoursException("Hours loaded must be between 1 and 24");
        }

        hours.setQuantityHours(newQuantHours);
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

    public Hours changeTask(Long id, Integer newIdTask) {
        Hours hours = hoursRepository.findHoursById(id);

        hours.setTask(newIdTask);
        hoursRepository.save(hours);

        return hours;
    }

    @Transactional
    public Hours changeMinutes(Long id, Integer newQuantMinutes) {
        Hours hours = hoursRepository.findHoursById(id);

        if (newQuantMinutes >= 60 || newQuantMinutes < 0){
            throw new InvalidMinutesException("Minutes loaded must be between 0 and 59");
        }

        if ((hours.getQuantityMinutes() + newQuantMinutes) >= 60){
            hours.setQuantityHours(hours.getQuantityHours() + 1);
            hours.setQuantityMinutes(hours.getQuantityMinutes() + newQuantMinutes - 60);
        } else {
            hours.setQuantityMinutes(hours.getQuantityMinutes() + newQuantMinutes);
        }

        hoursRepository.save(hours);

        return hours;
    }
}
