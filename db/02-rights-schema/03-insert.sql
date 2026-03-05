-- roles
INSERT INTO roles(name) VALUES ('admin');
INSERT INTO roles(name) VALUES ('user');

-- rules
INSERT INTO rules(name) VALUES ('CREATE_ITEM');
INSERT INTO rules(name) VALUES ('READ_ITEM');
INSERT INTO rules(name) VALUES ('UPDATE_ITEM');
INSERT INTO rules(name) VALUES ('DELETE_ITEM');
INSERT INTO rules(name) VALUES ('ADD_COMMENT');
INSERT INTO rules(name) VALUES ('ADD_ATTACH');

-- rules_roles (many-to-many)
-- admin gets all rules
INSERT INTO rules_roles(rule_id, role_id) VALUES (1, 1);
INSERT INTO rules_roles(rule_id, role_id) VALUES (2, 1);
INSERT INTO rules_roles(rule_id, role_id) VALUES (3, 1);
INSERT INTO rules_roles(rule_id, role_id) VALUES (4, 1);
INSERT INTO rules_roles(rule_id, role_id) VALUES (5, 1);
INSERT INTO rules_roles(rule_id, role_id) VALUES (6, 1);
-- user gets limited rules
INSERT INTO rules_roles(rule_id, role_id) VALUES (1, 2);
INSERT INTO rules_roles(rule_id, role_id) VALUES (2, 2);
INSERT INTO rules_roles(rule_id, role_id) VALUES (5, 2);
INSERT INTO rules_roles(rule_id, role_id) VALUES (6, 2);

-- users
INSERT INTO users(name, role_id) VALUES ('Jen', 1);
INSERT INTO users(name, role_id) VALUES ('Petr', 2);

-- states
INSERT INTO states(name) VALUES ('NEW');
INSERT INTO states(name) VALUES ('IN_PROGRESS');
INSERT INTO states(name) VALUES ('DONE');

-- categories
INSERT INTO categories(name) VALUES ('Bug');
INSERT INTO categories(name) VALUES ('Feature');
INSERT INTO categories(name) VALUES ('Question');

-- items
INSERT INTO items(name, user_id, category_id, state_id)
VALUES ('Cannot login', 1, 1, 1);

INSERT INTO items(name, user_id, category_id, state_id)
VALUES ('Add dark mode', 1, 2, 2);

-- comments
INSERT INTO comments(text, item_id)
VALUES ('Please fix this issue', 1);

INSERT INTO comments(text, item_id)
VALUES ('Any updates?', 1);

INSERT INTO comments(text, item_id)
VALUES ('Dark mode would be great', 2);

-- attachs
INSERT INTO attachs(path, item_id)
VALUES ('/files/screenshot1.png', 1);

INSERT INTO attachs(path, item_id)
VALUES ('/files/log.txt', 1);