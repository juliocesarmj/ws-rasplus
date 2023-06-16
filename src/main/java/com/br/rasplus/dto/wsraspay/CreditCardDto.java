package com.br.rasplus.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDto {

    private int cvv;
    private String documentNumber;
    private int installments;
    private int month;
    private String number;
    private int year;
}
