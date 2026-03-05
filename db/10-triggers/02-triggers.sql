-- AFTER INSERT (statement level)
-- Add 20% tax to product price
CREATE
OR REPLACE FUNCTION tax_after()
RETURNS trigger AS
$$
	BEGIN
		UPDATE products p
		SET price = p.price * 1.2
		FROM inserted i
		WHERE p.id = i.id;
		RETURN NULL;
	END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tax_trigger_after
AFTER INSERT
ON products
REFERENCING NEW TABLE AS inserted
FOR EACH STATEMENT
EXECUTE FUNCTION tax_after();

-- BEFORE INSERT (row level)
-- Add 20% tax to product price
CREATE OR REPLACE FUNCTION tax_before()
RETURNS trigger AS
$$
BEGIN
	NEW.price := NEW.price * 1.2;
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tax_trigger_before
BEFORE INSERT
ON products
FOR EACH ROW
EXECUTE FUNCTION tax_before();

-- AFTER INSERT (row level)
-- Save product price to history table
CREATE OR REPLACE FUNCTION log_price_history()
RETURNS trigger AS
$$
	BEGIN
		INSERT INTO history_of_price (name, price, date)
		VALUES (NEW.name, NEW.price, now());
		RETURN NEW;
	END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER trg_log_price_history
AFTER INSERT ON products
FOR EACH ROW
EXECUTE FUNCTION log_price_history();
