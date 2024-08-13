package com.adak.exchange_mng.persistence.dto;

import jakarta.validation.constraints.NotNull;

public record ExchangeRequest(
        @NotNull(message = "Exchange name cannot be null")
        String exchangeName,
        @NotNull(message = "Exchange address cannot be null")
        String exchangeAddress,
        String exchangeCode,
        String exchangeLocation,
        String exchangeWebsite,
        String exchangePhoneNumber
) {
}
