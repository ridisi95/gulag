DROP TYPE IF EXISTS tournament_role CASCADE;
CREATE TYPE tournament_role AS ENUM ('CREATED', 'STARTED', 'ENDED', 'CANCELED');

CREATE TABLE IF NOT EXISTS tournaments
(
    id              bigserial PRIMARY KEY,
    status          tournament_role NOT NULL DEFAULT 'CREATED',
    tournament_date timestamp       NOT NULL,
    title           text            NOT NULL
);

INSERT INTO tournaments (tournament_date, title)
VALUES ('2021-01-27 16:00:00', 'test tournament');

CREATE TABLE IF NOT EXISTS matches
(
    id            bigserial PRIMARY KEY,
    acti_match_id bigint UNIQUE,
    tournament_id bigint    NOT NULL,
    start_match   timestamp NOT NULL,
    end_match     timestamp NOT NULL,
    duration      int,
    mode          varchar(255),
    map           varchar(255),
    gameType      varchar(255),
    playerCount   smallint,

    FOREIGN KEY (tournament_id) REFERENCES tournaments(id)
);

INSERT INTO matches (tournament_id, acti_match_id, start_match, end_match, duration, mode, map, gameType, playerCount)
VALUES (CURRVAL(pg_get_serial_sequence('tournaments', 'id')), 7183715060602765683, to_timestamp(1606596490),
        to_timestamp(1606598098), 1608000, 'br_brduos', 'mp_don3', 'wz', 150);


DROP TABLE IF EXISTS players CASCADE;
CREATE TABLE players
(
    id                 bigserial PRIMARY KEY,
    match_id           bigint NOT NULL,
    uno_number         decimal NOT NULL,
    kills              smallint,
    assists            smallint,
    headshots          smallint,
    deaths             smallint,
    kd_ratio           numeric(3, 1),
    score              smallint,
    team_survival_time int,
    team_placement     smallint,
    damage_done        smallint,
    damage_taken       smallint,
    gulag_kills        smallint,
    gulag_deaths       smallint,

    FOREIGN KEY (match_id) REFERENCES matches(id)
);

INSERT INTO players (match_id, uno_number, kills, assists, headshots, deaths, kd_ratio, score, team_survival_time,
                     team_placement, damage_done, damage_taken, gulag_kills, gulag_deaths)
VALUES (CURRVAL(pg_get_serial_sequence('matches', 'id')), 13861154704693730868, 13, 2, 55, 3, 2, 1231, 1602000, 1, 6333,
        467, 1, 0);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE IF NOT EXISTS users
(
    id                    bigserial PRIMARY KEY,
    username              text UNIQUE,
    password              text,
    email                 text         NOT NULL,
    registration_date     timestamp    NOT NULL DEFAULT now(),
    uno_number            decimal UNIQUE,
    uno_tag               varchar(255) NOT NULL UNIQUE CHECK (uno_tag ~* '#'),
    number_of_wins        int          NOT NULL DEFAULT 0,
    number_of_appearances int          NOT NULL DEFAULT 0,
    role                  user_role    NOT NULL DEFAULT 'GUEST'
);

INSERT INTO users (password, username, role, uno_tag, email)
VALUES ('$2a$10$lGMpDZrP03AQFJ.M8/Kw9eMx/QxiIBGvIINUK75m2s/uN0PvXrIVq', 'user', 'USER', 'gulagUser#888',
        'gulaguser@888.com');
INSERT INTO users (password, username, role, uno_tag, email)
VALUES ('$2a$10$eEuQ3Z6UNRd5/Pa0r3rNfe3M2cYHxtaqSNIRiPlMuUKQVmgNOGIyy', 'admin', 'ADMIN', 'gulagAdmin#888',
        'gulaguadmin@888.com');
INSERT INTO users (password, username, role, uno_tag, email)
VALUES ('$2a$10$8.30IPrF7qhhgjE6Ykyp.uS4ckyREVuQqv6WSJ9OfZrbi6b3KJJMC', 'manager', 'MANAGER', 'gulagManager#888',
        'gulagmanager@888.com');
INSERT INTO users (password, username, role, uno_tag, email)
VALUES ('$2a$10$Z8U/34kBzu2TMmjgnjwelusfldWA764lHvfP62qi1/YzfHAL9FC4u', 'guest', 'GUEST', 'gulagGuest#888',
        'gulagguest@888.com');