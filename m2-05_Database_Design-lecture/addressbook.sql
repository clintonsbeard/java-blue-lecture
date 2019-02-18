DROP TABLE IF EXISTS person;

CREATE TABLE person
(
        person_id serial primary key,
        first_name varchar(100) not null,
        last_name varchar(100) not null,
        date_added timestamp not null,
        type varchar(100),
        update_date timestamp
);

CREATE TABLE address
(
        address_id serial primary key,
        street_address varchar(255) not null,
        street_address2 varchar(255),
        city varchar(100) not null,
        district varchar(255) not null,
        postal_code varchar(25) not null,
        country_code char(3),
        address_type varchar(20) not null,
        other_description varchar(100),
        
        constraint chk_address_type CHECK (address_type IN ('Home', 'Work', 'Shipping', 'Billing', 'Other')),
        constraint chk_other_description CHECK ( (address_type = 'Other' AND other_description IS NOT NULL) OR (address_type <> 'Other' AND other_description IS NULL) )
);

CREATE TABLE person_address
(
        person_id int not null,
        address_id int not null,
        
        constraint fk_person_address_person_id foreign key (person_id) references person (person_id);
        constraint fk_person_address_address_id foreign key (address_id) references address (address_id);
)

CREATE USER john WITH PASSWORD '123';

SELECT * FROM address;

GRANT SELECT ON person TO john;

INSERT INTO person (first_name, last_name, date_added) VALUES ('John', 'Beefjeff', current_timestamp);

GRANT INSERT ON person TO john;

GRANT USAGE, SELECT ON SEQUENCE person_person_id_seq TO john;

REVOKE SELECT ON person FROM john;