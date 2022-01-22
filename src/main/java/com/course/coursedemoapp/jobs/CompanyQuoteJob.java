package com.course.coursedemoapp.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CompanyQuoteJob {

    @Autowired
    RestTemplate restTemplate;

}

//    @Scheduled(fixedDelay = 5000)
//@Scheduled(initialDelay = 1000, fixedDelay = Long.MAX_VALUE)
//public void getCompaniesFromServer() throws URISyntaxException {
//    log.info("Updating company info");
//    String url = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
//    CompanyDto[] companiesDto = restTemplate.getForObject(new URI(url), CompanyDto[].class);
//    log.info("Retrieved " + companiesDto.length + " companies");
//    log.info("Started query company quote...");
//    saveCompanyQueries();
//}
//
//    @Scheduled (initialDelay = 10000, fixedDelay = Long.MAX_VALUE)
//    public void saveCompanyQueries() throws URISyntaxException {
//        log.info("Started query company quote...");
////        for (CompanyDto company : companiesDto) {
////            if (company.isEnabled()) {
////                createAndSaveQuoteQuery(company);
////            }
////        }
//        getCompaniesFromServer();
//    }
//
//    //TODO: inveestigate how to make request for each company async
//    // TIPS: CompletableFuture.runAsync, thenAccept
//    // Request to the client should return Future
//    //TODO: save with batches
//    public void createAndSaveQuoteQuery(CompanyDto companyDto) {
//        if (companyDto.getSymbol() != null){
//            String url = "https://sandbox.iexapis.com/stable/stock/" + companyDto.getSymbol() +
//                    "/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571";
//            CompanyQuoteDto companyQuoteDto = restTemplate.getForObject(url, CompanyQuoteDto.class);
//            CompanyQuoteEntity companyQuoteEntity = convertToEntity(companyQuoteDto);
//            companyQuoteRepository.save(companyQuoteEntity);
//        }
//    }
//
//    @Scheduled(fixedDelay = 5000)
//    public void showTopFive() {
//        System.out.println("Top five companies by volume");
//        for (CompanyQuoteEntity company: companyQuoteRepository.findTopFiveHighestVolume()) {
//            System.out.println(company.getCompanyName() + " volume: " + company.getVolume());
//        }
//    }
//
//    private CompanyQuoteEntity convertToEntity(CompanyQuoteDto companyQuoteDto) {
//        return modelMapper.map(companyQuoteDto, CompanyQuoteEntity.class);
//    }
//}
