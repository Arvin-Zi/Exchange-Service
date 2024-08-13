package com.adak.exchange_mng.persistence.dto;

import java.util.List;

public record ExchangeResponse(
        Integer id,
        String exchangeName,
        String exchangeAddress,
        String exchangeCode,
        String exchangeLocation,
        String exchangeWebsite,
        String exchangePhoneNumber,
        List<CurrencyResponse> currencies
) {

}
