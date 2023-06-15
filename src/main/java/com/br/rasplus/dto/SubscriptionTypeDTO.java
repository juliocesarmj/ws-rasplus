package com.br.rasplus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionTypeDTO {

    private Long id;

    @NotBlank(message = "Field name is invalid.")
    private String name;

    @Max(value = 12, message = "Field accessMonths cannot be greater than 12")
    private Long accessMonths;

    @NotNull(message = "Price field is required.")
    @Min(value = 1, message = "The price field be greater than 0")
    private BigDecimal price;

    @NotBlank(message = "Field productKey is required.")
    private String productKey;
}
