CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    owner VARCHAR(50),
    balance INTEGER
);

INSERT INTO accounts(owner, balance) VALUES
('Alice', 100),
('Bob', 100);

-- Transaction 1 (window 1)
BEGIN ISOLATION LEVEL SERIALIZABLE;

SELECT * FROM accounts;

UPDATE accounts
SET balance = balance - 50
WHERE id = 1;

-- Transaction 2 (window 2)
BEGIN ISOLATION LEVEL SERIALIZABLE;

SELECT * FROM accounts;

UPDATE accounts
SET balance = balance - 50
WHERE id = 2;

COMMIT;

-- Transaction 1 (window 1)
COMMIT;

-- ERROR:
-- could not serialize access due to read/write dependencies among transactions
-- DETAIL:
-- Reason code: Canceled on identification as a pivot, during commit attempt.