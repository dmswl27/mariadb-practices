-- 테이블간 조인(JOIN) SQL 문제입니다.

-- 문제 1. 
-- 현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력 하시오.
  select a.emp_no, b.first_name, a.salary 
    from salaries a , employees b 
  where a.emp_no = b.emp_no 
    and a.to_date = '9999-01-01' 
order by salary desc;

-- 문제2.
-- 전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력하세요.
    select concat(b.first_name , ' ', b.last_name) , a.emp_no, a.title 
      from titles a , employees b 
  where a.emp_no = b.emp_no 
    and a.to_date = '9999-01-01' 
order by concat(b.first_name , ' ', b.last_name) asc;

-- 문제3.
-- 전체 사원의 사번, 이름, 현재 부서를 이름 순서로 출력하세요..
    select concat(c.first_name , ' ', c.last_name) , a.emp_no, b.dept_name
      from dept_emp a , departments b, employees c , titles d
  where a.emp_no = c.emp_no 
	and a.dept_no =b.dept_no
    and a.emp_no = d.emp_no
    and d.to_date = '9999-01-01'
order by concat(c.first_name , ' ', c.last_name) asc;

-- 문제4.
-- 전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력합니다.

  select concat(c.first_name , ' ', c.last_name) , a.emp_no, b.dept_name , d.title , e.salary
      from dept_emp a , departments b, employees c , titles d , salaries e
  where a.emp_no = c.emp_no
	and a.dept_no =b.dept_no
    and a.emp_no = d.emp_no
    and a.emp_no = e.emp_no
    and d.to_date = '9999-01-01'
    and a.to_date = '9999-01-01'
    and e.to_date = '9999-01-01'
order by concat(c.first_name , ' ', c.last_name) asc;

-- 문제5.
-- ‘Technique Leader’의 직책으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하세요. (현재 ‘Technique Leader’의 직책(으로 근무하는 사원은 고려하지 않습니다.) 이름은 first_name과 last_name을 합쳐 출력 합니다.
select concat(b.first_name , ' ', b.last_name), a.emp_no 
  from titles a, employees b 
where a.emp_no = b.emp_no 
  and title ='Technique Leader';
  
-- 문제6.
-- 직원 이름(last_name) 중에서 S(대문자)로 시작하는 직원들의 이름, 부서명, 직책을 조회하세요.
  select concat(c.first_name , ' ', c.last_name) ,b.dept_name , d.title 
      from dept_emp a , departments b, employees c , titles d 
  where c.last_name like '%S' 
	and a.emp_no = c.emp_no
	and a.dept_no =b.dept_no
    and a.emp_no = d.emp_no;

-- 문제7.
-- 현재, 직책이 Engineer인 사원 중에서 현재 급여가 40000 이상인 사원을 급여가 큰 순서대로 출력하세요.
  select a.emp_no, b.salary
    from titles a , salaries b 
  where a.emp_no = b.emp_no 
    and a.to_date = '9999-01-01' 
    and b.to_date = '9999-01-01'
    and a.title = 'Engineer'
    and b.salary > 40000
order by salary desc;

-- 문제8.
-- 현재 급여가 50000이 넘는 직책을 직책, 평균 급여로 평균 급여가 큰 순서대로 출력하시오
 select a.title, avg(b.salary) as avg_salary
    from titles a , salaries b 
  where a.emp_no = b.emp_no 
    and a.to_date = '9999-01-01' 
    and b.to_date = '9999-01-01'
    and b.salary > 50000
group by a.title 
having avg_salary desc;


       
-- 문제9.
-- 현재, 부서별 평균 연봉을 연봉이 큰 부서 순서대로 출력하세요.
select a.dept_no, avg(b.salary) as avg_salary
    from dept_emp a , salaries b 
  where a.emp_no = b.emp_no 
    and a.to_date = '9999-01-01' 
    and b.to_date = '9999-01-01'
group by b.salary desc;

-- 문제10.
-- 현재, 직책별 평균 연봉을 연봉이 큰 직책 순서대로 출력하세요.
select a.title, avg(b.salary) as avg_salary
    from titles a , salaries b 
  where a.emp_no = b.emp_no 
    and a.to_date = '9999-01-01' 
    and b.to_date = '9999-01-01'
group by a.title desc;