CREATE TABLE teens (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100),
	gender CHAR(1)
);

-- insert teens
INSERT INTO teens(name, gender) VALUES
('Vasya', 'M'),
('Petya', 'M'),
('Kolya', 'M'),
('Masha', 'F'),
('Olga', 'F'),
('Anna', 'F');

-- cross join: all possible pairs
-- only different gender
-- remove duplicates (f.e. Vasya-Masha and Masha-Vasya)
SELECT *
FROM teens t1
CROSS JOIN teens t2
WHERE t1.gender != t2.gender
AND t1.id < t2.id;