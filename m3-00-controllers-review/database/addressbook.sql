-- The Order that tables are drops matters, they must be dropped so that tables with foreign key relationships are
-- dropped first
DROP TABLE IF EXISTS person_address;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS phone;


-- The Order tables are crated matters, they must be created such that tables that form relationships with other tables
-- are created before those relationships are formed.
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
        street_address_line_two varchar(255),
        city varchar(100) not null,
        district varchar(255) not null,
        postal_code varchar(25) not null,
        country_code char(3),
        address_type varchar(20) not null,
        other_description varchar(100),
        
        constraint chk_address_type CHECK (address_type IN ('Home', 'Work', 'Shipping', 'Billing', 'Other')),
        constraint chk_other_address_description CHECK ( (address_type = 'Other' AND other_description IS NOT NULL ) OR ( address_type <> 'Other' AND other_description IS NULL)  )
);

CREATE TABLE person_address
(
        person_id int not null,
        address_id int not null,
        
        constraint fk_person_address_person_id foreign key (person_id) references person(person_id),
        constraint fk_person_address_address_id foreign key (address_id) references address(address_id)      
);

CREATE TABLE phone
(
        phone_id serial primary key,
        phone_number varchar(100) not null,
        phone_type varchar(20) not null,
        other_description varchar(100),

        constraint chk_phone_type CHECK (phone_type IN ('Home', 'Work', 'Mobile', 'Other')),
        constraint chk_other_phone_description CHECK ( (phone_type = 'Other' AND other_description IS NOT NULL ) OR ( phone_type <> 'Other' AND other_description IS NULL)  )
);

CREATE TABLE person_phone
(
        person_id int not null,
        phone_id int not null,
        
        constraint fk_person_phone_person_id foreign key (person_id) references person(person_id),
        constraint fk_person_phone_phone_id foreign key (phone_id) references phone(phone_id)      
);


CREATE TABLE email
(
        email_id serial primary key,
        email_address varchar(100) not null,
        email_type varchar(20) not null,
        other_description varchar(100),

        constraint chk_email_type CHECK (email_type IN ('Home', 'Work', 'Other')),
        constraint chk_other_email_description CHECK ( (email_type = 'Other' AND other_description IS NOT NULL ) OR ( email_type <> 'Other' AND other_description IS NULL)  )
);

CREATE TABLE person_email
(
        person_id int not null,
        email_id int not null,
        
        constraint fk_person_email_person_id foreign key (person_id) references person(person_id),
        constraint fk_person_email_email_id foreign key (email_id) references email(email_id)      
);


-- Insert a Person, current_timestamp inserts the current date (today) and time (now)
INSERT INTO person (first_name, last_name, date_added) VALUES ('Dave', 'Fulton', current_timestamp);



-- ****************************************************
-- * Data Control Language  ( DCL )
-- ****************************************************

-- Creating a user
--CREATE USER john WITH PASSWORD '123';

-- Granting pemissions on a table to a user
-- GRANT SELECT ON person TO john;
-- GRANT INSERT ON person TO john;

-- Granting persmission to use a seuqence to a user
--GRANT USAGE, SELECT ON SEQUENCE person_person_id_seq TO john;

-- Removing access (Revoking) to select on a table from a user
--REVOKE SELECT ON person FROM john;