package com.adak.exchange_mng.controller;

import com.adak.exchange_mng.persistence.dto.CurrencyRequest;
import com.adak.exchange_mng.persistence.dto.CurrencyResponse;
import com.adak.exchange_mng.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @PostMapping
    public ResponseEntity<Integer> createCurrency(@RequestBody @Valid CurrencyRequest request) {


        return ResponseEntity.ok(currencyService.createCurrency(request));
    }

    @GetMapping("/{currency-id}")
    public ResponseEntity<CurrencyResponse> findById(@PathVariable("currency-id") Integer id) {
        return ResponseEntity.ok(currencyService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CurrencyResponse>> findAll() {
        return ResponseEntity.ok(currencyService.findAll());
    }
}
