CREATE TABLE students(
	id SERIAL PRIMARY KEY,
	full_name VARCHAR(255)
);

CREATE TABLE payments(
	id SERIAL PRIMARY KEY,
	amount NUMERIC,
	created_at TIMESTAMP,
	student_id INT REFERENCES students(id)
);