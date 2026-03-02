CREATE TABLE students(
	id SERIAL PRIMARY KEY,
	full_name VARCHAR(255),
	country VARCHAR(100),
	native_language VARCHAR(100),
	target_language VARCHAR(100)
);

CREATE TABLE student_auth(
	id SERIAL PRIMARY KEY,
	login VARCHAR(100) UNIQUE,
	password_hash TEXT,
	student_id INT REFERENCES students(id) UNIQUE
);