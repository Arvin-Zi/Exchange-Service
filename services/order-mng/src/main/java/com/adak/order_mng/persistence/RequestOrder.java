package com.adak.order_mng.persistence;

import com.adak.order_mng.persistence.enums.RequestState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "request_order")
public class RequestOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private final UUID uuid = UUID.randomUUID();

    @Enumerated(STRING)
    private RequestState requestState;

    private String requestedBy;

    @CreationTimestamp
    private LocalDateTime created;

    private String updatedBy;

    private String currencyName;

    private String exchangeBranch;

    private Double amount;

    @UpdateTimestamp
    private LocalDateTime updated;

    @OneToOne(mappedBy = "requestOrder", cascade = CascadeType.REMOVE)
    private Order order;


}
