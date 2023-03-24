package com.br.rasplus.service;

import com.br.rasplus.dto.SubscriptionTypeDTO;
import com.br.rasplus.model.SubscriptionType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();

    SubscriptionType findById(final Long id);

    SubscriptionType update(final SubscriptionType subscriptionType);

    void delete(final Long id);

    SubscriptionType create(SubscriptionTypeDTO subscriptionTypeDTO);
}
