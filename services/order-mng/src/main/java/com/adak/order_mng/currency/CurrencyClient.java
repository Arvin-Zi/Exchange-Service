package com.adak.order_mng.currency;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "currency-service",
        url = "${application.config.currency-url}"

)
public interface CurrencyClient {
    @GetMapping("/{currency-id}")
    Optional<CurrencyResponse> findCurrencyById(@PathVariable("currency-id") Integer currencyId);


}
