//package com.course.coursedemoapp.service;
//
//import com.course.coursedemoapp.dto.CompanyDto;
//import com.course.coursedemoapp.dto.CompanyQuoteDto;
//import com.course.coursedemoapp.entity.CompanyQuoteEntity;
//import com.course.coursedemoapp.jobs.CompanyListJob;
//import com.course.coursedemoapp.repository.CompanyQuoteRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorService;
//
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class CompanyServiceImpl implements CompanyService {
//    private final CompanyListJob companyListJob;
//
//    List<CompanyQuoteDto> companyQuoteDtos;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    @Autowired
//    CompanyQuoteRepository companyQuoteRepository;
//
//    private final ExecutorService executorService;
//
//    @Override
//    public void getCompaniesFromAPI() throws ExecutionException, InterruptedException {
//        CompletableFuture<CompanyDto[]> stockCompanyTask = CompletableFuture
//                .supplyAsync(companyListJob::getCompaniesDto, executorService);
//
//        stockCompanyTask.thenAccept(result -> {
//            getCompanyQuotes(result);
//        });
//    }
//
//    private void getCompanyQuotes(CompanyDto[] result) {
//        for (CompanyDto companyDto : result) {
//            if (companyDto.isEnabled()) {
//                CompanyQuoteDto companyQuoteDto = companyListJob.getCompanyQuote(companyDto.getSymbol());
//                executorService.submit(() -> {
//                    if (companyQuoteDto != null) {
//                        companyQuoteDtos.add(companyQuoteDto);
//                    }
//                }, executorService);
//            }
//        }
//    }
//
//    public List<CompanyQuoteEntity> toCompanyQuoteEntity(List<CompanyQuoteDto> companyQuoteDtos) {
//        List<CompanyQuoteEntity> companyQuoteEntities = new ArrayList<>();
//        for (CompanyQuoteDto companyQuoteDto : companyQuoteDtos) {
//            companyQuoteEntities.add(modelMapper.map(companyQuoteDto, CompanyQuoteEntity.class));
//        }
//        return companyQuoteEntities;
//    }
//
//    public void saveCompanyQuotesToDb() {
//        companyQuoteRepository.saveAll(new ArrayList<>(toCompanyQuoteEntity(companyQuoteDtos)));
//    }
//}
