CREATE TABLE students (
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE authors (
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200),
    author_id INTEGER REFERENCES authors (id)
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    active BOOLEAN DEFAULT true,
    book_id INTEGER REFERENCES books (id),
    student_id INTEGER REFERENCES students (id)
);