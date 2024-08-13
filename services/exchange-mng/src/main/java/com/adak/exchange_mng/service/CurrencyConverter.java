package com.adak.exchange_mng.service;

import com.adak.exchange_mng.persistence.Currency;
import com.adak.exchange_mng.persistence.dto.CurrencyRequest;
import com.adak.exchange_mng.persistence.dto.CurrencyResponse;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverter {
    public Currency toCurrency(CurrencyRequest request) {
        return Currency.builder()
                    .name(request.name())
                .buyPrice(request.buyPrice())
                .sellPrice(request.sellPrice())
                .tolerance(request.tolerance())
                .tag(request.tag())
                .currencyImage(request.currencyImage())
                .currencyCode(request.currencyCode())
                .buyingEnable(request.buyingEnable())
                .buyingFee(request.buyingFee())
                .maxBuyingNumerator(request.maxBuyingNumerator())
                .minBuyingNumerator(request.minBuyingNumerator())
                .sellingEnable(request.sellingEnable())
                .sellingFee(request.sellingFee())
                .maxSellingNumerator(request.maxSellingNumerator())
                .minSellingNumerator(request.minSellingNumerator())
                .isActive(request.isActive())
                .build();
    }

    public CurrencyResponse toResponse(Currency currency) {
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
