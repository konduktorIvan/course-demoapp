package com.course.coursedemoapp;


import model.CompanyDto;

import model.CompanyQuoteDto;
import model.CompanyQuoteEntity;
import model.CompanyQuoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.net.URISyntaxException;


@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories(basePackages = "model")
@ComponentScan(basePackages = "model")
@EntityScan(basePackages = "model")
public class CourseDemoappApplication {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CompanyQuoteRepository companyQuoteRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    CompanyDto[] companiesDto;

    public static void main(String[] args) {
        SpringApplication.run(CourseDemoappApplication.class, args);
    }

    @Scheduled(initialDelay = 1000, fixedDelay = Long.MAX_VALUE)
    @Async
    public void getCompaniesFromServer() throws URISyntaxException {
        System.out.println("Updating company info");
        String url = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
        companiesDto = restTemplate.getForObject(new URI(url), CompanyDto[].class);
        System.out.println("Retrieved " + companiesDto.length + " companies");
        System.out.println("Started query company quote...");
        for (CompanyDto company : companiesDto) {
            if (company.isEnabled()) {
                createAndSaveQuoteQuery(company);
            }
        }
    }

    @Async
    public void createAndSaveQuoteQuery(CompanyDto companyDto) {
        String url = "https://sandbox.iexapis.com/stable/stock/" + companyDto.getSymbol() +
                "/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571";
        CompanyQuoteDto companyQuoteDto = restTemplate.getForObject(url, CompanyQuoteDto.class);
        CompanyQuoteEntity companyQuoteEntity = convertToEntity(companyQuoteDto);
        companyQuoteRepository.save(companyQuoteEntity);
    }

    private CompanyQuoteEntity convertToEntity(CompanyQuoteDto companyQuoteDto) {
        return modelMapper.map(companyQuoteDto, CompanyQuoteEntity.class);
    }

}
