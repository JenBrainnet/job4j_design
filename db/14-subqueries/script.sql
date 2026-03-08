CREATE TABLE customers (
	id SERIAL PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	age INT,
	country TEXT
);

CREATE TABLE orders (
	id SERIAL PRIMARY KEY,
	amount INT,
	customer_id INT REFERENCES customers(id)
);

-- Insert data
INSERT INTO customers (first_name, last_name, age, country)
VALUES ('Иван', 'Иванов', 25, 'Россия'),
       ('Анна', 'Смирнова', 19, 'Россия'),
       ('John', 'Brown', 34, 'USA'),
       ('Maria', 'Garcia', 19, 'Spain'),
       ('Hans', 'Muller', 41, 'Germany');

INSERT INTO orders (amount, customer_id)
VALUES (1500, 1),
       (3200, 1),
       (2800, 2),
       (4100, 2);

-- Find customers with the minimum age
SELECT *
FROM customers c
WHERE c.age = (
	SELECT MIN(age)
	FROM customers
);

-- Find customers without orders
SELECT *
FROM customers c
WHERE c.id NOT IN (
	SELECT customer_id
	FROM orders
);