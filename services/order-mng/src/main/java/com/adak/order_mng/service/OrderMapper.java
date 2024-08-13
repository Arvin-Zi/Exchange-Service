package com.adak.order_mng.service;

import com.adak.order_mng.currency.CurrencyResponse;
import com.adak.order_mng.exchange.ExchangeResponse;
import com.adak.order_mng.persistence.Order;
import com.adak.order_mng.persistence.dto.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request, CurrencyResponse currency, ExchangeResponse exchange) {
        return Order.builder()
                .orderedBy(request.orderedBy())
                .quantity(request.quantity())
                .orderType(request.orderType())
                .currencyId(currency.id())
                .exchangeId(exchange.id())
                .build();
    }
}
