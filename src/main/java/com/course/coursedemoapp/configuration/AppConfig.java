package com.course.coursedemoapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class AppConfig {

    @Value("${NUMBER_OF_THREADS}")
    private int numberOfThreads;

    @Value("iexapi.host")
    private String iexApiHost;

    @Value("iexapi.token")
    private String iexApiToken;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(numberOfThreads);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
