create table if not exists user(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(64),
	password VARCHAR(64),
	PRIMARY KEY(id)
);

create table if not exists account(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	user_id bigint(20) NOT NULL,
	billing_address VARCHAR(255),
	billing_province VARCHAR(4),
	billing_country VARCHAR(128),
	phone_number VARCHAR(15),
	zip VARCHAR(32),
	PRIMARY KEY(id),
	FOREIGN KEY(user_id) REFERENCES user(id)
);

create table if not exists book(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	title VARCHAR(128),
	author VARCHAR(64),
	account_id bigint(20) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(account_id) REFERENCES account(id)
);

create table if not exists chapter(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	title VARCHAR(255),
	book_id bigint(20) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(book_id) REFERENCES book(id)
);

create table if not exists exercise(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	chapter_id bigint(20) NOT NULL,
	exercise VARCHAR(32),
	answer INT,
	question VARCHAR(255),
	one VARCHAR(255),
	two VARCHAR(255),
	three VARCHAR(255),
	PRIMARY KEY(id),
	FOREIGN KEY(chapter_id) REFERENCES chapter(id)
);