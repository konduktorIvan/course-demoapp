package com.course.coursedemoapp.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_quotes")
public class CompanyQuoteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "avg_total_volume")
    private double avgTotalVolume;

    @Column(name = "calculation_price")
    private String calculationPrice;

    @Column(name = "change_value")
    private double change;

    @Column(name = "change_percent")
    private double changePercent;

    @Column(name = "close")
    private double close;

    @Column(name = "close_source")
    private String closeSource;

    @Column(name = "close_time")
    private double closeTime;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "currency")
    private String currency;

    @Column(name = "delayed_price")
    private double delayedPrice;

    @Column(name = "delayed_price_time")
    private double delayedPriceTime;

    @Column(name = "extended_change")
    private double extendedChange;

    @Column(name = "extended_change_percent")
    private double extendedChangePercent;

    @Column(name = "extended_price")
    private double extendedPrice;

    @Column(name = "extended_price_time")
    private double extendedPriceTime;

    @Column
    private double high;

    @Column
    private String highSource;

    @Column
    private double highTime;

    @Column
    private double iexAskPrice;

    @Column
    private double iexAskSize;

    @Column
    private double iexBidPrice;

    @Column
    private double iexBidSize;

    @Column
    private double iexClose;

    @Column
    private double iexCloseTime;

    @Column
    private double iexLastUpdated;

    @Column
    private double iexMarketPercent;

    @Column
    private double iexOpen;

    @Column
    private double iexOpenTime;

    @Column
    private double iexRealtimePrice;

    @Column
    private double iexRealtimeSize;

    @Column
    private double iexVolume;

    @Column
    private double lastTradeTime;

    @Column
    private double latestPrice;

    @Column
    private String latestSource;

    @Column
    private String latestTime;

    @Column
    private double latestUpdate;

    @Column
    private double latestVolume;

    @Column
    private double low;

    @Column
    private String lowSource;

    @Column
    private double lowTime;

    @Column
    private double marketCap;

    @Column
    private double oddLotDelayedPrice;

    @Column
    private double oddLotDelayedPriceTime;

    @Column
    private double open;

    @Column
    private double openTime;

    @Column
    private String openSource;

    @Column
    private double peRatio;

    @Column
    private double previousClose;

    @Column
    private double previousVolume;

    @Column
    private String primaryExchange;

    @Column
    private String symbol;

    @Column
    private double volume;

    @Column
    private double week52High;

    @Column
    private double week52Low;

    @Column
    private double ytdChange;

    @Column
    private boolean isUSMarketOpen;
}

