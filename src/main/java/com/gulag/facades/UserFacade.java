package com.gulag.facades;

import com.gulag.entity.UserEntity;

public interface UserFacade {

    UserEntity createUser(UserEntity userEntity);

    UserEntity updateUser(UserEntity inputEntity);
}
