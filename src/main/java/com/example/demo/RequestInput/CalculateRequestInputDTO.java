package com.example.demo.RequestInput;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculateRequestInputDTO {
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("sharesNb")
    private double sharesNb;
    @JsonProperty("sharePrice")
    private double sharePrice;
    @JsonProperty("TPPrice")
    private double TPPrice;
    @JsonProperty("SLPrice")
    private double SLPrice;

    public String getCurrency() { return currency; }

    public double getSharesNb() {
        return sharesNb;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public double getTPPrice() {
        return TPPrice;
    }

    public double getSLPrice() {
        return SLPrice;
    }
}
