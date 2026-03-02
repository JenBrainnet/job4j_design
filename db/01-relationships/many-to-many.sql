CREATE TABLE students(
	id SERIAL PRIMARY KEY,
	full_name VARCHAR(255)
);

CREATE TABLE tutors(
	id SERIAL PRIMARY KEY,
	full_name VARCHAR(255)
);

CREATE TABLE students_tutors(
	id SERIAL PRIMARY KEY,
	student_id INT REFERENCES students(id),
	tutor_id INT REFERENCES tutors(id)
);