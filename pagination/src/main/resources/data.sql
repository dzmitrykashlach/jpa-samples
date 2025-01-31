CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE OR REPLACE FUNCTION gen_random_string(_min_length INT = 3)
RETURNS VARCHAR
LANGUAGE SQL
AS '
SELECT substring(
md5(random()::TEXT),
0,
_min_length + floor(random() * 10 + 1)::INT
)
';


DO
'BEGIN
FOR index IN 1..100000 LOOP
INSERT INTO person (id,firstname,lastname,age,created_at)
SELECT uuid_generate_v4(),
gen_random_string(),
1234567890,
floor(random() * 80 + 1)::int,
CURRENT_TIMESTAMP;
END LOOP;
END
' LANGUAGE plpgsql;

--DO
--$do$
--BEGIN
-- for running from dbeaver
--END LOOP;
--END
--$do$;
