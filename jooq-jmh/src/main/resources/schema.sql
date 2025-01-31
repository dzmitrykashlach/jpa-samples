drop table if exists person;
drop table if exists  phone;
drop extension if exists "uuid-ossp" CASCADE;
create extension  if not exists "uuid-ossp";

create table if not exists person (
    id text primary key DEFAULT uuid_generate_v4(),
    first_name text not null,
    last_name text,
    age int,
    created_at timestamp not null default now()
);

create table if not exists phone (
	id text primary key DEFAULT uuid_generate_v4(),
	number text,
	created_at timestamp not null default now()
	);