package com.adak.exchange_mng.service;

import com.adak.exchange_mng.persistence.Exchange;
import com.adak.exchange_mng.persistence.dto.CurrencyRequest;
import com.adak.exchange_mng.persistence.dto.CurrencyResponse;
import com.adak.exchange_mng.repository.CurrencyRepository;
import com.adak.exchange_mng.repository.ExchangeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class CurrencyService {
    private final CurrencyRepository repository;
    private final ExchangeRepository exchangeRepository;
    private final CurrencyConverter converter;

    public CurrencyService(CurrencyRepository repository, ExchangeRepository exchangeRepository, CurrencyConverter converter) {
        this.repository = repository;
        this.exchangeRepository = exchangeRepository;
        this.converter = converter;
    }

    public Integer createCurrency(@Valid CurrencyRequest request) {
        // Retrieve the Exchange object
        Optional<Exchange> exchangeOptional = exchangeRepository.findById(request.exchange().getId());

        if (exchangeOptional.isEmpty()) {
            throw new EntityNotFoundException("Exchange not found with ID: " + request.exchange().getId());
        }

        // Convert the CurrencyRequest to a Currency entity
        var currency = converter.toCurrency(request);

        // Retrieve the Exchange object
        Exchange exchange = exchangeOptional.get();



        // Create a list of Exchanges and add the retrieved Exchange
                if (exchange.getAvailableCurrencies() == null) {
            exchange.setAvailableCurrencies(new ArrayList<>());
        }
        exchange.getAvailableCurrencies().add(currency);

        List<Exchange> exchanges = new ArrayList<>();
        exchanges.add(exchange);

        // Set the exchanges in the Currency entity
        currency.setExchanges(exchanges);



        // Save the Currency entity
        Integer currencyId = repository.save(currency).getId();
        log.info(currency.toString());
//
//        // Save the updated Exchange entity
        exchangeRepository.save(exchange);
        log.info(exchange.toString());

        return currencyId;
    }

    public CurrencyResponse findById(Integer id) {
        return  repository.findById(id)
                .map(converter::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Exchange not found with the ID:: " + id));
    }

    public List<CurrencyResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(converter::toResponse)
                .collect(Collectors.toList());
    }
}
