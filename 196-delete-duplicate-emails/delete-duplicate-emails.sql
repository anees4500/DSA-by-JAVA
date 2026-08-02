# Write your MySQL query statement below
-- delete p1
-- from Person p1 , Person p2
-- where p1.email = p2.email
-- and p1.id>p2.id;

-- delete from Person
-- where id  not in (
--     select MIN(id)
--     from Person 
--     group by email
-- );

DELETE FROM Person
WHERE id NOT IN (
    SELECT id
    FROM (
        SELECT MIN(id) AS id
        FROM Person
        GROUP BY email
    ) AS temp
);