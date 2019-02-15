--drop table customer_purchases;
--drop table art;
--drop table artists;
--drop table customers;

BEGIN TRANSACTION;

CREATE TABLE customers
(
	customerId serial,
	name varchar(64) not null,
	address varchar(100) not null,
	phone varchar(11) null,

	constraint pk_customers primary key (customerId)
);

CREATE TABLE artists
(
	artistId serial,
	firstName varchar(64) not null,
	lastName varchar(64) not null,

	constraint pk_artists primary key (artistId)
);

CREATE TABLE art
(
	artCodeId serial,
	title varchar(64) not null,
	artistId int not null,

	constraint pk_art primary key (artCodeId),
	constraint fk_art_artists foreign key (artistId) references artists (artistId)
);

CREATE TABLE customer_purchases
(
	customerId int not null,
	artCodeId int not null,
	purchaseDate timestamp not null,
	price money not null,

	constraint pk_customer_purchases primary key (customerId, artCodeId, purchaseDate),
	constraint fk_customer_purchases_customer foreign key (customerId) references customers (customerId),
	constraint fk_customer_purchases_art foreign key (artCodeId) references art(artCodeId)
);


COMMIT TRANSACTION;



