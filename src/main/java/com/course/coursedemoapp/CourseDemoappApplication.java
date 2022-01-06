package com.course.coursedemoapp;


import lombok.NonNull;
import model.CompanyDto;
import model.CompanyEntity;

import model.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//todo save in db
@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories(basePackages = "model")
@ComponentScan(basePackages = "model")
@EntityScan(basePackages ="model")
public class CourseDemoappApplication {

    @Autowired
    private CompanyRepository companyRepository;


    private RestTemplate restTemplate = new RestTemplate();
    CompanyDto[] companiesDto;
    public static void main(String[] args) {
        SpringApplication.run(CourseDemoappApplication.class, args);
    }

    //todo threads
    @Scheduled(fixedRate = 2000)
    public List<CompanyDto> getCompaniesFromServer() throws URISyntaxException {
        System.out.println("Updating company info");
        String url = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
        companiesDto = restTemplate.getForObject(new URI(url), CompanyDto[].class);
        System.out.println(companiesDto.length);
        return List.of(companiesDto);
    }


//    @Scheduled(fixedRate = 15000)
//    public void saveListOfCompaniesToDb() {
//        System.out.println("Saving company info");
//        CompanyEntity companyEntity;
//        for (CompanyDto companyDto : companiesDto) {
//            companyEntity = toCompanyEntity(companyDto);
//            companyRepository.save(companyEntity);
//        }
//    }

//    @Scheduled(fixedRate = 2000)
    public void addCompaniesToDB() {
        CompanyEntity testEntity = new CompanyEntity(
                "A",
                "XNYS",
                "qwe",
                "kNacgtncxneEY ocS Iwkeo rh ",
                "YNSX",
                "exEta g YN eIok cnnorcSwkch",
                "tehgnTileI.l Ac oscngeoin",
                LocalDate.now(),
                "cs",
                "IEX_46574843354B2D52",
                "US",
                "USD",
                true,
                "2W7RGIM8XPWUQX0729YA", "DV23G06CBB00",
                "1142938"
        );

        companyRepository.save(testEntity);

    }

    private CompanyEntity toCompanyEntity(@NonNull CompanyDto companyDto) {
        return new CompanyEntity(
                companyDto.getSymbol(),
                companyDto.getExchange(),
                companyDto.getExchangeSuffix(),
                companyDto.getExchangeName(),
                companyDto.getExchangeSegment(),
                companyDto.getExchangeSegmentName(),
                companyDto.getName(),
                companyDto.getDate(),
                companyDto.getType(),
                companyDto.getIexId(),
                companyDto.getRegion(),
                companyDto.getCurrency(),
                companyDto.isEnabled(),
                companyDto.getFigi(),
                companyDto.getCik(),
                companyDto.getLei()
                );
    }
}
