CREATE TABLE IF NOT EXISTS players
(
    id                    bigserial PRIMARY KEY,
    first_name            text,
    last_name             text,
    email                 text UNIQUE,
    phone_number          text UNIQUE,
    number_of_wins        int  NOT NULL,
    number_of_appearances int  NOT NULL,
    uno                   int  NOT NULL,
    battle                text,
    psn                   text,
    steam                 text,
    xbl                   text,
    acti                  text NOT NULL
);

CREATE TYPE user_role AS ENUM ('GUEST', 'USER', 'MANAGER', 'ADMIN');

CREATE TABLE IF NOT EXISTS users
(
    id       bigserial PRIMARY KEY,
    username text UNIQUE,
    password text,
    role     user_role NOT NULL DEFAULT 'GUEST'
);

CREATE SEQUENCE IF NOT EXISTS user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE user_id_seq OWNED BY users.id;
ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);

INSERT INTO users (password, username, role)
VALUES ('$2a$10$lGMpDZrP03AQFJ.M8/Kw9eMx/QxiIBGvIINUK75m2s/uN0PvXrIVq', 'user', 'USER');
INSERT INTO users (password, username, role)
VALUES ('$2a$10$eEuQ3Z6UNRd5/Pa0r3rNfe3M2cYHxtaqSNIRiPlMuUKQVmgNOGIyy', 'admin', 'ADMIN');
INSERT INTO users (password, username, role)
VALUES ('$2a$10$8.30IPrF7qhhgjE6Ykyp.uS4ckyREVuQqv6WSJ9OfZrbi6b3KJJMC', 'manager', 'MANAGER');
INSERT INTO users (password, username, role)
VALUES ('$2a$10$Z8U/34kBzu2TMmjgnjwelusfldWA764lHvfP62qi1/YzfHAL9FC4u', 'guest', 'GUEST');