-- students
INSERT INTO students (name) VALUES
('Иван Иванов'),
('Петр Петров');

-- authors
INSERT INTO authors (name) VALUES
('Александр Пушкин'),
('Николай Гоголь');

-- books
INSERT INTO books (name, author_id) VALUES
('Евгений Онегин', 1),
('Капитанская дочка', 1),
('Дубровский', 1),
('Мертвые души', 2),
('Вий', 2),
('Сказка о медведихе', 1),
('Записки П. В. Нащокина', 1);

-- orders
INSERT INTO orders (book_id, student_id) VALUES
(1, 1),
(3, 1),
(5, 2),
(4, 1),
(2, 2),
(1, 2);