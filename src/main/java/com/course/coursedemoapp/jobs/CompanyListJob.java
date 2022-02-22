package com.course.coursedemoapp.jobs;

import com.course.coursedemoapp.dto.CompanyDto;
import com.course.coursedemoapp.dto.CompanyQuoteDto;
import com.course.coursedemoapp.entity.CompanyQuoteEntity;
import com.course.coursedemoapp.repository.CompanyQuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class CompanyListJob {
    @Autowired
    RestTemplate restTemplate;


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CompanyQuoteRepository companyQuoteRepository;

    @Autowired
    private ExecutorService executorService;


    private CompanyDto[] companiesDto;

    public CompanyDto[] getCompaniesDto() {
        String url = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
        try {
            companiesDto = restTemplate.getForObject(new URI(url), CompanyDto[].class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return companiesDto;
    }

    public CompanyQuoteDto getCompanyQuote(String symbol) {
        CompanyQuoteDto companyQuoteDto = null;
        String url = "https://sandbox.iexapis.com/stable/stock/" + symbol +
                "/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571";
        try {
            companyQuoteDto = restTemplate.getForObject(new URI(url), CompanyQuoteDto.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return companyQuoteDto;
    }

    @Scheduled(initialDelay = 1000, fixedDelay = Long.MAX_VALUE)
    public void getCompaniesFromAPI() throws ExecutionException, InterruptedException {
        CompletableFuture<List<CompanyQuoteDto>> stockCompanyTask = CompletableFuture
                .supplyAsync(this::getCompaniesDto, executorService)
                .thenApply(this::getCompanyQuotes);

        stockCompanyTask.get();
    }


    private synchronized List<CompanyQuoteDto> getCompanyQuotes(CompanyDto[] result) {
        List<CompanyQuoteDto> companyQuoteDtos = new ArrayList<>();
        AtomicInteger i = new AtomicInteger();
        for (CompanyDto companyDto : result) {
            if (companyDto.isEnabled()) {
                executorService.submit(() -> {
                        log.info(i.incrementAndGet() + "");
                        companyQuoteDtos.add(getCompanyQuote(companyDto.getSymbol()));
                }, executorService);
            }
        }
        return companyQuoteDtos;
    }

    private List<CompanyQuoteEntity> toCompanyQuoteEntity(List<CompanyQuoteDto> companyQuoteDtos) {
        List<CompanyQuoteEntity> companyQuoteEntities = new ArrayList<>();
        for (CompanyQuoteDto companyQuoteDto : companyQuoteDtos) {
            companyQuoteEntities.add(modelMapper.map(companyQuoteDto, CompanyQuoteEntity.class));
        }
        return companyQuoteEntities;
    }

//    private void saveCompanyQuotesToDb() {
//        companyQuoteRepository.saveAll(new ArrayList<>(toCompanyQuoteEntity(companyQuoteDtos)));
//    }
}