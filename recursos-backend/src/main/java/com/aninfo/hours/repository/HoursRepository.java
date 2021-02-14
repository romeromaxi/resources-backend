package com.aninfo.hours.repository;

import com.aninfo.hours.model.Hours;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HoursRepository extends CrudRepository<Hours, Long> {
}