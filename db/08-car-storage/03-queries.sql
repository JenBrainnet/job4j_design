-- cars with all details (some details can be NULL)
SELECT
c.id car_id,
c.name car_name,
b.name body_name,
e.name engine_name,
t.name transmission_name
FROM cars c
LEFT JOIN car_bodies b
ON c.body_id = b.id
LEFT JOIN car_engines e
ON c.engine_id = e.id
LEFT JOIN car_transmissions t
ON c.transmission_id = t.id;

-- bodies not used in any car
SELECT b.name unused_body
FROM car_bodies b
LEFT JOIN cars c
ON b.id = c.body_id
WHERE c.id IS NULL;

-- engines not used in any car
SELECT e.name unused_engine
FROM car_engines e
LEFT JOIN cars c
ON e.id = c.engine_id
WHERE c.id IS NULL;

-- transmissions not used in any car
SELECT t.name unused_transmission
FROM car_transmissions t
LEFT JOIN cars c
ON t.id = c.transmission_id
WHERE c.id IS NULL;