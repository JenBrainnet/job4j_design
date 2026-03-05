CREATE TABLE products (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	producer VARCHAR(50),
	count INTEGER DEFAULT 0,
	price INTEGER
);

CREATE TABLE history_of_price (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	price INTEGER,
	date TIMESTAMP
);
