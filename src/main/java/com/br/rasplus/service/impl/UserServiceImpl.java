package com.br.rasplus.service.impl;

import com.br.rasplus.dto.UserDto;
import com.br.rasplus.mapper.UserMapper;
import com.br.rasplus.model.User;
import com.br.rasplus.model.UserType;
import com.br.rasplus.repository.UserRepository;
import com.br.rasplus.repository.UserTypeRepository;
import com.br.rasplus.service.UserService;
import com.br.rasplus.service.exceptions.BadRequestException;
import com.br.rasplus.service.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public User create(UserDto dto) {

        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id deve ser nulo.");
        }
        return userRepository.save(
                UserMapper.fromDtoToEntity(dto,
                        userTypeRepository.findById(dto.getUserTypeId())
                                .orElseThrow(() -> new NotFoundException("userTypeId not found.")), null));
    }
}
