CREATE MATERIALIZED VIEW books_stats_mv AS
SELECT
    category,
    COUNT(*) AS total_books,
    SUM(available_copies) AS total_available_copies,
    SUM(CASE WHEN state = 'BAD' THEN 1 ELSE 0 END) AS bad_condition_books
FROM books
GROUP BY category;

CREATE UNIQUE INDEX idx_books_stats_mv_category
    ON books_stats_mv(category);