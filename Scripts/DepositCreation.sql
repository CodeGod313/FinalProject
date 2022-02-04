create table deposits(
	deposit_id bigserial primary key not null,
	deposit_type_id bigint,
	user_id bigint,
	date_of_start date,
	rest decimal,
	foreign key(deposit_type_id) references deposit_types(deposit_type_id),
	foreign key(user_id) references users(user_id)
)