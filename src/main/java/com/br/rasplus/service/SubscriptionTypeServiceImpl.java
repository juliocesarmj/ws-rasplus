package com.br.rasplus.service;

import com.br.rasplus.dto.SubscriptionTypeDTO;
import com.br.rasplus.model.SubscriptionType;
import com.br.rasplus.repository.SubscriptionTypeRepository;
import com.br.rasplus.service.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    SubscriptionTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        return subscriptionTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("SubscriptionType não encontrado"));
    }

    @Override
    public SubscriptionType update(SubscriptionType subscriptionType) {
        return null;
    }

    @Override
    public SubscriptionType delete(Long id) {
        return null;
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDTO dto) {
        return subscriptionTypeRepository.save(SubscriptionType.builder()
                        .name(dto.getName())
                        .accessMonths(dto.getAccessMonths())
                        .price(dto.getPrice())
                        .productKey(dto.getProductKey())
                .build());
    }
}
