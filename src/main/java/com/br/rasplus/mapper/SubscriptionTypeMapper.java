package com.br.rasplus.mapper;

import com.br.rasplus.dto.SubscriptionTypeDTO;
import com.br.rasplus.model.SubscriptionType;

public class SubscriptionTypeMapper {

    private SubscriptionTypeMapper(){}

    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDTO dto) {
        return SubscriptionType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .accessMonths(dto.getAccessMonths())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build();
    }
}
