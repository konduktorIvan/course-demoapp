package com.course.coursedemoapp;


import model.CompanyDto;

import model.CompanyQuoteDto;
import model.CompanyQuoteEntity;
import model.CompanyQuoteRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories(basePackages = "model")
@ComponentScan(basePackages = "model")
@EntityScan(basePackages = "model")
public class CourseDemoappApplication {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ModelMapper modelMapper = new ModelMapper();
    private final Logger logger = LoggerFactory.getLogger(CourseDemoappApplication.class);
    private CompanyDto[] companiesDto;
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    @Autowired
    private CompanyQuoteRepository companyQuoteRepository;


    public static void main(String[] args) {
        SpringApplication.run(CourseDemoappApplication.class, args);
    }

    @Scheduled(initialDelay = 1000, fixedDelay = Long.MAX_VALUE)
    public void getCompaniesFromServer() throws URISyntaxException {
        logger.info("Updating company info");
        String url = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
        CompanyDto[] companiesDto = restTemplate.getForObject(new URI(url), CompanyDto[].class);
        logger.info("Retrieved " + companiesDto.length + " companies");
        logger.info("Started query company quote...");
        saveCompanyQueries();
    }

    @Scheduled (initialDelay = 10000, fixedDelay = Long.MAX_VALUE)
    public void saveCompanyQueries() throws URISyntaxException {
        logger.info("Started query company quote...");
        for (CompanyDto company : companiesDto) {
            if (company.isEnabled()) {
                createAndSaveQuoteQuery(company);
            }
        }
        getCompaniesFromServer();
    }

    public void createAndSaveQuoteQuery(CompanyDto companyDto) {
        if (companyDto.getSymbol() != null){
        String url = "https://sandbox.iexapis.com/stable/stock/" + companyDto.getSymbol() +
                "/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571";
        CompanyQuoteDto companyQuoteDto = restTemplate.getForObject(url, CompanyQuoteDto.class);
        CompanyQuoteEntity companyQuoteEntity = convertToEntity(companyQuoteDto);
        companyQuoteRepository.save(companyQuoteEntity);
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void showTopFive() {
        System.out.println("Top five companies by volume");
        for (CompanyQuoteEntity company: companyQuoteRepository.findTopFiveHighestVolume()) {
            System.out.println(company.getCompanyName() + " volume: " + company.getVolume());
        }
    }

    private CompanyQuoteEntity convertToEntity(CompanyQuoteDto companyQuoteDto) {
        return modelMapper.map(companyQuoteDto, CompanyQuoteEntity.class);
    }

}
