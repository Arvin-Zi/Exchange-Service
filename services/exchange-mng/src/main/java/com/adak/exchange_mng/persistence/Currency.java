package com.adak.exchange_mng.persistence;

import com.adak.exchange_mng.persistence.enums.CurrencyType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private final UUID uuid = UUID.randomUUID();

    @Column(unique = true)
    private String name;

    private double buyPrice;
    private double sellPrice;
    private double tolerance;

    @Enumerated(EnumType.STRING)
    private CurrencyType tag;
    private byte[] currencyImage;
    @Column(unique = true)
    private String currencyCode;

    // Buying information
    private boolean buyingEnable;
    private double buyingFee;
    private double maxBuyingNumerator;
    private double minBuyingNumerator;

    // Selling information
    private boolean sellingEnable;
    private double sellingFee;
    private double maxSellingNumerator;
    private double minSellingNumerator;

    private boolean isActive;

    @ManyToMany(mappedBy = "availableCurrencies", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Exchange> exchanges;
    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", tolerance=" + tolerance +
                ", tag=" + tag +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }

}