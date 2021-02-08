ALTER TABLE players
ALTER COLUMN score TYPE int,
ALTER COLUMN damage_done TYPE int,
ALTER COLUMN damage_taken TYPE int,
ALTER COLUMN kd_ratio TYPE real;

ALTER TABLE matches
ALTER COLUMN acti_match_id TYPE decimal;

ALTER TABLE users
ALTER COLUMN uno_number SET NOT NULL;