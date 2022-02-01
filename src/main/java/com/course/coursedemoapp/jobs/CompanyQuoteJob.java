package com.course.coursedemoapp.jobs;

import com.course.coursedemoapp.dto.CompanyQuoteDto;
import com.course.coursedemoapp.entity.CompanyQuoteEntity;
import com.course.coursedemoapp.repository.CompanyQuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Component
public class CompanyQuoteJob implements Runnable {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    private CompanyQuoteDto companyQuoteDto;

    @Autowired
    private CompanyQuoteRepository companyQuoteRepository;

    @Override
    public void run() {

    }

    public void getCompanyQuote(String symbol) {
        String url = "https://sandbox.iexapis.com/stable/stock/" + symbol +
                "/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571";
        try {
            companyQuoteDto = restTemplate.getForObject(new URI(url), CompanyQuoteDto.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        CompanyQuoteEntity companyQuoteEntity = convertToEntity(companyQuoteDto);

        companyQuoteRepository.save(companyQuoteEntity);
    }

    private CompanyQuoteEntity convertToEntity(CompanyQuoteDto companyQuoteDto) {
        return modelMapper.map(companyQuoteDto, CompanyQuoteEntity.class);
    }

}

    //TODO: inveestigate how to make request for each company async
    // TIPS: CompletableFuture.runAsync, thenAccept
    // Request to the client should return Future
    //TODO: save with batches
