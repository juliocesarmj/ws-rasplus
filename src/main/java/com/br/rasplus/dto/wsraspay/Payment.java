package com.br.rasplus.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private CreditCardDto creditCard;
    private String customerId;
    private String orderId;
}
