-- books with minimum number of orders
CREATE VIEW show_least_popular_books
AS
SELECT b.name AS book, a.name AS author, COUNT(o.id) AS orders_count
FROM books b
JOIN authors a ON b.author_id = a.id
LEFT JOIN orders o ON b.id = o.book_id
GROUP BY b.name, a.name
HAVING COUNT(o.id) = (
	SELECT MIN(cnt)
	FROM (
		SELECT COUNT(o2.id) AS cnt
		FROM books b2
		LEFT JOIN orders o2 ON b2.id = o2.book_id
		GROUP BY b2.id
	)
);

-- check view
SELECT * FROM show_least_popular_books;