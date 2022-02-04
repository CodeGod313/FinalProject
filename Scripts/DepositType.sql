create table accounts(
	account_id bigserial primary key not null,
	currency_id bigint,
	user_id bigint,
	account_value decimal,
	foreign key(currency_id) references currencies(currency_id),
	foreign key(user_id) references users(user_id)
);