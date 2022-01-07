package model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("companyQuoteRepository")
@Transactional
public interface CompanyQuoteRepository extends CrudRepository<CompanyQuoteEntity, Integer> {

}
