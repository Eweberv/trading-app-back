package com.example.demo.RequestInput;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SharesNumberCalculatorInputDTO {
    @JsonProperty("capitalToInvest")
    private double capitalToInvest;
    @JsonProperty("capitalCurrency")
    private String capitalCurrency;
    @JsonProperty("sharePrice")
    private double sharePrice;
    @JsonProperty("shareCurrency")
    private String shareCurrency;
    @JsonProperty("perOrderCommission")
    private double perOrderCommission;
    @JsonProperty("perOrderCommissionCurrency")
    private String perOrderCommissionCurrency;
    @JsonProperty("roundPrecision")
    private int roundPrecision;

    public double getCapitalToInvest() { return capitalToInvest; }

    public String getCapitalCurrency() { return capitalCurrency; }

    public double getSharePrice() {return sharePrice;}

    public String getShareCurrency() { return shareCurrency; }

    public double getPerOrderCommission() { return perOrderCommission; }

    public String getPerOrderCommissionCurrency() { return perOrderCommissionCurrency; }

    public int getRoundPrecision() {return roundPrecision;}
}
