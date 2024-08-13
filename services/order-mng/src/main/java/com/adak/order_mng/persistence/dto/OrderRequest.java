package com.adak.order_mng.persistence.dto;

import com.adak.order_mng.persistence.enums.OrderType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest(
        String orderedBy,
        @Positive(message = "OrderQuantity must be positive")
        Double quantity,
        @NotNull(message = "OrderType cannot be null")
        OrderType orderType,
        @NotNull(message = "CurrencyId should be present")
        Integer currencyId,
        @NotNull(message = "ExchangeId should be present")
        Integer exchangeId
) {

}