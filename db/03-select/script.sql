-- Create table for fauna
CREATE TABLE fauna
(
	id SERIAL PRIMARY KEY,
	name TEXT,
	avg_age INT,
	discovery_date DATE
);

-- Insert sample data into fauna table
INSERT INTO fauna(name, avg_age, discovery_date)
VALUES ('goldfish', 12000, '1900-01-01');

INSERT INTO fauna(name, avg_age, discovery_date)
VALUES ('catfish', 15000, '1850-05-10');

INSERT INTO fauna(name, avg_age, discovery_date)
VALUES ('dog', 5000, '1955-03-01');

INSERT INTO fauna(name, avg_age, discovery_date)
VALUES ('parrot', 20000, '1940-07-07');

INSERT INTO fauna(name, avg_age, discovery_date)
VALUES ('mystery fish', 18000, NULL);

INSERT INTO fauna(name, avg_age, discovery_date)
VALUES ('turtle', 30000, '1920-06-15');

-- selects
SELECT * FROM fauna WHERE name LIKE '%fish%';

SELECT * FROM fauna WHERE avg_age BETWEEN 10000 AND 21000;

SELECT * FROM fauna WHERE discovery_date IS NULL;

SELECT * FROM fauna WHERE discovery_date < '1950-01-01';
