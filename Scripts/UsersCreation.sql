create type role_ as enum('admin', 'client');

create table users(
	user_id bigserial primary key not null,
	firstname varchar(20),
	lastname varchar(20),
	email varchar(20),
	user_password varchar(32),
	user_role role_
);