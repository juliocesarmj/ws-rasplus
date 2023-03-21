package com.br.rasplus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscriptions_type")
public class SubscriptionType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptions_type_id")
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(name = "access_months")
    private Long accessMonths;

    @Column(nullable = false)
    private BigDecimal price;
    @Column(name = "product_key", unique = true, updatable = false)
    private String productKey;
}
