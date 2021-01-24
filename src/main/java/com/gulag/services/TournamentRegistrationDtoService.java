package com.gulag.services;

import com.gulag.dto.TournamentRegistrationDto;
import com.gulag.entity.TournamentRegistration;
import com.gulag.mapper.TournamentRegistrationDtoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TournamentRegistrationDtoService {

    @Autowired
    TournamentRegistrationDtoMapper mapper;

    public List<TournamentRegistrationDto> getAllTournaments(
            List<TournamentRegistration> registrations) {
        return mapper.listTournamentRegistrationTournamentDt(registrations);
    }
}
