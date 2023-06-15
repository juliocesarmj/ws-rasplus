package com.br.rasplus.service;

import com.br.rasplus.dto.UserDto;
import com.br.rasplus.model.User;

public interface UserService {

    User create(UserDto dto);
}
