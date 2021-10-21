package com.gulag.services;

import com.gulag.entity.UserEntity;

public interface UserService {

    UserEntity findByUserId(Long userId);

    UserEntity saveOrUpdate(UserEntity userEntity);
}
