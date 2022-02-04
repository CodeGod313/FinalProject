create table deposit_types(
	deposit_type_id bigserial primary key not null,
	description text,
	min_number_of_month int,
	max_number_of_month int,
	is_revocable bool,
	interest_rate float
)