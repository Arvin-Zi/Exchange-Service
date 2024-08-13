package com.adak.order_mng.controller;

import com.adak.order_mng.exception.ErrorResponse;
import com.adak.order_mng.persistence.Order;
import com.adak.order_mng.persistence.RequestOrder;
import com.adak.order_mng.persistence.dto.OrderRequest;
import com.adak.order_mng.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Integer> createOrder(@RequestBody  @Valid OrderRequest request) {
        System.out.println("arvin is on");
      return ResponseEntity.ok(orderService.createOrder(request));
    }
    @PostMapping("/initiate")
    public ResponseEntity<String> initiateOrder(@RequestBody  @Valid RequestOrder request){
        return ResponseEntity.ok(orderService.initiateOrder(request));
    }
    @GetMapping("/list")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orders = orderService.getAllOrders();
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Failed to retrieve orders",
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }









}
