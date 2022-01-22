//package service;
//
//import model.CompaniesDto;
//import model.CompanyDto;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//
//@Component
//public class ApiClient {
//
//
//    @Scheduled(fixedDelay = 5000)
//    public List<CompanyDto> getQueryCompanies() throws URISyntaxException {
//        System.out.println("Query");
//        String url = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
//        CompaniesDto response = restTemplate.getForObject(new URI(url), CompaniesDto.class);
//        return response.getCompanies();
//    }
//}
