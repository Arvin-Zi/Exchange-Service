package com.adak.order_mng.exchange;

import com.adak.order_mng.currency.CurrencyResponse;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ExchangeRequest(
        Integer id,
        @NotNull(message = "Exchange name cannot be null")
        String exchangeName,
        @NotNull(message = "Exchange address cannot be null")
        String exchangeAddress,
        String exchangeCode,
        String exchangeLocation,
        String exchangeWebsite,
        String exchangePhoneNumber,
        @NotNull(message = "Currency is required")
        Integer currencyId,
        List<CurrencyResponse> currencies
) {
}
