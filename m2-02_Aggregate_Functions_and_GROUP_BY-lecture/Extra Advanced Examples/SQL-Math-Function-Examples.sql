-- Examples of a few Postgres SQL mathematical functions
--
-- The following queries utilize the "world" database.
--
-- round(value, #-dec-places)  - round a numeric value to the number of decimal places given
-- trunc(value, #-dec-places)  - truncate a numeric value to the number of decimal places given
--
-- ceil(value)  - return the next numerically higher integer value to value given
-- floor(value) - return the next numerically lower integer value to the value given
--
-- abs(value)   - return the the absolute value of the value given
--

-- The per capita GNP (i.e. GNP mulitplied by 1000000 then divided by population) of all countries in the 
-- world sorted from highest to lowest. Recall: GNP is expressed in units of one million US Dollars 
-- (highest per captia GNP in world: 37459.26)

	SELECT
	             (gnp * 1000000) / population           AS per_capita_gnp
	     , round((gnp * 1000000) / population,2)        AS rounded_up
	     , trunc((gnp * 1000000) / population,2)        AS truncated
	     ,  ceil((gnp * 1000000) / population)          AS next_higher_int
	     , floor((gnp * 1000000) / population)          AS next_lower_int	        
	     ,      ((gnp * 1000000) / population)*-1       AS neg_per_cap_gnp
	     ,  ceil((gnp * 1000000) / population)*-1       AS next_higher_neg_int
	     , floor((gnp * 1000000) / population)*-1       AS next_lower_neg_int
	     ,   abs(ceil((gnp * 1000000) / population)*-1) AS abs_of_next_higher_neg_int
	     	        
	  FROM country 
	 WHERE population != 0 
	ORDER BY per_capita_gnp DESC;
--
-- random() generates a psuedo random value in the range 0.0 <= x < 1.0
-- 
-- The characteristics of the values returned by random() depend on the system implementation. 
-- It is not suitable for cryptographic applications
-- 
-- multiple by a power of 10 and add one to get the range desired
--
-- the value generated is type float - cast to an integer if desired (use ::integer)
--
select random() as random_num
      ,trunc(random() * 10)+1            as ran_0_10       -- random value between 0 and 10
          ,((random() * 10)+1)::integer  as ran_int_0_10   -- random value between 0 and 10 cast value to integer
      ,trunc(random() * 100)+1           as ran_0_100      -- random value between 0 and 100
      ,trunc(random() * 1000)+1          as ran_0_1000     -- random value between 0 and 1000
      ,trunc(random() * 10000)+1         as ran_0_10000    -- random value between 0 and 10000
 ;
      
      