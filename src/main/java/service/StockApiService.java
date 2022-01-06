//package service;
//
//import dao.StockApiRepository;
//import lombok.NonNull;
//import model.CompanyDto;
//import model.CompanyEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.net.URISyntaxException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class StockApiService {
//    @Autowired
//    private StockApiRepository stockApiRepository;
//
//    @Autowired
//    private ApiClient apiClient;
//
//    @Scheduled(fixedDelay = 100)
//    public List<CompanyEntity> findAll() throws URISyntaxException {
//        System.out.println(apiClient.getQueryCompanies());
//        return apiClient.getQueryCompanies().stream()
//                .map(this::toCompanyEntity)
//                .collect(Collectors.toList());
//    }
//
//
//
////    public List<CompanyEntity> findAll() {
////        return stockApiRepository.findAll();
//}
