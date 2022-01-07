package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompanyDto {
    @JsonProperty
    private String symbol;
    @JsonProperty
    private String exchange;
    @JsonProperty
    private String exchangeSuffix;
    @JsonProperty
    private String exchangeName;
    @JsonProperty
    private String exchangeSegment;
    @JsonProperty
    private String exchangeSegmentName;
    @JsonProperty
    private String name;
    @JsonProperty
    private LocalDate date;
    @JsonProperty
    private String type;
    @JsonProperty
    private String iexId;
    @JsonProperty
    private String region;
    @JsonProperty
    private String currency;
    @JsonProperty
    private boolean isEnabled;
    @JsonProperty
    private String figi;
    @JsonProperty
    private String cik;
    @JsonProperty
    private String lei;
}
