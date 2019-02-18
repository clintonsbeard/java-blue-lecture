CREATE TABLE ourtable (
        id serial primary key,
        name varchar(35)
);

SELECT * FROM ourtable;

-- Can insert with a sequence by just omitting the column

INSERT INTO ourtable (name) VALUES ('Joe');

-- Can insert using the DEFAULT keyword

INSERT INTO ourtable (id, name) VALUES (DEFAULT, 'John');

-- Can get the next value in our sequence

SELECT nextval('ourtable_id_seq');

-- Can insert the id manually

INSERT INTO ourtable (id, name) VALUES (7, 'Beef Jeff');
INSERT INTO ourtable (id, name) VALUES (9, 'Beef Jane');

CREATE SEQUENCE our_custom_sequence START 101;
        
ALTER SEQUENCE our_custom_sequence RESTART 1000 INCREMENT BY 2;

START TRANSACTION;
INSERT INTO ourtable (id, name) VALUES (DEFAULT, 'Bill');
ROLLBACK;

DROP SEQUENCE our_custom_sequence;

DROP TABLE ourtable;

