package com.gulag.mapper;

import com.gulag.dto.MatchDTO;
import com.gulag.entity.MatchEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    MatchDTO mapToDTO(MatchEntity matchEntity);
}
