package com.adak.order_mng.repository;

import com.adak.order_mng.persistence.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
