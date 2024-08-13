package com.adak.exchange_mng.repository;

import com.adak.exchange_mng.persistence.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {

    Optional<Exchange> findByExchangeName(String name);
}
