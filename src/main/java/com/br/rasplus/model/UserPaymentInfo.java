package com.br.rasplus.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_payment_info")
public class UserPaymentInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_payment_info_id")
    private Long id;

    @Column(name = "card_number", nullable = false, unique = true)
    private String cardNumber;

    @Column(name = "card_expiration_month", nullable = false)
    private Long cardExpirationMonth;

    @Column(name = "card_expiration_year", nullable = false)
    private Long cardExpirationYear;

    @Column(name = "card_security_code", length = 3, nullable = false)
    private String cardSecurityCode;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int installments;

    @Column(name = "dt_payment",nullable = false, updatable = false)
    private LocalDate dtPayment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist
    public void doPersist() {
       this.dtPayment = LocalDate.now();
    }
}
