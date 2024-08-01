package com.example.demo.Controller;

import com.example.demo.RequestInput.CalculateRequestInputDTO;
import com.example.demo.Services.CalculateGainLossPotentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testRoute")
public class TestRouteController {

    private final CalculateGainLossPotentialService calculateGainLossPotentialService;

    @Autowired
    public TestRouteController(CalculateGainLossPotentialService calculateGainLossPotentialService) {
        this.calculateGainLossPotentialService = calculateGainLossPotentialService;
    }

    @PostMapping
    public ResponseEntity<Object> handlePostRequest(@RequestBody CalculateRequestInputDTO requestBody) {
        return ResponseEntity.status(HttpStatus.OK).body(calculateGainLossPotentialService.calculate(requestBody.getSharePrice(), requestBody.getTPPrice(), requestBody.getSLPrice()));
    }

    @GetMapping
    public ResponseEntity<String> handleGetRequest() {
        //return 'Hello World' on the main page
        return ResponseEntity.ok("Hello World");
    }
}
