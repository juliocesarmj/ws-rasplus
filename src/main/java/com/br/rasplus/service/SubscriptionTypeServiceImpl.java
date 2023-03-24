package com.br.rasplus.service;

import com.br.rasplus.dto.SubscriptionTypeDTO;
import com.br.rasplus.model.SubscriptionType;
import com.br.rasplus.repository.SubscriptionTypeRepository;
import com.br.rasplus.service.exceptions.BadRequestException;
import com.br.rasplus.service.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public void delete(Long id) {
        //subscriptionTypeRepository.delete(findById(id));
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDTO dto) {
        validId(dto.getId());
        validProductKey(dto.getProductKey());
        return subscriptionTypeRepository.save(SubscriptionType.builder()
                        .name(dto.getName())
                        .accessMonths(dto.getAccessMonths())
                        .price(dto.getPrice())
                        .productKey(dto.getProductKey())
                .build());
    }

    private void validProductKey(String productKey) {
        Optional<SubscriptionType> optional = subscriptionTypeRepository.findByProductKey(productKey);
        if (optional.isPresent())
            throw new BadRequestException("ProductKey já existe");
    }
    private void validId(final Long id) {
        if(Objects.nonNull(id))
            throw new BadRequestException("Não é permitido o envio do atributo: id");
    }
}
