package com.adak.exchange_mng.service;

import com.adak.exchange_mng.persistence.Currency;
import com.adak.exchange_mng.persistence.Exchange;
import com.adak.exchange_mng.persistence.dto.CurrencyResponse;
import com.adak.exchange_mng.persistence.dto.ExchangeRequest;
import com.adak.exchange_mng.persistence.dto.ExchangeResponse;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ExchangeConverter {
    public Exchange toExchange(ExchangeRequest request) {
        return Exchange.builder()
                .exchangeName(request.exchangeName())
                .exchangeAddress(request.exchangeAddress())
                .exchangeCode(request.exchangeCode())
                .exchangeWebsite(request.exchangeWebsite())
                .exchangePhoneNumber(request.exchangePhoneNumber())
                .exchangeLocation(request.exchangeLocation())
               .build();
    }

    public ExchangeResponse toResponse(Exchange exchange) {
        return new ExchangeResponse(
                exchange.getId(),
                exchange.getExchangeName(),
                exchange.getExchangeAddress(),
                exchange.getExchangeCode(),
                exchange.getExchangeWebsite(),
                exchange.getExchangePhoneNumber(),
                exchange.getExchangeLocation(),
                exchange.getAvailableCurrencies().stream().map(currency -> toCurrencyResponse(currency)).collect(Collectors.toList())
        );
    }
    public CurrencyResponse toCurrencyResponse(Currency currency) {
        return new CurrencyResponse(
                currency.getId(),
                currency.getName(),
                currency.getBuyPrice(),
                currency.getSellPrice(),
                currency.getTolerance(),
                currency.getTag(),
                currency.getCurrencyImage(),
                currency.getCurrencyCode(),
                currency.isBuyingEnable(),
                currency.getBuyingFee(),
                currency.getMaxBuyingNumerator(),
                currency.getMinBuyingNumerator(),
                currency.isSellingEnable(),
                currency.getSellingFee(),
                currency.getMaxSellingNumerator(),
                currency.getMinSellingNumerator(),
                currency.isActive()
        );
    }
}
