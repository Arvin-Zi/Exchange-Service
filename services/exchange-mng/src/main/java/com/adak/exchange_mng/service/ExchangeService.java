package com.adak.exchange_mng.service;

import com.adak.exchange_mng.persistence.dto.ExchangeRequest;
import com.adak.exchange_mng.persistence.dto.ExchangeResponse;
import com.adak.exchange_mng.repository.ExchangeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeService {
    private final ExchangeRepository repository;
    private final ExchangeConverter converter;

    public ExchangeService(ExchangeRepository repository, ExchangeConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public Integer createExchange(@Valid ExchangeRequest request) {
        var exchange = converter.toExchange(request);
        return repository.save(exchange).getId();
    }

    public ExchangeResponse findById(Integer id) {
        return  repository.findById(id)
                .map(converter::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Exchange not found with the ID:: " + id));
    }

    public List<ExchangeResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(converter::toResponse)
                .collect(Collectors.toList());
    }

    public ExchangeResponse findByName(String name) {
        return  repository.findByExchangeName(name)
                .map(converter::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Exchange not found with the name:: " + name));
    }
    }

