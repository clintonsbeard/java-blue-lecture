-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT name, population
FROM country
ORDER BY population DESC; 

--Names of countries and continents in ascending order
SELECT name, continent
FROM country
ORDER BY continent ASC, name ASC;


-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC
LIMIT 10;

-- Can use any mathmatical operators
-- The round function, rounds any result to a set precision   round(value, places_to_right_of_the_decimal_point)
select name, round(gnp / population, 4) AS per_capita_gnp from country WHERE gnp > 0;

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city
SELECT (name || ', ' || district) AS name_and_state
FROM city
WHERE district IN ('California', 'Oregon', 'Washington')
ORDER BY district, name;

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World
SELECT AVG(lifeexpectancy) 
FROM country;

-- Total population in Ohio
SELECT SUM(population)
FROM city
WHERE district = 'Ohio';

-- The surface area of the smallest country in the world
SELECT MIN(surfacearea)
FROM country; 

-- The 10 largest countries in the world
SELECT *
FROM country
ORDER BY surfacearea DESC
LIMIT 10;

-- The number of countries who declared independence in 1991
SELECT COUNT(*)
FROM country
WHERE indepyear = 1991;


SELECT MIN(population), region FROM country
GROUP BY region;


-- GROUP BY
-- Count the number of countries where each language is spoken, ordered from most countries to least
SELECT language, COUNT(countrycode) AS countries
FROM countrylanguage
GROUP BY language
ORDER BY countries DESC;

-- Average life expectancy of each continent ordered from highest to lowest
SELECT continent, AVG(lifeexpectancy) AS avg_lifeexpectancy
FROM country
GROUP BY continent
ORDER BY avg_lifeexpectancy DESC;

-- Exclude Antarctica from consideration for average life expectancy
SELECT continent, AVG(lifeexpectancy) AS avg_lifeexpectancy
FROM country
WHERE continent <> 'Antartica' AND lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY avg_lifeexpectancy DESC;

-- Sum of the population of cities in each state in the USA ordered by state name
SELECT district, SUM(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;


-- The average population of cities in each state in the USA ordered by state name
SELECT district, ROUND(AVG(population), 0)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;

-- SUBQUERIES

-- All the Cities on the region British Islands
SELECT * FROM city
WHERE countrycode IN ('GBR', 'IRL');

SELECT code FROM country
WHERE region = 'British Islands';  -- This query returns:  GBR, IRL the same as the values in our IN above

-- Since the second query returns the data needed in the WHERE clause, the query can be used in the WHERE clause to provide the values
SELECT * FROM city
WHERE countrycode IN (SELECT code FROM country WHERE region = 'British Island');

-- Find the names of cities under a given government leader
SELECT * FROM city
WHERE countrycode IN (SELECT code FROM country WHERE headofstate = 'Elisabeth II');

-- Find the names of cities whose country they belong to has not declared independence yet
SELECT * FROM city
WHERE countrycode IN (SELECT code FROM country WHERE indepyear IS NULL);


-- All the languages spoken by countries on the contitnent of Asia
SELECT * FROM countrylanguage WHERE countrycode IN (SELECT code FROM country WHERE continent = 'Asia');

-- Additional samples
-- You may alias column and table names to be more descriptive
SELECT name AS city_name
FROM city AS cities;

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.
SELECT c.name, co.name
FROM city AS c, country AS co

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name, population
FROM city
WHERE countrycode = 'USA'
ORDER BY name ASC, population DESC;


-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip
SELECT name, population
FROM city
LIMIT 10 OFFSET 10;


-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.
SELECT (name || ' is in the state of ' || district) AS city_state
FROM city
WHERE countrycode = 'USA';

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.
-- Counts the number of rows in the city table
SELECT COUNT(name) AS city_count 
FROM city;

-- Also counts the number of rows in the city table
SELECT COUNT(population) AS city_count 
FROM city;

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.
SELECT SUM(population) AS total_city_population, COUNT(population) AS number_of_cities, AVG(population) AS average_population
FROM city;

-- Gets the MIN population and the MAX population from the city table.
SELECT MIN(population) AS smallest_population, MAX(population) AS largest_population
FROM city;

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
SELECT countrycode MIN(population) AS smallest_population, MAX(population) AS largest_population
FROM city
GROUP BY countrycode;