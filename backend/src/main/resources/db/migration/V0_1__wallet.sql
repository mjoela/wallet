
/* Create Tables */

CREATE TABLE wallet
(
	id serial primary key,
	name varchar(30) NOT NULL,
	balance decimal(15, 2) NOT NULL
);

