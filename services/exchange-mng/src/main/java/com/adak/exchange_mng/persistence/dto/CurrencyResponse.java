package com.adak.exchange_mng.persistence.dto;

import com.adak.exchange_mng.persistence.enums.CurrencyType;

public record CurrencyResponse(
        Integer id,
        String name,
        double buyPrice,
        double sellPrice,
        double tolerance,
        CurrencyType tag,
        byte[] currencyImage,
        String currencyCode,
        boolean buyingEnable,
        double buyingFee,
        double maxBuyingNumerator,
        double minBuyingNumerator,
        boolean sellingEnable,
        double sellingFee,
        double maxSellingNumerator,
        double minSellingNumerator,
        boolean isActive
) {
    // You can also add custom constructors or methods if needed.
}

