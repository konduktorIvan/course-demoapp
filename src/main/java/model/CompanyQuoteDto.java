package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyQuoteDto {
    private Double avgTotalVolume;
    private String calculationPrice;
    private Double change;
    private Double changePercent;
    private Double close;
    private String closeSource;
    private Double closeTime;
    private String companyName;
    private String currency;
    private Double delayedPrice;
    private Double delayedPriceTime;
    private Double extendedChange;
    private Double extendedChangePercent;
    private Double extendedPrice;
    private Double extendedPriceTime;
    private Double high;
    private String highSource;
    private Double highTime;
    private Double iexAskPrice;
    private Double iexAskSize;
    private Double iexBidPrice;
    private Double iexBidSize;
    private Double iexClose;
    private Double iexCloseTime;
    private Double iexLastUpdated;
    private Double iexMarketPercent;
    private Double iexOpen;
    private Double iexOpenTime;
    private Double iexRealtimePrice;
    private Double iexRealtimeSize;
    private Double iexVolume;
    private Double lastTradeTime;
    private Double latestPrice;
    private String latestSource;
    private String latestTime;
    private Double latestUpdate;
    private Double latestVolume;
    private Double low;
    private String lowSource;
    private Double lowTime;
    private Double marketCap;
    private Double oddLotDelayedPrice;
    private Double oddLotDelayedPriceTime;
    private Double open;
    private Double openTime;
    private String openSource;
    private Double peRatio;
    private Double previousClose;
    private Double previousVolume;
    private String primaryExchange;
    private String symbol;
    private Double volume;
    private Double week52High;
    private Double week52Low;
    private Double ytdChange;
    private boolean isUSMarketOpen;
}
