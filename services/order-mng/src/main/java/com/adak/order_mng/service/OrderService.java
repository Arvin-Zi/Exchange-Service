package com.adak.order_mng.service;

import com.adak.order_mng.currency.CurrencyClient;
import com.adak.order_mng.currency.CurrencyResponse;
import com.adak.order_mng.exception.BusinessException;
import com.adak.order_mng.exchange.ExchangeClient;
import com.adak.order_mng.kafka.OrderProducer;
import com.adak.order_mng.persistence.Order;
import com.adak.order_mng.persistence.RequestOrder;
import com.adak.order_mng.persistence.dto.OrderRequest;
import com.adak.order_mng.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final CurrencyClient currencyClient;
    private final ExchangeClient exchangeClient;
    private final OrderMapper mapper;
    private final OrderProducer orderProducer;

    public OrderService(OrderRepository orderRepository, CurrencyClient currencyClient, ExchangeClient exchangeClient, OrderMapper mapper, OrderProducer orderProducer) {
        this.orderRepository = orderRepository;
        this.currencyClient = currencyClient;
        this.exchangeClient = exchangeClient;
        this.mapper = mapper;
        this.orderProducer = orderProducer;
    }

    public Integer createOrder(OrderRequest request) {

        // Check if the request order is approved

//        if (requestOrder.getRequestState() != RequestState.ACCEPTED) {
//            throw new OrderNotFoundException.RequestNotApprovedException("Request Order is not approved");
//        }
        // check the currency exist

        log.info("HEY HEY");

        var currency = this.currencyClient.findCurrencyById(request.currencyId()).
                orElseThrow(() -> new BusinessException("Currency not found with the given ID"));


        var exchange = this.exchangeClient.findExchangeById(request.exchangeId());



        // Create the order object
        var order = this.orderRepository.save(mapper.toOrder(request, currency, exchange));

//        orderProducer.sendOrderConfirmation(
//                new OrderConfirmation(
//                        request.id(),
//                        request.quantity(),
//                        currency,
//                        exchange
//                )
//        );

        return order.getId();
    }



    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public String initiateOrder(RequestOrder request) {
        var exchange = this.exchangeClient.findExchangeByBranch(request.getExchangeBranch());

        if (exchange == null) {
            throw new BusinessException("Exchange not found with the given branch code");
        }

        boolean currencyFound = false;

        // Iterate over the currencies associated with the exchange
        for (CurrencyResponse currency : exchange.currencies()) {
            // Check if the currency name matches the request
            if (currency.name().equals(request.getCurrencyName())) {
                currencyFound = true;
                // You can perform additional actions here if needed
                break; // Exit the loop once the match is found
            }
        }
//        if (currencyFound){
//            exchange.currencies().get().equals()
//        }


    return "Order initiated successfully";
    }
}
