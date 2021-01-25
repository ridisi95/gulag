CREATE TABLE IF NOT EXISTS tournament_registration
(
    tournament_id BIGINT NOT NULL,
    user_id       BIGINT NOT NULL,
    FOREIGN KEY (tournament_id) REFERENCES tournaments (id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT "TOUR_USER" PRIMARY KEY (tournament_id, user_id)
);

INSERT INTO tournament_registration (tournament_id, user_id)
VALUES (1, 3);
INSERT INTO tournament_registration (tournament_id, user_id)
VALUES (1, 1);
INSERT INTO tournament_registration (tournament_id, user_id)
VALUES (1, 2);
INSERT INTO tournament_registration (tournament_id, user_id)
VALUES (1, 4);


