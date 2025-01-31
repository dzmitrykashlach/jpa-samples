CREATE INDEX idx_post_timestamp ON posts (timestamp DESC);

explain analyze 
SELECT id
FROM posts
ORDER BY posts."timestamp" DESC
FETCH FIRST 5000 ROWS only;

explain analyze 
SELECT id
FROM posts
ORDER BY posts."timestamp" DESC
OFFSET 1000000 ROWS
FETCH NEXT 5000 ROWS only;