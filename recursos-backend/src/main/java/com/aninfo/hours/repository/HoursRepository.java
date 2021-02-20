package com.aninfo.hours.repository;

import com.aninfo.hours.model.Hours;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface HoursRepository extends CrudRepository<Hours, Long> {

    Hours findHoursById(Long id);

    Collection<Hours> findByFile(Integer file);

    List<Hours> findByFileAndDate(Integer file, Integer date);
}