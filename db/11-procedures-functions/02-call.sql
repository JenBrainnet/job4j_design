-- Procedure: delete by id
CREATE OR REPLACE
PROCEDURE delete_by_id(d_id integer)
LANGUAGE plpgsql
AS
$$
	BEGIN
		DELETE FROM products
		WHERE id = d_id;
	END;
$$;

CALL delete_by_id(1);

-- Function: delete out-of-stock products
-- Returns the number of deleted rows
CREATE OR REPLACE
FUNCTION f_delete_out_of_stock_products()
RETURNS integer
LANGUAGE plpgsql
AS
$$
	DECLARE
		deleted_count integer;
	BEGIN
		DELETE FROM products
		WHERE count = 0;

		GET DIAGNOSTICS deleted_count = ROW_COUNT;
		RETURN deleted_count;
	END;
$$;

SELECT f_delete_out_of_stock_products();