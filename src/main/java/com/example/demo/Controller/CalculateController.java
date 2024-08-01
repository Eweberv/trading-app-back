package com.example.demo.Controller;
import com.example.demo.Utils;

import com.example.demo.RequestInput.CalculateRequestInputDTO;
import com.example.demo.ResponseOutput.CalculateResponseOutputDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/gainLossPotentialCalculator", produces = "application/json")
public class CalculateController {
//    private static final int ORDER_PER_POSITION = 2;

    @PostMapping
    ResponseEntity<CalculateResponseOutputDTO> gainLossPotentialCalculator(@RequestBody CalculateRequestInputDTO requestBody) {
        System.out.println(requestBody.getCurrency());
        final String currency = requestBody.getCurrency();
        final double totalInvestment = Utils.roundNDecimals(requestBody.getSharePrice() * requestBody.getSharesNb(), 2);
        final double gainPotential = Utils.roundNDecimals(requestBody.getTPPrice() * requestBody.getSharesNb() - totalInvestment, 2);
        final double lossPotential = Utils.roundNDecimals(requestBody.getSLPrice() * requestBody.getSharesNb() - totalInvestment, 2);
        final double gainPotentialPercent = Utils.roundNDecimals((((totalInvestment + gainPotential) - totalInvestment) / totalInvestment) * 100, 2);
        final double lossPotentialPercent = Utils.roundNDecimals(((totalInvestment - (totalInvestment + lossPotential)) / totalInvestment) * 100, 2);

        CalculateResponseOutputDTO responseDTO = new CalculateResponseOutputDTO(currency, totalInvestment, gainPotential,
                lossPotential, gainPotentialPercent, lossPotentialPercent);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
