package com.aninfo.hours.repository;

import com.aninfo.hours.model.Hours;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@Configuration
public class RepositoryConfig extends RepositoryRestController  {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Hours.class);
    }
}