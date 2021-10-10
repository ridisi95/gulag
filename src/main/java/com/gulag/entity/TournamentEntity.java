package com.gulag.entity;

import com.gulag.enums.TournamentStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
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
    TournamentStatus status;

    @Column(nullable = false)
    Date tournamentDate;

    @Column(nullable = false)
    String title;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_id")
    Set<MatchEntity> matchEntityList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tournament_registration",
            joinColumns = { @JoinColumn(name = "tournament_id")},
            inverseJoinColumns = { @JoinColumn(name = "user_id")}
    )
    Set<UserEntity> users;

    public void addMatch(MatchEntity matchEntity) {
        matchEntityList.add(matchEntity);
        matchEntity.setTournament(this);
    }
}
