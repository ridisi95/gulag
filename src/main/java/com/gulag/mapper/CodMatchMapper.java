package com.gulag.mapper;

import com.gulag.dto.thirdparty.CodMatchDTO;
import com.gulag.dto.thirdparty.CodPlayerDTO;
import com.gulag.entity.MatchEntity;
import com.gulag.entity.PlayerEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Date;

@Mapper(componentModel = "spring", imports = Date.class)
public interface CodMatchMapper {

    @Mapping(source = "matchID", target = "actiMatchId")
    @Mapping(expression = "java(new Date(codMatchDTO.getUtcStartSeconds() * 1000L))", target = "startMatch")
    @Mapping(expression = "java(new Date(codMatchDTO.getUtcEndSeconds() * 1000L))", target = "endMatch")
    @Mapping(source = "allPlayers", target = "players")
    MatchEntity mapToEntity(CodMatchDTO codMatchDTO);

    @Mapping(source = "uno", target = "unoNumber")
    PlayerEntity playerToEntity (CodPlayerDTO codPlayerDTO);

//  #FIXME refactor if has easier solution
    @AfterMapping
    default void mapMatchField (@MappingTarget MatchEntity matchEntity) {
        matchEntity.getPlayers().forEach(player -> player.setMatch(matchEntity));
    }
}
