CREATE TABLE roles (
	id SERIAL PRIMARY KEY,
	name TEXT
);

CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	name TEXT,
	role_id INT REFERENCES roles(id)
);

CREATE TABLE rules (
	id SERIAL PRIMARY KEY,
	name TEXT
);

CREATE TABLE rules_roles(
	id SERIAL PRIMARY KEY,
	rule_id INT REFERENCES rules(id),
	role_id INT REFERENCES roles(id)
);


CREATE TABLE categories (
	id SERIAL PRIMARY KEY,
	name TEXT
);

CREATE TABLE states (
	id SERIAL PRIMARY KEY,
	name TEXT
);

CREATE TABLE items (
	id SERIAL PRIMARY KEY,
	name TEXT,
	user_id INT REFERENCES users(id),
	category_id INT REFERENCES categories(id),
	state_id INT REFERENCES states(id)
);

CREATE TABLE comments (
	id SERIAL PRIMARY KEY,
	text TEXT,
	item_id INT REFERENCES items(id)
);

CREATE TABLE attachs (
	id SERIAL PRIMARY KEY,
	path TEXT,
	item_id INT REFERENCES items(id)
);