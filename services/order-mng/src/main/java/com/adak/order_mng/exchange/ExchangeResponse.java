package com.adak.order_mng.exchange;

import com.adak.order_mng.currency.CurrencyResponse;

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