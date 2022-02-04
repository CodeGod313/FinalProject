create table deposits_currencies(
	deposit_type_id bigserial primary key not null,
	deposit_name varchar(20),
	description text,
	termMonth int,
	interestRate decimal
)