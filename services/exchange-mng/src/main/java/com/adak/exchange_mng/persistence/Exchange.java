package com.adak.exchange_mng.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "exchange")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String exchangeName;
    private String exchangeAddress;
    private String exchangeCode;
    private String exchangeWebsite;
    private String exchangeLocation;
    private String exchangePhoneNumber;

    @ManyToMany
    @JoinTable(
            name = "exchange_currency",
            joinColumns = @JoinColumn(name = "exchange_id"),
            inverseJoinColumns = @JoinColumn(name = "currency_id")
    )
    @JsonIgnore
    private List<Currency> availableCurrencies;

    @Override
    public String toString() {
        return "Exchange{" +
                "id=" + id +
                ", exchangeName='" + exchangeName + '\'' +
                ", availableCurrenciesCount=" + (availableCurrencies != null ? availableCurrencies.size() : 0) +
                '}';
    }
}

