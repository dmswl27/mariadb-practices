-- 집계쿼리 : select 절에 그룹함수가 적용된 경우,
select avg(salary) from salaries;
-- select 절에 그룹함수가 있는경우, 어떤 컬럼도 select 절에 올수 없다.
-- emp_no는 아무 의미가 없다.
-- 오류!!
select emp_no, avg(salary) from salaries;
-- query 실행 순서 숙지
-- (1) from : 점근 테이블 확인
-- (2) where : 조건에 맞는 row 선택 -> 임시 테이블
-- (3) 집계
-- (4) projection
select avg(salary) from salaries where emp_no= '10060';

-- group by 에 참여하고 있는 컬럼은 projection 가능(select 절에 올 수 있다)
 select emp_no, avg(salary)
  from salaries 
group by emp_no;

-- having 
-- 집계 결과 임시 테이블에서 로우를 선택해야 하는 경우
-- 이미 where 절은 실행 되었기 때문에 having절에서 조건을 주어야 한다.
 select emp_no, avg(salary)
  from salaries 
group by emp_no
 having avg(salary) > 60000;
 
 -- order by
  select emp_no, avg(salary)
  from salaries 
group by emp_no
 having avg(salary) > 60000
order by avg(salary) asc;

 select emp_no, max(salary) , min(salary) 
  from salaries
 where emp_no = '10060';