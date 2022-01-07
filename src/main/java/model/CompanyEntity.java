
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "company")
public class CompanyEntity {

    public CompanyEntity(String symbol,
                         String exchange,
                         String exchangeSuffix,
                         String exchangeName,
                         String exchangeSegment,
                         String exchangeSegmentName,
                         String name,
                         LocalDate date,
                         String type,
                         String iexId,
                         String region,
                         String currency,
                         boolean isEnabled,
                         String figi,
                         String cik,
                         String lei)
    {
         this.symbol = symbol;
         this.exchange = exchange;
         this.exchangeSuffix = exchangeSuffix;
         this.exchangeName = exchangeName;
         this.exchangeSegment = exchangeSegment;
         this.exchangeSegmentName = exchangeSegmentName;
         this.name = name;
         this.date = date;
         this.type = type;
         this.iexId = iexId;
         this.region = region;
         this.currency = currency;
         this.isEnabled = isEnabled;
         this.cik = cik;
         this.lei = lei;
         this.figi = figi;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "exchange_currency")
    private String exchange;

    @Column(name = "exchange_suffix")
    private String exchangeSuffix;

    @Column(name = "exchange_name")
    private String exchangeName;

    @Column(name = "exchange_segment")
    private String exchangeSegment;

    @Column(name = "exchange_segment_name")
    private String exchangeSegmentName;

    @Column(name = "company_name")
    private String name;

    @Column(name = "company_date")
    private LocalDate date;

    @Column(name = "company_type")
    private String type;

    @Column(name = "iex_id")
    private String iexId;

    @Column(name = "region")
    private String region;

    @Column(name = "currency")
    private String currency;

    @Column(name = "figi")
    private String figi;

    @Column(name = "cik")
    private String cik;

    @Column(name = "lei")
    private String lei;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyEntity that = (CompanyEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
