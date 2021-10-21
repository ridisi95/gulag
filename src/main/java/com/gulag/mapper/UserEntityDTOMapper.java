package com.gulag.mapper;

import com.gulag.dto.UserDTO;
import com.gulag.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserEntityDTOMapper {

    @Mapping(target = "password", ignore = true)
    UserDTO mapEntityToDTO(UserEntity userEntity);
    
    @Mapping(target = "password", ignore = true)
    List<UserDTO> mapEntityToDTO(List<UserEntity> entityList);

    @Mapping(target = "password", ignore = true)
    Set<UserDTO> mapEntityToDTO(Set<UserEntity> entitySet);

    UserEntity mapDTOToEntity(UserDTO userDto);

    List<UserEntity> mapDTOToEntity(List<UserDTO> dtoList);

    Set<UserEntity> mapDTOToEntity(Set<UserDTO> dtoSet);

    default void safetyMapToEntity(UserEntity source, UserEntity target) {
        target.setPassword(defaultIfBlank(source.getPassword(), source.getPassword()));
        target.setEmail(defaultIfBlank(source.getEmail(), target.getEmail()));
        target.setNumberOfWins(source.getNumberOfWins());
        target.setNumberOfAppearances(source.getNumberOfAppearances());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
    }
}
