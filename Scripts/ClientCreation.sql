create table clients(
	client_id bigint,
	passport_id varchar(9),
	phone_number varchar(13),
	foreign key(client_id) references users (user_id)
)