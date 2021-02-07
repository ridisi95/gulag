package com.gulag.services.impl;

import com.gulag.entity.UserEntity;
import com.gulag.repos.UserRepository;
import com.gulag.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserEntity findByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
    }


}
