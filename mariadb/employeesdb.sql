-- select 연슴
select * from departments;

select dept_no, dept_name from departments;

-- concat, alias(as, 생략 가능)
SELECT first_name AS 이름,
         gender AS 성별, 
         hire_date AS 입사일
    FROM employees;

select concat(first_name,' ', last-name),gender, hire_date from employees;
select concat(first_name, last-name)as 이름,gender as 성별, hire_date as 입사일 from employees;

-- distict 
-- 예제 1:  titles 테이블에서 모든 직급의 이름 출력
select titles from titles;
-- 예제 2: titles 테이블에서 직급은 어떤 것들이 있는지 직급이름을 한 번씩만 출력
SELECT DISTINCT title FROM titles;

-- 예제 : employees 테이블에서 1991년 이전에 입사한 직원의 이름,성별, 입사일을 출력
select first_name, gender, hire_date from employees where hire_date < '1991-01-01';
SELECT concat( first_name, ' ', last_name ) AS 이름,
         gender AS 성별, 
         hire_date AS 입사일
    FROM employees
   WHERE hire_date < '1991-01-01' ;

-- 논리연산자

SELECT first_name, hire_date
    FROM employees
   WHERE hire_date < '1989-01-01'
	and gender = 'f';
    
-- 예제 : dept_emp 테이블에서 부서 번호가 d005나 d009에 속한 사원의 사번, 부서번호 출력
 select emp_no, dept_no 
  from dept_emp 
 where dept_no in('d005','d009');   
 
 -- 예제 : 1989년에 입사한 직원의 이름, 입사일을 출력  
 select * from employees
	where hire_date between '1989-12-31' and '1990-01-01';

 select first_name, hire_date from employees
	where hire_date like '1989-%';
    
-- ORDER BY 절
select first_name, gender from employees
	where gender = 'm'
  order by hire_date asc;

-- 예제2 : 2001년 월급을 사번, 월급순으로 월급만 출력
select emp_date, salary 
	from salaries
order by emp_no asc, salary asc;







 



