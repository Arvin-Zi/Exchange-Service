package com.adak.order_mng.kafka;

import com.adak.order_mng.currency.CurrencyResponse;
import com.adak.order_mng.exchange.ExchangeResponse;

public record  OrderConfirmation(
        Integer orderId,
        double totalAmount,
        CurrencyResponse currency,
        ExchangeResponse exchangeRequest
) {
}
