-- Some common Postgres SQL string function examples
--
-- This code assumes usage of the world database, country table
--
-- ||                                           -- string concatenation operator
-- lower(string)                                -- returns string in lower case
-- upper(string)                                -- returns string in upper case
-- length(string)                               -- returns length of string
-- substring(string from start-pos for length)  -- returns substring of string as specified
-- left(string, n)                              -- returns first n chars in string
-- right(string, n)                             -- returns last n chars in string
-- repeat(string, n)                            -- returns string repeated n times
-- reverse(string)                              -- returns chars in string in reverse order
-- replace(string,from-char,to-char)            -- returns string with all occurances of from-char replaced by to-char
-- ltrim(string)                                -- returns string with leading spaces removed
-- rtrim(string)                                -- returns string with trailing spaces removed
-- ltrim(string,'char')                         -- returns string with leading char removed
-- rtrim(string,'char')                         -- returns string with trailing char removed
--
-- other string functions and variations of these functions are available
-- please refer to the postgres documention for more information (Google 'postgres string functions')
--
select name                                 -- country name
      ,lower(name)                          -- convert country name to lower case
      ,upper(name)                          -- convert country name to upper case
      ,length(name)                         -- return length of name
      ,substring(name from 3 for 2)         -- substring(name from third char for 2 chars)
      ,left(name,5) as first_5_char         -- left 5 chars of name
      ,right(name,5) as last_5_char         -- last 5 chars of name
      ,repeat('-',10)                       -- repeat('-',10 times)
      ,repeat(left(name,3)||' ',5)          -- repeat 1st 3 chars of name followed by a space 5 times
      ,reverse(name)                        -- reverse the characters in name
      ,replace(name,'la','$$')              -- replace and 'la' in name with '$$'
      ,'Hello ' || ltrim('    Frank        ') || ' Ginzo' as ltrim  -- trim leftmost/leading spaces from string
      ,'Hello ' || rtrim('    Frank        ') || ' Ginzo' as rtrim  -- trim rightmost/trailing spaces from string
      ,'Hello ' || trim(both ' ' from '    Frank        ') || ' Ginzo' as trim_both -- trim both leading and trailing spaces from string
      ,ltrim('$19.95','-$') as no_dash_$    -- remove leading - or $ from string
      ,ltrim('-$19.95','-$') as no_dash_$   -- remove leading - or $ from string
      ,ltrim('$-19.95','-$') as no_dash_$   -- remove leading - or $ from string
      
from country
limit 10
;