package com.course.coursedemoapp.service;

import com.course.coursedemoapp.dto.CompanyDto;
import com.course.coursedemoapp.jobs.CompanyListJob;
import com.course.coursedemoapp.jobs.CompanyQuoteJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;


@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyListJob companyListJob;

    private final ExecutorService executorService;

    private final CompanyQuoteJob companyQuoteJob;


    @Scheduled(initialDelay = 1000, fixedDelay = Long.MAX_VALUE)
    @Override
    public void getCompaniesFromAPI() throws ExecutionException, InterruptedException {
        CompletableFuture<CompanyDto[]> stockCompanyTask = CompletableFuture
                .supplyAsync(companyListJob::getCompaniesDto, executorService);

        stockCompanyTask.thenAccept(result -> {
            log.info("applying result in service");
            getCompanyQuotes(result);
        });
    }

    private void getCompanyQuotes(CompanyDto[] result) {
        for (CompanyDto companyDto : result) {
            if (companyDto.isEnabled()) {
                executorService.submit(() -> companyQuoteJob.getCompanyQuote(companyDto.getSymbol()), executorService);
            }
        }
    }
}
