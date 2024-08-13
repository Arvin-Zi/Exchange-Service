package com.adak.exchange_mng.persistence.dto;

import com.adak.exchange_mng.persistence.Exchange;
import com.adak.exchange_mng.persistence.enums.CurrencyType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CurrencyRequest(

        @NotBlank(message = "Name cannot be blank")
        @Size(max = 255, message = "Name cannot exceed 255 characters")
        String name,

        @PositiveOrZero(message = "Buy price must be positive or zero")
        double buyPrice,

        @PositiveOrZero(message = "Sell price must be positive or zero")
        double sellPrice,

        @PositiveOrZero(message = "Tolerance must be positive or zero")
        double tolerance,

        @NotNull(message = "Currency type cannot be null")
        CurrencyType tag,

        byte[] currencyImage,

        @NotBlank(message = "Currency code cannot be blank")
        @Size(max = 10, message = "Currency code cannot exceed 10 characters")
        String currencyCode,

        boolean buyingEnable,

        @PositiveOrZero(message = "Buying fee must be positive or zero")
        double buyingFee,

        @PositiveOrZero(message = "Max buying numerator must be positive or zero")
        double maxBuyingNumerator,

        @PositiveOrZero(message = "Min buying numerator must be positive or zero")
        double minBuyingNumerator,

        boolean sellingEnable,

        @PositiveOrZero(message = "Selling fee must be positive or zero")
        double sellingFee,

        @PositiveOrZero(message = "Max selling numerator must be positive or zero")
        double maxSellingNumerator,

        @PositiveOrZero(message = "Min selling numerator must be positive or zero")
        double minSellingNumerator,
        boolean isActive,
        Exchange exchange
) {
}
