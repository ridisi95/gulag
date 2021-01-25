package com.gulag.mapper;

import com.gulag.dto.UserDTO;
import com.gulag.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserEntityDtoMapper {

    @Mapping(target = "password", ignore = true)
    UserDTO userEntityToUserDto(UserEntity userEntity);
    UserEntity userDtoToUserEntity(UserDTO userDto);

    List<UserDTO> listUserEntityToUserDto(List<UserEntity> entities);
}
