package com.adak.order_mng.currency;

import java.util.Set;
import java.util.UUID;

public record CurrencyResponse(
        Integer id,
        UUID uuid,
        String name,
        double buyPrice,
        double sellPrice,
        double tolerance,
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
        boolean isActive,
        Set<Integer> exchangeIds // Assuming you might want to return the IDs of associated exchanges
) {
}
