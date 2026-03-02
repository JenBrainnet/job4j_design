create table lessons(
	id serial primary key,
	topic varchar(255),
	content text,
	created_at timestamp default now(),
	mentor_review_required boolean
);

insert into lessons(topic, content, mentor_review_required) values(
    'The difference between primitive and reference data types',
    'Primitive types hold simple values directly (e.g., numbers, characters), while reference types store references (memory addresses) to objects.',
    false
);

update lessons set mentor_review_required=true;

delete from lessons;