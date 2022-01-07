package model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository("companyQuoteRepository")
@Transactional
public interface CompanyQuoteRepository extends CrudRepository<CompanyQuoteEntity, Integer> {

    @Query(value = "SELECT * FROM company_quote ORDER BY volume DESC LIMIT 5", nativeQuery = true)
    public Collection<CompanyQuoteEntity> findTopFiveHighestVolume();
}
