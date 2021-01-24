package com.gulag.relationship;

import com.gulag.entity.UserEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourRegRelationId implements Serializable {

    Long tournamentId;
    UserEntity user;
}
