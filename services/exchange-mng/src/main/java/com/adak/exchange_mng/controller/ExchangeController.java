package com.adak.exchange_mng.controller;

import com.adak.exchange_mng.persistence.dto.ExchangeRequest;
import com.adak.exchange_mng.persistence.dto.ExchangeResponse;
import com.adak.exchange_mng.service.ExchangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exchange")
@RequiredArgsConstructor
public class ExchangeController {
    private final ExchangeService exchangeService;

    @PostMapping
    public ResponseEntity<Integer> createExchange(@RequestBody @Valid ExchangeRequest request) {
        return ResponseEntity.ok(exchangeService.createExchange(request));
    }
//    @PostMapping
//    public ResponseEntity<List<TradeResponse>> TradeCurrency(
//            @RequestBody List<TradeResponse> request) {
//        return ResponseEntity.ok(exchangeService.TradeCurrency(request));
//    }§

    @GetMapping("/{exchange-id}")
    public ResponseEntity<ExchangeResponse> findById(@PathVariable("exchange-id") Integer id) {
        return ResponseEntity.ok(exchangeService.findById(id));
    }

    @GetMapping("/name/{exchange-name}")
    public ResponseEntity<ExchangeResponse> findByName(@PathVariable("exchange-name") String name) {
        return ResponseEntity.ok(exchangeService.findByName(name));
    }

    @GetMapping
    public ResponseEntity<List<ExchangeResponse>> findAll() {
        return ResponseEntity.ok(exchangeService.findAll());
    }
}
