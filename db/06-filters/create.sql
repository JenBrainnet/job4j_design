CREATE TABLE types (
	id SERIAL PRIMARY KEY,
	name TEXT UNIQUE
);

CREATE TABLE products (
	id SERIAL PRIMARY KEY,
	name TEXT,
	expired_date DATE,
	price NUMERIC(10, 2),
	type_id INT REFERENCES types(id)
);