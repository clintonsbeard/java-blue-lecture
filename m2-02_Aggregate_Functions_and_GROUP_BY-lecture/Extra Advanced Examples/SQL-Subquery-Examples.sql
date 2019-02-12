--
-- show the minimum life expectancy in the country table
-- include the name of the country
--
-- 1. run the subquery to get the min(lifeexpectancy)
-- 2. plug the resultof subquery into the where clause
--
-- it is safer to use IN instead = for a subquery - if subquery returns multiple values the = fails
--
select name, lifeexpectancy
  from country
where lifeexpectancy IN (select min(lifeexpectancy)  -- subquery - a select for a value used in a where clause
                          from country)       
;

--
-- Alternate solution without a subquery
--
select name, lifeexpectancy
  from country
  where lifeexpectancy is not Null
  order by lifeexpectancy asc
  limit 1
  ;
 --
 -- list name and lifeexpectancy for all countries where lifexpectancy is greater than the average lifeexpectency of all countries
 --
 -- 1. determine the average life expectancy
 -- 2. find all countries whose life expecancy if GT what you found in 1
 --
select name, lifeexpectancy
  from country
 where lifeexpectancy > (select avg(lifeexpectancy) 
                          from country)
   and continent = 'Europe'
 order by 2 desc
  ;
  