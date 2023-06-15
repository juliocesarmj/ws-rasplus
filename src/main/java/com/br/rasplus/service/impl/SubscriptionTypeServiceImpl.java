package com.br.rasplus.service.impl;

import com.br.rasplus.controllers.SubscriptionTypeController;
import com.br.rasplus.dto.SubscriptionTypeDTO;
import com.br.rasplus.mapper.SubscriptionTypeMapper;
import com.br.rasplus.model.SubscriptionType;
import com.br.rasplus.repository.SubscriptionTypeRepository;
import com.br.rasplus.service.SubscriptionTypeService;
import com.br.rasplus.service.exceptions.BadRequestException;
import com.br.rasplus.service.exceptions.NotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private final SubscriptionTypeRepository subscriptionTypeRepository;

    public SubscriptionTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        return subscriptionTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("SubscriptionType não encontrado"))
                .add(WebMvcLinkBuilder.linkTo(
                          WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class)
                                  .findById(id))
                        .withSelfRel()
                ).add(WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class)
                                .update(new SubscriptionTypeDTO()))
                        .withRel(UPDATE)
                ).add(WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class)
                                .deleteById(id))
                        .withRel(DELETE)
                );
    }
    
    @Override
    public SubscriptionType update(SubscriptionTypeDTO dto) {
    	SubscriptionType subscriptionType = findById(dto.getId());
    	
    	if(!subscriptionType.getProductKey().equals(dto.getProductKey())) {
    		throw new BadRequestException("Field not allowed for updating: productKey");
    	}
        return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
       subscriptionTypeRepository.delete(findById(id));
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDTO dto) {
        validId(dto.getId());
        validProductKey(dto.getProductKey());
        return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
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
