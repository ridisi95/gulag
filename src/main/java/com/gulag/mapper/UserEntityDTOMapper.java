package com.gulag.mapper;

import com.gulag.dto.UserDTO;
import com.gulag.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserEntityDTOMapper {

    @Mapping(target = "password", ignore = true)
    UserDTO userEntityToUserDTO(UserEntity userEntity);
    
    UserEntity userDTOToUserEntity(UserDTO userDto);
    
    @Mapping(target = "password", ignore = true)
    List<UserDTO> listUserEntitiesToUserDTOs(List<UserEntity> entities);
    
    List<UserEntity> listUserDTOsToUserEntities(List<UserDTO> entities);
}
