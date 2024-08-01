package com.example.demo.Services;

import org.springframework.stereotype.Service;

@Service
public class CalculateGainLossPotentialService {

    public Object calculate(double fillPrice, double TPPrice, double SLPrice) {
        System.out.println(fillPrice);
        System.out.println(TPPrice);
        System.out.println(SLPrice);
        return new Object() {
            public final double gainPotential = TPPrice - fillPrice;
            public final double lossPotential = fillPrice - SLPrice;
        };
    }
}
