package com.gulag.mapper;

import com.gulag.dto.UserDto;
import com.gulag.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserEntityDtoMapper {

    @Mapping(target = "password", ignore = true)
    UserDto userEntityToUserDto(UserEntity userEntity);
    UserEntity userDtoToUserEntity(UserDto userDto);

    List<UserDto> listUserEntityToUserDto(List<UserEntity> entities);
}
