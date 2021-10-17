package com.gulag.facades.impl;

import com.gulag.api.client.user.TRNUserClient;
import com.gulag.entity.UserEntity;
import com.gulag.exception.UpdateObjectException;
import com.gulag.facades.UserFacade;
import com.gulag.mapper.UserEntityDTOMapper;
import com.gulag.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserFacadeImpl implements UserFacade {

    TRNUserClient trnUserClient;
    UserService userService;
    UserEntityDTOMapper userMapper;

    @Override
    public UserEntity createUser(UserEntity inputEntity) {
        trnUserClient.verifyUser(inputEntity.getUnoTag());
        return userService.saveOrUpdate(inputEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity inputEntity) {
        var userEntity = userService.findByUserId(inputEntity.getId());
        if (userEntity == null) {
            throw new UpdateObjectException("updating object not found id: " + inputEntity.getId());
        }
        userMapper.safetyMapToEntity(inputEntity, userEntity);
        return userService.saveOrUpdate(inputEntity);
    }
}
