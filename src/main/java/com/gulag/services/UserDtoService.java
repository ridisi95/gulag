package com.gulag.services;

import com.gulag.dto.TourRegDTO;
import com.gulag.dto.UserDTO;
import com.gulag.entity.TourRegEntity;
import com.gulag.mapper.TourRegDtoMapper;
import com.gulag.mapper.UserEntityDtoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserDtoService {

    @Autowired
    TourRegDtoMapper mapper1;

    public List<UserDTO> getAllParticipantOfTournamentRegistration(
            List<TourRegEntity> tournaments) {
        List<TourRegDTO> tourRegDTOS = mapper1.mapListEntitiesToDTOs(tournaments);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (TourRegDTO tourRegDTO : tourRegDTOS)
            userDTOS.add(tourRegDTO.getUser());
        return userDTOS;
    }

}
