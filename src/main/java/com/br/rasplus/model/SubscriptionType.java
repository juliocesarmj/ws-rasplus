package com.br.rasplus.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "subscriptions_type")
public class SubscriptionType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscriptions_type_id")
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(name = "access_months")
    private Long accessMonths;

    @Column(nullable = false)
    private BigDecimal price;
    @Column(name = "product_key", unique = true)
    private String productKey;

    public SubscriptionType(Long id, String name, Long accessMonths, BigDecimal price, String productKey) {
        this.id = id;
        this.name = name;
        this.accessMonths = accessMonths;
        this.price = price;
        this.productKey = productKey;
    }

    public SubscriptionType() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccessMonths() {
        return accessMonths;
    }

    public void setAccessMonths(Long accessMonths) {
        this.accessMonths = accessMonths;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }
}
