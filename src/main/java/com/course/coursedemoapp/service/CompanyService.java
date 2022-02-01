package com.course.coursedemoapp.service;

import java.util.concurrent.ExecutionException;

public interface CompanyService {
     void getCompaniesFromAPI() throws ExecutionException, InterruptedException;
}
