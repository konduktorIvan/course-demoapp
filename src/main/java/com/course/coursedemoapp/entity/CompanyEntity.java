
package com.course.coursedemoapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class CompanyEntity {
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
}
