create database traderjoey;

use traderjoey;

create table user (
	id int auto_increment,
	name varchar(20),
	password varchar(20),
	balance float,
	primary key(id),
	constraint name unique (name)
);

create table currency(
	id int not null auto_increment,
	name varchar(20) not null,
	current_price float not null,
	primary key(id),
	constraint name unique (name)
);

create table currency_price(
	record_id int auto_increment,
	price float not null,
	currency_id int not null,
	time_stamp timestamp not null,
	primary key(record_id),
	constraint currency_and_time unique (currency_id, time_stamp),
	constraint fk_currency foreign key (currency_id) references currency (id) 
	on delete cascade on update cascade
);
