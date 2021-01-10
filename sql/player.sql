create table player
(
	id serial not null,
	first_name varchar,
	last_name varchar,
	email varchar,
	phone_number varchar,
	number_of_wins int not null,
	number_of_appearances int not null,
	uno int not null,
	battle varchar,
	psn varchar,
	steam varchar,
	xbl varchar,
	acti varchar not null
);

create unique index player_email_uindex
	on player (email);

create unique index player_id_uindex
	on player (id);

create unique index player_phone_number_uindex
	on player (phone_number);

alter table player
	add constraint player_pk
		primary key (id);

