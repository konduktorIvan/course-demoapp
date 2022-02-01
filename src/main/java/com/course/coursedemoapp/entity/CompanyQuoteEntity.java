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
@Table(name = "company_quote")
public class CompanyQuoteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Double avgTotalVolume;

    @Column
    private String calculationPrice;

    @Column
    private double change;

    @Column
    private Double changePercent;

    @Column
    private Double close;

    @Column
    private String closeSource;

    @Column
    private Double closeTime;

    @Column
    private String companyName;

    @Column
    private String currency;

    @Column
    private Double delayedPrice;

    @Column
    private Double delayedPriceTime;

    @Column
    private Double extendedChange;

    @Column
    private Double extendedChangePercent;

    @Column
    private Double extendedPrice;

    @Column
    private Double extendedPriceTime;

    @Column
    private Double high;

    @Column
    private String highSource;

    @Column
    private Double highTime;

    @Column
    private Double iexAskPrice;

    @Column
    private Double iexAskSize;

    @Column
    private Double iexBidPrice;

    @Column
    private Double iexBidSize;

    @Column
    private Double iexClose;

    @Column
    private Double iexCloseTime;

    @Column
    private Double iexLastUpdated;

    @Column
    private Double iexMarketPercent;

    @Column
    private Double iexOpen;

    @Column
    private Double iexOpenTime;

    @Column
    private Double iexRealtimePrice;

    @Column
    private Double iexRealtimeSize;

    @Column
    private Double iexVolume;

    @Column
    private Double lastTradeTime;

    @Column
    private Double latestPrice;

    @Column
    private String latestSource;

    @Column
    private String latestTime;

    @Column
    private Double latestUpdate;

    @Column
    private Double latestVolume;

    @Column
    private Double low;

    @Column
    private String lowSource;

    @Column
    private Double lowTime;

    @Column
    private Double marketCap;

    @Column
    private Double oddLotDelayedPrice;

    @Column
    private Double oddLotDelayedPriceTime;

    @Column
    private Double open;

    @Column
    private Double openTime;

    @Column
    private String openSource;

    @Column
    private Double peRatio;

    @Column
    private Double previousClose;

    @Column
    private Double previousVolume;

    @Column
    private String primaryExchange;

    @Column
    private String symbol;

    @Column
    private Double volume;

    @Column
    private Double week52High;

    @Column
    private Double week52Low;

    @Column
    private Double ytdChange;

    @Column
    private boolean isUSMarketOpen;
}

