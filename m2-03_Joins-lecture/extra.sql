-- Display all the films and their language
SELECT f.title, l.name
FROM film f
INNER JOIN language l ON f.language_id = l.language_id

-- Display all the films and in English
SELECT f.title, l.name
FROM film f
INNER JOIN language l ON f.language_id = l.language_id
WHERE l.name = 'English'

-- Display all the films with their category
SELECT f.title, c.name
FROM film f
INNER JOIN film_category fc ON f.film_id = fc.film_id
INNER JOIN category c ON fc.category_id = c.category_id

-- Display all the films with a category of Horror
SELECT f.title, c.name
FROM film f
INNER JOIN film_category fc ON f.film_id = fc.film_id
INNER JOIN category c ON fc.category_id = c.category_id
WHERE c.name = 'Horror'

-- Display all the films with a category of Horror and title that begins with the letter F
SELECT f.title, c.name
FROM film f
INNER JOIN film_category fc ON f.film_id = fc.film_id
INNER JOIN category c ON fc.category_id = c.category_id
WHERE c.name = 'Horror'
AND f.title LIKE 'F%'

-- Who acted in what together?
SELECT f.title, a1.first_name || ' ' || a1.last_name, a2.first_name || ' ' || a2.last_name
FROM film f
JOIN film_actor fa1 ON f.film_id = fa1.film_id
JOIN film_actor fa2 ON f.film_id = fa2.film_id AND fa1.actor_id <> fa2.actor_id
JOIN actor a1 ON fa1.actor_id = a1.actor_id
JOIN actor a2 ON fa2.actor_id = a2.actor_id

-- How many times have two actors appeared together?
SELECT COUNT(*) AS num_of_films, a1.actor_id, a1.first_name || ' ' || a1.last_name, a2.actor_id, a2.first_name || ' ' || a2.last_name
FROM film f
JOIN film_actor fa1 ON f.film_id = fa1.film_id
JOIN film_actor fa2 ON f.film_id = fa2.film_id AND fa1.actor_id <> fa2.actor_id
JOIN actor a1 ON fa1.actor_id = a1.actor_id
JOIN actor a2 ON fa2.actor_id = a2.actor_id
GROUP BY a1.actor_id, a2.actor_id
ORDER BY num_of_films DESC

-- What movies did the two most often acted together actors appear in together?
SELECT film.title
FROM film
JOIN film_actor af1 ON film.film_id = af1.film_id
JOIN film_actor af2 ON film.film_id = af2.film_id
WHERE af1.actor_id = 27
AND af2.actor_id = 60