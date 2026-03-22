CREATE TABLE companies (
    id INTEGER NOT NULL,
    name CHARACTER VARYING,
    CONSTRAINT companies_pkey PRIMARY KEY (id)
);

CREATE TABLE people (
    id INTEGER NOT NULL,
    name CHARACTER VARYING,
    company_id INTEGER REFERENCES companies(id),
    CONSTRAINT people_pkey PRIMARY KEY (id)
);