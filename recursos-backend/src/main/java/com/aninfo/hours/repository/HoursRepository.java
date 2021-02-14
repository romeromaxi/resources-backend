package com.aninfo.hours.repository;

import com.aninfo.hours.model.Hours;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoursRepository extends CrudRepository<Hours, Long> {

    Hours findHoursById(Long id);

}