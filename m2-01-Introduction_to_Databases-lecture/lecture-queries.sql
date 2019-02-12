-- SELECT ... FROM

-- Selecting the names for all countries

SELECT name FROM country;

-- Selecting the name and population of all countries

SELECT name, population FROM country;

-- Selecting all columns from the city table

SELECT * FROM city;

-- Selecting all unique country codes from the city table

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

-- Selecting country names not on the continent North America or South America

SELECT name FROM country WHERE continent != 'North America' OR continent != 'South America';
SELECT name FROM country WHERE continent NOT IN ('North America', 'South America');

-- Selecting country names that begin with the letter "A"

SELECT name FROM country WHERE name LIKE ('A%');

-- Selecting country names that end with the letter "a"

SELECT name FROM country WHERE name LIKE ('%a');

-- Selecting country names that have the letter "a" somewhere in them

SELECT name FROM country WHERE name LIKE ('%a%');

-- SELECTING DATA w/arithmetic

-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword

SELECT population, lifeexpectancy, (population / surfacearea) AS populationperarea FROM country;