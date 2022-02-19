package com.course.coursedemoapp.jobs;

import com.course.coursedemoapp.dto.CompanyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
@Slf4j
public class CompanyListJob implements Runnable {
    @Autowired
    RestTemplate restTemplate;

    private CompanyDto[] companiesDto;

    public CompanyDto[] getCompaniesDto() {
        log.info("Updating company info");
        String url = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
        try {
            companiesDto = restTemplate.getForObject(new URI(url), CompanyDto[].class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        log.info("Retrieved " + companiesDto.length + " companies");
        return companiesDto;
    }

    @Override
    public void run() {
        getCompaniesDto();
    }
}

