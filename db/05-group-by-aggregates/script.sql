CREATE TABLE devices (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	price NUMERIC(10,2)
);

CREATE TABLE people (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE devices_people (
	id SERIAL PRIMARY KEY,
	device_id INT REFERENCES devices(id),
	people_id INT REFERENCES people(id)
);

INSERT INTO devices(name, price) VALUES
('Phone', 10000),
('Laptop', 80000),
('Tablet', 30000),
('Smart Watch', 7000),
('Gaming PC', 150000),
('Headphones', 4000);

INSERT INTO people(name) VALUES
('Jen'),
('Petr'),
('Maria');

INSERT INTO devices_people(device_id, people_id) VALUES
(1, 1),  -- Jen - Phone (10000)
(2, 1),  -- Jen - Laptop (80000)

(3, 2),  -- Petr - Tablet (30000)
(4, 2),  -- Petr - Smart Watch (7000)

(6, 3);  -- Maria - Headphones (4000)

SELECT ROUND(AVG(d.price),2) average_price
FROM devices d;

SELECT p.name person, ROUND(AVG(d.price), 2) average_price
FROM people p
JOIN devices_people dp
ON dp.people_id = p.id
JOIN devices d
ON dp.device_id = d.id
GROUP BY p.name;

SELECT p.name person, ROUND(AVG(d.price), 2) average_price
FROM people p
JOIN devices_people dp
ON dp.people_id = p.id
JOIN devices d
ON dp.device_id = d.id
GROUP BY p.name
HAVING ROUND(AVG(d.price), 2) > 5000;