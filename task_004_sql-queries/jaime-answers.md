
# Query 1.

## For all employees.
Write a query in SQL to display the first name, last name, department id, and department name for each employee.

### Solution

Use a LEFT JOIN to extend the search domain on multiple tables.


`select Employee.first_name, Employee.last_name, HR.department_id, department_name from Employee left join HR on id;`

```
mysql> select Employee.first_name, Employee.last_name, HR.department_id, HR.department_name from Employee left join HR on id;
+------------+-----------+---------------+-----------------+
| first_name | last_name | department_id | department_name |
+------------+-----------+---------------+-----------------+
| such       | as        | root          | Root            |
| skippy     | von lou   | root          | Root            |
| such       | as        | drone         | Worker          |
| skippy     | von lou   | drone         | Worker          |
| such       | as        | drone         | Worker          |
| skippy     | von lou   | drone         | Worker          |
| bill       | charge    | NULL          | NULL            |
+------------+-----------+---------------+-----------------+
7 rows in set (0.00 sec)
```

The query is `select Emplloyee.first_name, Employee.last_name, HR.department_id, HR.department_name from Employee left join HR on id;`.

## For a specified subset of employees.
Write a query in SQL to display all employees with a first name starting with an `A`.

### Solution

The LIKE matches a pattern in strings. `LIKE 'A%'` matches strings starting with an `A`.

```
mysql> select Employee.first_name from Employee where Employee.first_name like 'b%';
+------------+
| first_name |
+------------+
| bill       |
+------------+
1 row in set (0.00 sec)
```

The query is `select Employee.first_name from Employee where Employee.first_name like 'A%';`.

# Question 2

Write a query in SQL to display the first and last name, department, and city for each employee.

### Solution

```
mysql> select Employee.first_name, Employee.last_name, HR.department_id, Employee.city from Employee left join HR on id;
+------------+-----------+---------------+----------------------+
| first_name | last_name | department_id | city                 |
+------------+-----------+---------------+----------------------+
| such       | as        | root          | district of columbia |
| skippy     | von lou   | root          | atlanta              |
| such       | as        | drone         | district of columbia |
| skippy     | von lou   | drone         | atlanta              |
| such       | as        | drone         | district of columbia |
| skippy     | von lou   | drone         | atlanta              |
| bill       | charge    | NULL          | new york             |
+------------+-----------+---------------+----------------------+
7 rows in set (0.00 sec)
```

The query is `select Employee.first_name, Employee.last_name, HR.department_id, Employee.city from Employee left join HR on id;`

## For employess whose city is Atlanta.

### Solution

```
mysql> select Employee.first_name, Employee.last_name, HR.department_id, Employee.city from Employee left join HR on id where Employee.city like 'atlanta';
+------------+-----------+---------------+---------+
| first_name | last_name | department_id | city    |
+------------+-----------+---------------+---------+
| skippy     | von lou   | root          | atlanta |
| skippy     | von lou   | drone         | atlanta |
| skippy     | von lou   | drone         | atlanta |
+------------+-----------+---------------+---------+
3 rows in set (0.04 sec)
```

The query is `select Employee.first_name, Employee.last_name, HR.department_id, Employee.city from Employee left join HR on id where Employee.city like 'atlanta';`.

## For employees whose city is New York.

### Solution

```
mysql> select Employee.first_name, Employee.last_name, HR.department_id, Employee.city from Employee left join HR on id where Employee.city like 'New York';
+------------+-----------+---------------+----------+
| first_name | last_name | department_id | city     |
+------------+-----------+---------------+----------+
| bill       | charge    | NULL          | new york |
+------------+-----------+---------------+----------+
1 row in set (0.00 sec)
```

The query is `select Employee.first_name, Employee.last_name, HR.department_id, Employee.city from Employee left join HR on id where Employee.city like 'New York';`.

## For employees whose city is Orlando.

The query is `select Employee.first_name, Employee.last_name, HR.department_id, Employee.city from Employee left join HR on id where Employee.city like 'Orlando';`.

## Count the employees from each city.

For every city, count the number of records in Employee.

### Solution

The Employee table shows two employees in Atlanta.

```
mysql> select * from Employee;
+----+------------+-----------+-------------+----------------------+-------+-----------------+--------+
| id | first_name | last_name | address     | city                 | zip   | phone           | email  |
+----+------------+-----------+-------------+----------------------+-------+-----------------+--------+
|  0 | bill       | charge    | 1 main st   | new york             | 20000 | +1.111.222.3344 | e@mail |
|  1 | such       | as        | 2 thirds ct | district of columbia | 22000 | +1.202.222.3334 | d@mail |
|  3 | skippy     | von lou   | 4 four pl   | atlanta              | 80000 | +1.222.111.1112 | g@mail |
|  4 | Adam       | Evan      | 55 main st  | atlanta              | 80001 | +1.222.333.2211 | f@mail |
+----+------------+-----------+-------------+----------------------+-------+-----------------+--------+
4 rows in set (0.00 sec)
```

The solution shows that there are two employees in Atlanta.

```
mysql> select Employee.city, count(*) as `Employees in city` from Employee group by Employee.city;
+----------------------+-------------------+
| city                 | Employees in city |
+----------------------+-------------------+
| atlanta              |                 2 |
| district of columbia |                 1 |
| new york             |                 1 |
+----------------------+-------------------+
3 rows in set (0.00 sec)
```

The query is `select Employee.city, count(*) as `Employees in city` from Employee group by Employee.city;`.

# Question 3

Write a query in SQL to display the first name, salary, and department name for all employees.

### Solution

```
mysql> select Employee.first_name, HR.salary, HR.department_name from Employee left join HR on Employee.id = HR.emp_id;
+------------+--------+-----------------+
| first_name | salary | department_name |
+------------+--------+-----------------+
| such       | 99.999 | Root            |
| bill       | 10.000 | Worker          |
| skippy     | 99.999 | Worker          |
| Adam       | 22.000 | Base            |
+------------+--------+-----------------+
4 rows in set (0.00 sec)
```
The query is `select Employee.first_name, HR.salary, HR.department_name from Employee left join HR on Employee.id = HR.emp_id;`.

## Who are the employees with the top 5 salary?

### Solution

The query must consider the salary in an ordered list, then report the user's name associated with the top 5 highest salaries.

```
mysql> select T.emp_id, Employee.first_name, Employee.last_name from (select HR.emp_id from HR order by HR.salary desc limit 5) as T left join Employee on T.emp_id = Employee.id;
+--------+------------+-----------+
| emp_id | first_name | last_name |
+--------+------------+-----------+
|      1 | such       | as        |
|      3 | skippy     | von lou   |
|      6 | Audry      | Smith     |
|      5 | Sam        | Evans     |
|      4 | Adam       | Evan      |
+--------+------------+-----------+
5 rows in set (0.00 sec)
```

The query is `select T.emp_id, Employee.first_name, Employee.last_name from (select HR.emp_id from HR order by HR.salary desc limit 5) as T left join Employee on T.emp_id = Employee.id;`.

## Who has the the hightest salary in each department?

TODO: obtaining circular reference of the query.
> mysql> select Employee.first_name, T.department_id from (select HR.emp_id, HR.department_id from HR order by HR.department_id, HR.salary desc) as T left join Employee on Employee.id = T.emp_id;
