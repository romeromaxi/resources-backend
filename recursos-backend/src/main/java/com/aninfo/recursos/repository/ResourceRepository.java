package com.aninfo.recursos.repository;

import com.aninfo.recursos.model.Resource;

import java.util.Vector;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;

public class ResourceRepository {

    public ResponseEntity<Vector<Resource>> readFromExternalSystem(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Vector<Resource>> response = restTemplate.exchange(
                "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/recursos-psa/1.0.0/m/api/recursos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Vector<Resource>>(){});

        return response;
    }
}
