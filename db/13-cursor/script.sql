CREATE TABLE products (
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(50),
    count INTEGER DEFAULT 0,
    price INTEGER
);

-- Insert test data
INSERT INTO products (name, count, price)
VALUES
('product_1', 1, 5),
('product_2', 2, 10),
('product_3', 3, 15),
('product_4', 4, 20),
('product_5', 5, 25),
('product_6', 6, 30),
('product_7', 7, 35),
('product_8', 8, 40),
('product_9', 9, 45),
('product_10', 10, 50),
('product_11', 11, 55),
('product_12', 12, 60),
('product_13', 13, 65),
('product_14', 14, 70),
('product_15', 15, 75),
('product_16', 16, 80),
('product_17', 17, 85),
('product_18', 18, 90),
('product_19', 19, 95),
('product_20', 20, 100);

BEGIN;

-- Declare scroll cursor
DECLARE
curs_products SCROLL CURSOR FOR
SELECT * FROM products;

-- Move to product_20
FETCH LAST FROM curs_products;

-- Move to product_5
MOVE BACKWARD 4 FROM curs_products;
FETCH BACKWARD 1 FROM curs_products;

-- Move to product_7
MOVE BACKWARD 7 FROM curs_products;
FETCH BACKWARD 1 FROM curs_products;

-- Move to product_2
MOVE BACKWARD 4 FROM curs_products;
FETCH BACKWARD 1 FROM curs_products;

-- Move to product_1
FETCH BACKWARD 1 FROM curs_products;

CLOSE curs_products;

COMMIT;