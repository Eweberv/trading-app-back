package com.example.demo.ResponseOutput;

public class SharesNumberCalculatorOutputDTO {
    private final double sharesNb;
    private final double capitalToInvest;
    private final String capitalCurrency;

    public SharesNumberCalculatorOutputDTO(double capitalToInvest, double sharesNb, String capitalCurrency) {
        this.capitalToInvest = capitalToInvest;
        this.sharesNb = sharesNb;
        this.capitalCurrency = capitalCurrency;
    }
    public double getCapitalToInvest() {
        return capitalToInvest;
    }
    public double getSharesNb() {
        return sharesNb;
    }
    public String getCapitalCurrency() {return capitalCurrency;}
}
