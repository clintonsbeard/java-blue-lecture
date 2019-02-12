-- show today's date
select current_date as today
;   

-- show today's date in mm/dd/yyyy format - to_char() to format date
select to_char(current_date, 'mm/dd/yyyy') as today
;
-- how many days until Christmas this year - subtract two dates to get duration in days
select '12/25/2019' - current_date as day_until_Christmas
;
-- be aware of result when calculating days between dates() - date() 
select  date('12/31/2019') - date('12/01/2019')  as days_in_December
;
-- add/subtract intervals to dates
select to_char((current_date + interval '5 days'), 'mm/dd/yyyy')as five_days_from_now 
     , to_char((current_date + interval '1 day'),  'mm/dd/yyyy')as one_month_from_now
     , to_char((current_date - interval '1 day'),  'mm/dd/yyyy')as yesterdays_date
     , current_date + interval '2 years' + interval '1 month'   as two_years_and_1_month_from_now
;
--SQL date arithment knows how long months are - date() produces timestamp yyyy-dd-mm hh:mm:ss
select date('10/30/2019') + interval '1 day' as month_w_31_days
      ,date('11/30/2019') + interval '1 day' as month_w_30_days
;
-- SQL date atrithmetic knows about leap years
select date('02/27/2019') + interval '2 days' as non_leap_year
     , date('02/27/2020') + interval '2 days' as leap_year
;
