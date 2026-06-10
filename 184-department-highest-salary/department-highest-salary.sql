# Write your MySQL query statement below
select name as Department , name2 as Employee, Salary
from  (
    select
         Department.name as name ,
         Employee.name as name2 , 
         Salary,
         dense_rank() over (partition by departmentId order by salary desc) as rn
         from Employee
         join Department 
         on Employee.departmentId = Department.id
) t
where rn =1;
