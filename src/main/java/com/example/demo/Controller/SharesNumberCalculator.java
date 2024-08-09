package com.example.demo.Controller;

import com.example.demo.RequestInput.SharesNumberCalculatorInputDTO;
import com.example.demo.ResponseOutput.SharesNumberCalculatorOutputDTO;
import com.example.demo.Services.CurrencyConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Utils;

@RestController
@RequestMapping(value = "/sharesNumberCalculator", produces = "application/json")
public class SharesNumberCalculator {

    CurrencyConversionService currencyConversionService = new CurrencyConversionService();
    @PostMapping
    ResponseEntity<SharesNumberCalculatorOutputDTO> sharesNumberCalculator(@RequestBody SharesNumberCalculatorInputDTO requestBody) {
        final double capitalToInvest = requestBody.getCapitalToInvest();
        final double capitalToInvestInSharesCurrency = currencyConversionService.convertCurrency(requestBody.getCapitalToInvest(), requestBody.getCapitalCurrency(), requestBody.getShareCurrency());
        final double sharePrice = requestBody.getSharePrice();
        final int roundPrecision = requestBody.getRoundPrecision();
        final double sharesNb = Utils.roundNDecimals(capitalToInvestInSharesCurrency / sharePrice, roundPrecision);
        final String capitalCurrency = requestBody.getCapitalCurrency();
        SharesNumberCalculatorOutputDTO sharesNumberCalculatorOutputDTO = new SharesNumberCalculatorOutputDTO(capitalToInvest, sharesNb, capitalCurrency);
        return ResponseEntity.status(HttpStatus.OK).body(sharesNumberCalculatorOutputDTO);
    }
}
