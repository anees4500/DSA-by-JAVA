# Write your MySQL query statement below


-- SELECT 
--     D.name AS Department,
--     E.name AS Employee,
--     E.salary AS Salary
-- FROM Employee E
-- JOIN Department D 
--     ON D.id = E.departmentId
-- WHERE (E.departmentId, E.salary) IN (
--     SELECT departmentId, MAX(salary)
--     FROM Employee
--     GROUP BY departmentId
-- );

SELECT 
    D.name AS Department,
    E.name AS Employee,
    E.salary AS Salary
FROM (
    SELECT *,
           RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) AS rnk
    FROM Employee
) E
JOIN Department D 
ON E.departmentId = D.id
WHERE rnk = 1;