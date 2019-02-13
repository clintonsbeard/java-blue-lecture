-- These queries require the JOINS database

--INNER JOIN  (DEFAULT IF JUST USE JOIN)
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one 
-- Complte the Inner Join Here


--LEFT JOIN  (Left Outer Join)
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
-- Complte the Left Join Here


--RIGHT JOIN  (Right Outer Join)
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
-- Complte the Right Join Here


--FULL OUTER JOIN
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
-- Complte the Full Outer Join Here


--Everything from ONLY the left table
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
-- Complte the Join Here


--Everything from ONLY the right table
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
-- Complte the Join Here


--Everything in ONLY the Left or Right table, but not both
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
-- Complte the Join Here


--UNION
-- Create a Union between the two tables that shows all values from both in two columns








