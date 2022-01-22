package com.course.coursedemoapp.repository;

import com.course.coursedemoapp.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;

//@Repository("companyRepository")
//@Transactional
public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer> {

}
