CREATE TABLE movies (
    id       SERIAL PRIMARY KEY,
    name     TEXT,
    director TEXT
);

CREATE TABLE books (
    id     SERIAL PRIMARY KEY,
    title  TEXT,
    author TEXT
);

-- Insert data
INSERT INTO movies (name, director)
VALUES ('Марсианин', 'Ридли Скотт'),
       ('Матрица', 'Братья Вачовски'),
       ('Властелин колец', 'Питер Джексон'),
       ('Гарри Поттер и узник Азкабана', 'Альфонсо Куарон'),
       ('Железный человек', 'Джон Фавро');

INSERT INTO books (title, author)
VALUES ('Гарри Поттер и узник Азкабана', 'Джоан Роулинг'),
       ('Властелин колец', 'Джон Толкин'),
       ('1984', 'Джордж Оруэлл'),
       ('Марсианин', 'Энди Уир'),
       ('Божественная комедия', 'Данте Алигьери');

-- Movies based on books
SELECT name FROM movies
INTERSECT
SELECT title FROM books;

-- Books without film adaptations
SELECT title FROM books
EXCEPT
SELECT name FROM movies;

-- Unique titles from movies and books
(SELECT title FROM books
EXCEPT
SELECT name FROM movies)
UNION ALL
(SELECT name FROM movies
EXCEPT
SELECT title FROM books);