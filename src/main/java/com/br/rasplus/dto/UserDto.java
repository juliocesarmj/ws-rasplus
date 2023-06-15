package com.br.rasplus.dto;

import com.br.rasplus.model.SubscriptionType;
import com.br.rasplus.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotBlank(message = "Value is not null or blank")
    @Size(min = 6, message = "Name is required length 6 or grean than")
    private String name;

    @Email(message = "Invalid")
    private String email;

    @Size(min = 10, max = 11, message = "invalid caracthers")
    private String phone;

    @CPF(message = "Invalid")
    private String cpf;

    private LocalDate dtSubscription;

    private LocalDate dtExpiration;

    @NotNull
    private Long userTypeId;

    private Long subscriptionTypeId;
}
