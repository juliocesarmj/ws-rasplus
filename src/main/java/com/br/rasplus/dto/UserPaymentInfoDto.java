package com.br.rasplus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPaymentInfoDto {

    private Long id;

    @Size(min = 16, max = 16, message = "dados inválidos")
    private String cardNumber;

    @Min(value = 1, message = "mês inferior a 1 não é permitido.")
    @Max(value = 12, message = "mês superior a 12 não é permitido.")
    private Long cardExpirationMonth;

    private Long cardExpirationYear;

    @Size(min = 3, max = 3, message = "deve conter 3 caracteres")
    private String cardSecurityCode;

    private BigDecimal price;

    @Min(value = 1, message = "parcela mínima permitida: 1")
    private int installments;

    @NotNull(message = "deve ser informado.")
    private Long userId;
}
