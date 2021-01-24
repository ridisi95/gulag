package com.gulag.services;

import com.gulag.dto.UserDto;
import com.gulag.entity.TournamentRegistration;
import com.gulag.mapper.TournamentRegistrationUserDtoMapper;
import com.gulag.mapper.UserEntityDtoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.mapstruct.factory.Mappers;
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

    public List<UserDto> getAllParticipantOfTournamentRegistration(
            List<TournamentRegistration> tournaments) {
        List<UserDto> participants = new ArrayList<>();
        for (TournamentRegistration registration : tournaments) {
            participants.add(mapper.userEntityToUserDto(registration.getUser()));
        }
        return participants;
    }

}
