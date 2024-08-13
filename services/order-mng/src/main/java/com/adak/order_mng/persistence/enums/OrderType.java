package com.adak.order_mng.persistence.enums;

import org.springframework.validation.annotation.Validated;

@Validated
public enum OrderType {
    DEPOSIT,
    WITHDRAWAL,
    TRANSFER,
    INPERSON
}
