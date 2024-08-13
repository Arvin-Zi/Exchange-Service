package com.adak.exchange_mng.repository;

import com.adak.exchange_mng.persistence.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
