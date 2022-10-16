create table roles(
	role_id bigserial primary key not null,
	role_name varchar(10) not null
);

create table users(
	user_id bigserial primary key not null,
	role_id bigint not null,
	isConfirmed boolean not null default false,
	confirmationCode varchar(40) not null,
	first_name varchar(15) not null,
	last_name varchar(15) not null,
	email varchar(25) not null,
	user_password varchar(16) not null,
	foreign key(role_id) references roles(role_id)
);

create table clients(
	client_id bigint primary key not null,
	passport_series varchar(2) not null,
	passport_number varchar(7) not null,
	foreign key(client_id) references users(user_id)
);


create table companies(
	company_id bigserial primary key not null,
	company_name varchar(20),
	company_short_name varchar(5),
	company_description text,
	share_price decimal not null,
	share_quantity int not null,
	image_path varchar(40) not null
);

create table shares(
	share_id bigserial primary key not null,
	owner_id bigint not null,
	company_id bigint not null,
	shares_number int not null, 
	foreign key(owner_id) references clients(client_id),
	foreign key(company_id) references companies(company_id)
);

create table accounts(
	account_id bigserial primary key not null,
	client_id bigint not null,
	account_value decimal not null,
	foreign key(client_id) references clients(client_id)
);

create table coin_type(
	coin_type_id bigserial primary key not null,
	coin_name varchar(20) not null,
	short_name varchar(5) not null,
	description text,
	coin_function varchar(10) not null,
	price decimal not null
);

create table coins_accounts(
	coins_account_id bigserial primary key not null,
	coin_type bigint not null,
	owner_id bigint not null,
	coins_count decimal not null,
	foreign key(owner_id) references clients(client_id),
	foreign key(coin_type) references coin_types(coin_type_id)
);

create table companies_price_changes(
	change_id bigserial not null,
	change_time timestamp not null,
	company_id bigint not null,
	old_price decimal not null,
	updated_price decimal not null,
	foreign key(company_id) references companies(company_id)
);

create table cryptos_price_changes(
	change_id bigserial not null,
	change_time timestamp not null,
	crypto_id bigint not null,
	foreign key(crypto_id) references cryptos(crypto_id)
);
