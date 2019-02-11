-- SELECT ... FROM
-- Selecting the names for all countries
SELECT name FROM country;


-- Selecting the name and population of all countries
SELECT name, population FROM country;


-- Selecting all columns from the city table
SELECT * FROM city;


-- Select all unique countrycodes from the City table
SELECT DISTINCT countrycode FROM city;

-- Select the name for all countries as country_name
SELECT name AS country_name FROM country;

-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
SELECT * FROM city WHERE district = 'Ohio';


-- Selecting countries that gained independence in the year 1776
SELECT * FROM country WHERE indepyear = 1776;


-- Selecting countries not in Asia
SELECT * FROM country WHERE continent != 'Asia';
-- OR CAN WRITE ITE
SELECT * FROM country WHERE continent <> 'Asia';


-- Selecting countries that do not have an independence year
SELECT * FROM country WHERE indepyear IS NULL;

-- Selecting countries that do have an independence year
SELECT * FROM country WHERE indepyear IS NOT NULL;

-- Selecting countries that have a population greater than 5 million
SELECT * FROM country WHERE population > 5000000;



-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
SELECT * FROM city WHERE district = 'Ohio' AND population > 400000;

-- Selecting country names on the continent North America or South America
SELECT name FROM country WHERE continent = 'North America' OR continent = 'South America';
SELECT name FROM country WHERE continent IN ('North America', 'South America');

-- Select country names NOT on the contient North America or South America
SELECT name FROM country WHERE continent NOT IN ('North America', 'South America');

-- Select country names that BEGIN with the letter A
SELECT name FROM country WHERE name LIKE ('A%');

-- Select country names that END with the letter a
SELECT name FROM country WHERE name LIKE ('%a');

-- Select country names that have a letter a somewhere in them
SELECT name FROM country WHERE name LIKE ('%a%');

-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword
SELECT name, population, surfacearea, lifeexpectancy, (population / surfacearea) AS density FROM country
WHERE continent = 'Asia';



