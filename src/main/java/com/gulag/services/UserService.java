package com.gulag.services;

import com.gulag.entity.UserEntity;
import com.gulag.repos.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UsersRepository usersRepository;

    public UserEntity findByUserId(Long userId) {
        return usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
    }
}
