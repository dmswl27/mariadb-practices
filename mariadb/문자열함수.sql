-- 함수 : 문자열 함수

-- upper
select upper('busan'), upper('busan'),upper('Douzone');
select upper(first_name) from employees;

-- lower
select lower('busan'), lower('busan'),lower('Douzone');
select lower(first_name) from employees;

-- substring(문장, index, length)
select substring('Happy Day',3,2);

-- 1989년에 입사한 사원들의 이름, 입사일 출력
select first_name, hire_date
from employees
where '1989' = substring(hire_date, 1, 4);

-- lpad(오른쪽 정렬), rpad(왼쪽정렬)
select lpad('1234', 10, '-');
select rpad('1234', 10, '-');

-- 예제) 직원들의 월급을 오른쪽 정렬(빈공간은 *)
select emp_no ,lpad(salary, 10, '*') as 'salary' from salaries where from_date like '2001-%';

-- trim, ltrim, rtrim
select concat('---', rtrim('  hello   '), '---') ltrim,
	   concat('---', ltrim('  hello   '), '---') rtrim,
       concat('---',trim(both ' ' from '   hello   '), '----' ) trim;


 



