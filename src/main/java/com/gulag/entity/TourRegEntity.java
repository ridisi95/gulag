package com.gulag.entity;

import com.gulag.relationship.TourRegRelationId;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tournament_registration")
@NoArgsConstructor
@IdClass(TourRegRelationId.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourRegEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    TournamentEntity tournament;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;
}
