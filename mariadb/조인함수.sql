-- inner join --

-- 예제

select a.emp_no, a.first_name 
  from employees a, titles b 
 where a.emp_no = b.emp_no; -- join condition
 
 -- 예제 2. 여성 엔지니어만 출력하세요
 select a.emp_no, a.first_name , b.title
  from employees a, titles b 
 where a.emp_no = b.emp_no  -- join condition
   and a.gender ='F'        -- row-select cond1
   and b.title = 'engiaeer';-- row-select cond2

--    
-- 예제 3. ANSI / ISO SQL1999 JOIN 표준 문법
--
-- 1. natural join
-- 두 테이블네 공통 컬럼이 있으면 별다른 조건없이 묵시적 조인됨
-- 쓸일 없음
	select a.first_name, b.title
	  from employees a
natural join titles b ;
--  on a.emp_no = b.emp_no;  생략
-- ---------------------------------------
-- natural join 을 사용하지 않는 이유
select count(*)
	  from salaries a
natural join titles b 
where a.to_date = '9999-01-01';

select count(*)
	  from salaries a 
join titles b on a.emp_no = b.emp_no;
-- -----------------------------------------------------

-- 2. join ~ using 
select a.first_name, b.title
  from employees a
 join titles b using (emp_no) ;
 
 -- 3. join ~ on
 select a.first_name, b.title
  from employees a
 join titles b on a.emp_no = b.emp_no ;
 
 -- outer join --
-- insert into dept values(null, '총무');
-- insert into dept values(null, '개발');
-- insert into dept values(null, '영업');
-- insert into dept values(null, '기획');
select *from dept;
insert into emp values(null,'둘리',1);
insert into emp values(null,'마이톨',2);
insert into emp values(null,'또치',3);
insert into emp values(null,'길동',null);
select* from emp;

  select a.name, b.name 
    from emp a 
left join dept b 
   on a.dept_no = b.no ;
   
   select a.name, ifnull(b.name, '없음') as '부서' 
    from emp a 
right join dept b 
   on a.dept_no = b.no ;
   
   -- 실습문제 1
   -- 현재 회사 살황을 반영한 직원별 근무부서를
   -- 사번, 직원 전체 이름, 근무 부서 형태로 출력해 보세요
select a.emp_no, a.first_name, c.dept_name from employees a, departments c, dept_emp b 
where a.emp_no = b.emp_no
and b.dept_no = c.dept_no
and b.to_date = '9999-01-01';

-- 실습문제 2
-- 현재 회사에서 지급되고 있는 급여체계를 반영한 결과를 출력하시오
-- 사번 이름 연봉 
select a.emp_no, a.first_name, b.salary
from employees a, salaries b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01';