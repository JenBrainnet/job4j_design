CREATE TABLE cart_items (
	id SERIAL PRIMARY KEY,
	item_name VARCHAR(50),
	price INTEGER,
	quantity INTEGER
);

BEGIN;

-- 1. Add MacBook Pro
INSERT INTO cart_items (item_name, price, quantity)
VALUES ('MacBook Pro', 360000, 1);

SAVEPOINT after_macbook_added;

SELECT * FROM cart_items;

-- 2. Add Magic Mouse
INSERT INTO cart_items (item_name, price, quantity)
VALUES ('Magic Mouse', 20000, 1);

SAVEPOINT after_mouse_added;

SELECT * FROM cart_items;

-- 3. Delete Magic Mouse
DELETE FROM cart_items
WHERE item_name = 'Magic Mouse';

-- 4. Roll back deletion of Magic Mouse
ROLLBACK TO SAVEPOINT after_mouse_added;

SELECT * FROM cart_items;

-- 5. Roll back addition of Magic Mouse
ROLLBACK TO SAVEPOINT after_macbook_added;

SELECT * FROM cart_items;

COMMIT;

SELECT * FROM cart_items;