package com.codecipta.service;

import com.codecipta.dao.starter.entity.StarterEntity;
import com.codecipta.dao.starter.repository.StarterRepository;
import com.codecipta.helper.response.ResponseTemplate;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class StarterService {

    @Inject
    StarterRepository starterRepository;

    public ResponseTemplate<?> starterServiceMethod() {
        List<StarterEntity> entityList =  starterRepository.GetAllData();

        return ResponseTemplate.<List<StarterEntity>>builder()
                .responseCode(Response.Status.OK.getStatusCode())
                .isSuccess(Boolean.TRUE)
                .responseMessage(Response.Status.OK.getReasonPhrase())
                .responseData(entityList)
                .build();
    }
}
