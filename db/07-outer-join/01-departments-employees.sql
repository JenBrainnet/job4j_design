CREATE TABLE departments (
	id SERIAL PRIMARY KEY,
	name TEXT
);

CREATE TABLE employees (
	id SERIAL PRIMARY KEY,
	name TEXT,
	department_id INT REFERENCES departments(id)
);

-- insert departments
INSERT INTO departments(name) VALUES
('IT'),
('HR'),
('Sales'),
('Marketing');

-- insert employees
INSERT INTO employees(name, department_id) VALUES
('Alice', 1),
('Bob', 1),
('Charlie', 2),
('David', 3),
('Eva', NULL);

-- left join (all employees)
SELECT *
FROM employees e
LEFT JOIN departments d
ON e.department_id = d.id;

-- right join (all departments)
SELECT *
FROM employees e
RIGHT JOIN departments d
ON e.department_id = d.id;

-- cross join (all combinations)
SELECT *
FROM employees
CROSS JOIN departments;

-- departments without employees
SELECT *
FROM departments d
LEFT JOIN employees e
ON d.id = e.department_id
WHERE e.id IS NULL;

-- left and right join same result
SELECT e.id, e.name, e.department_id, d.id, d.name
FROM employees e
LEFT JOIN departments d
ON e.department_id = d.id;

SELECT e.id, e.name, e.department_id, d.id, d.name
FROM departments d
RIGHT JOIN employees e
ON d.id = e.department_id;
