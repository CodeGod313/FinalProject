create table deposits_currencies(
	currency_id bigint not null,
	deposit_type_id bigint not null,
	foreign key(currency_id) references currencies(currency_id),
	foreign key(deposit_type_id) references deposit_types(deposit_type_id)
);