package com.gulag.services;

import com.gulag.dto.TourRegDTO;
import com.gulag.entity.TourRegEntity;
import com.gulag.mapper.TourRegDtoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TourRegDtoService {

    @Autowired
    TourRegDtoMapper mapper;

    public List<TourRegDTO> getAllTournaments(
            List<TourRegEntity> registrations) {
        return mapper.mapListEntitiesToDTOs(registrations);
    }
}
