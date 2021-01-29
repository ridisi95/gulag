package com.gulag.entity;

import com.gulag.enums.TournamentRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicInsert
@Table(name = "tournaments")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TournamentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @GeneratedValue
    @Enumerated(EnumType.STRING)
    TournamentRole status;
    @Column(nullable = false)
    Date tournamentDate;
    @Column(nullable = false)
    String title;

}
