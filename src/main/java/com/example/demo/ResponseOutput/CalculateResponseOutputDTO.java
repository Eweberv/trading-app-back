package com.example.demo.ResponseOutput;

import com.example.demo.Utils;

public class CalculateResponseOutputDTO {
    private final String currency;
    private final String totalInvestment;
    private final String gainPotential;
    private final String lossPotential;
    private final String gainPotentialPercent;
    private final String lossPotentialPercent;

    public CalculateResponseOutputDTO(String currency, double totalInvestment, double gainPotential, double lossPotential,
                                      double gainPotentialPercent, double lossPotentialPercent) {
        this.currency = currency;
        this.totalInvestment = Utils.formatDoubleToString(totalInvestment, 2);
        this.gainPotential = Utils.formatDoubleToString(gainPotential, 2);
        this.lossPotential = Utils.formatDoubleToString(lossPotential, 2);
        this.gainPotentialPercent = Utils.formatDoubleToString(gainPotentialPercent, 2);
        this.lossPotentialPercent = Utils.formatDoubleToString(lossPotentialPercent, 2);
    }
    public String getCurrency() {
        return currency;
    }
    public String getTotalInvestment() {
        return totalInvestment;
    }
    public String getGainPotential() {
        return gainPotential;
    }
    public String getLossPotential() {
        return lossPotential;
    }
    public String getGainPotentialPercent() {
        return gainPotentialPercent;
    }
    public String getLossPotentialPercent() {
        return lossPotentialPercent;
    }
}
