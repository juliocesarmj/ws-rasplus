package com.br.rasplus.mapper;

import com.br.rasplus.dto.UserDto;
import com.br.rasplus.model.SubscriptionType;
import com.br.rasplus.model.User;
import com.br.rasplus.model.UserType;

public class UserMapper {

    private UserMapper(){}
    public static User fromDtoToEntity(UserDto dto, UserType userType, SubscriptionType subscriptionType) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .userType(userType)
                .subscriptionType(subscriptionType)
                .build();
    }
}
