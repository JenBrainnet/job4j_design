CREATE TABLE customers (
	id SERIAL PRIMARY KEY,
	name TEXT
);

CREATE TABLE orders (
	id SERIAL PRIMARY KEY,
	total NUMERIC,
	created_at TIMESTAMP,
	customer_id INT REFERENCES customers(id)
);

SELECT c.name as "Покупатель", o.total as "Сумма заказа"
FROM customers as c INNER JOIN orders as o ON o.customer_id = c.id;

SELECT c.name "Покупатель", o.total "Сумма заказа", o.created_at "Дата заказа"
FROM customers c JOIN orders o ON o.customer_id = c.id;

SELECT c.name, o.total
FROM customers c JOIN orders o ON o.customer_id = c.id
WHERE o.total > 100;