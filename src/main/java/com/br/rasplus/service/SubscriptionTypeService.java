package com.br.rasplus.service;

import com.br.rasplus.model.SubscriptionType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();

    SubscriptionType findById(final Long id);

    SubscriptionType update(final SubscriptionType subscriptionType);

    SubscriptionType delete(final Long id);

    SubscriptionType create(SubscriptionType subscriptionType);
}
