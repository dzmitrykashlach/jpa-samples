drop table if exists address;
drop table if exists  user_details;
drop extension if exists "uuid-ossp" CASCADE;
create extension  if not exists "uuid-ossp";
create table if not exists user_details (
	id text primary key DEFAULT uuid_generate_v4(),
	name text not null,
	email text,
	mobile_number text,
	created_at timestamp not null default now(),
	updated_at timestamp
);

create table if not exists address (
	id text primary key DEFAULT uuid_generate_v4(),
	address1 text,
	address2 text,
	street text,
	city text,
	state text,
	country text,
	user_id text,
	created_at timestamp not null default now(),
	updated_at timestamp

)