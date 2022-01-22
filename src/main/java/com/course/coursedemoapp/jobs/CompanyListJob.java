package com.course.coursedemoapp.jobs;

import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@Component
public class CompanyListJob implements Callable<Future> {

    @Override
    public Future call() throws Exception {
        return null;
    }
}
