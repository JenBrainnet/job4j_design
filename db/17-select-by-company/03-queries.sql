-- People not working in company with id = 5 and their company names
SELECT p.name person_name, c.name company_name, c.id company_id
FROM people p
JOIN company c
ON p.company_id = c.id
WHERE p.company_id != 5;

-- Companies with maximum number of people and count
SELECT c.name company_name, count(p.id) person_count
FROM people p
JOIN companies c
ON p.company_id = c.id
GROUP BY c.id, c.name
HAVING count(p.id) = (
		SELECT MAX(cnt)
		FROM (
			SELECT count(*) cnt
			FROM people
			GROUP BY company_id
		));