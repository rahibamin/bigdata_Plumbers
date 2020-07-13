
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

## For employees whose city is Orlando.

## Count the employees from each city.

### Solution

```

```

# Question 3

Write a query in SQL to display the first name, salary, and department name for all employees.

### Solution

```

```

## Who are the employees with the top 5 salary?

## Who has the the hightest salary in each department?
