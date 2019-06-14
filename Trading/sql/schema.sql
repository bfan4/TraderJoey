create database traderjoey;

create table user (
	id int auto_increment,
	name varchar(20),
	password varchar(20),
	primary key(id)
);

create table currency(
	name varchar(20) not null,
	currency_price float not null,
	primary key(name)
);