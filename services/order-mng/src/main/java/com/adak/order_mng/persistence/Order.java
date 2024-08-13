package com.adak.order_mng.persistence;

import com.adak.order_mng.persistence.enums.OrderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "exchange_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedBy
    private String orderedBy;

    @NotNull
    @Positive
    private Double quantity;

    @Enumerated(STRING)
    private OrderType orderType;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime orderedAt;

    @LastModifiedDate
    @Column(insertable = false, nullable = true)
    private LocalDateTime approvedAt;

    //if you were not sure change it to string then
    private Integer currencyId;
    private Integer exchangeId;

    @OneToOne
    @JoinColumn(name = "request_order_id", referencedColumnName = "id")
    private RequestOrder requestOrder;

}

