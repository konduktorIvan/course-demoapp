package com.course.coursedemoapp.service;

import com.course.coursedemoapp.jobs.CompanyListJob;
import com.course.coursedemoapp.jobs.CompanyQuoteJob;
import com.course.coursedemoapp.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    CompanyListJob companyListJob;

    @Autowired
    CompanyQuoteJob companyQuoteJob;

    @Autowired
    ExecutorService executorService;


}
