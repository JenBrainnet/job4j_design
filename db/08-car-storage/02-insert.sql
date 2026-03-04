INSERT INTO car_bodies(name) VALUES
('sedan'),
('hatchback'),
('pickup'); -- unused

INSERT INTO car_engines(name) VALUES
('petrol 1.6'),
('diesel 2.0'),
('electric'); -- unused

INSERT INTO car_transmissions(name) VALUES
('manual'),
('automatic'),
('cvt'); -- unused

INSERT INTO cars(name, body_id, engine_id, transmission_id) VALUES
('Toyota Corolla', 1, 1, 2),
('Honda Civic', 2, 2, 1),
('Mystery Car', 1, NULL, 1), -- no engine
('Old Sedan', 1, 1, NULL); -- no transmission