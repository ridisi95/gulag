package com.gulag.services;

import com.gulag.dto.UserDTO;
import com.gulag.entity.TourRegEntity;
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
    UserEntityDtoMapper mapper;

    public List<UserDTO> getAllParticipantOfTournamentRegistration(
            List<TourRegEntity> tournaments) {
        List<UserDTO> participants = new ArrayList<>();
        for (TourRegEntity registration : tournaments) {
            participants.add(mapper.userEntityToUserDto(registration.getUser()));
        }
        return participants;
    }

}
