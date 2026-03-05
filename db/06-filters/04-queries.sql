-- Get all products with type "СЫР"
SELECT *
FROM products p
JOIN types t
ON p.type_id = t.id
WHERE t.name = 'СЫР';

-- Get all products where name contains "мороженое"
SELECT * FROM products
WHERE name ILIKE '%мороженое%';

-- Get all expired products
SELECT *
FROM products
WHERE expired_date < current_date;

-- Get the most expensive products
SELECT *
FROM products
WHERE price = (SELECT MAX(price) from products);

-- Count how many products each type has
SELECT t.name product_type, COUNT(*) product_count
FROM types t
JOIN products p
ON p.type_id = t.id
GROUP BY t.name;

-- Get products with type "СЫР" and "МОЛОКО"
SELECT p.name product, t.name product_type, p.expired_date, p.price
FROM products p
JOIN types t
ON p.type_id = t.id
WHERE t.name IN ('СЫР', 'МОЛОКО');

-- Get types with less than 10 products
SELECT t.name product_type, COUNT(*) product_count
FROM types t
JOIN products p
ON p.type_id = t.id
GROUP BY t.name
HAVING COUNT(*) < 10;

-- Get all products with their type
SELECT p.name product, t.name product_type
FROM products p
JOIN types t
ON p.type_id = t.id;