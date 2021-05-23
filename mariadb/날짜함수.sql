-- 함수 : 날짜 함수

-- CURDATE(), CURRENT_DATE
select CURDATE(), CURRENT_DATE;
select CURDATE(), CURRENT_TIME;

select now(), sysdate();
select now(), sleep(2), now();
select sysdate(), sleep(2), sysdate();

-- dare_format(date, format)
select date_format(now(), '%Y년 %m월 %d일 %h시 %i분 %s초');

-- period_diff
-- YYMM, YYYYMM
-- 예) 근무 개월 수를 출력
select first_name ,period_diff(date_format(curdate(), '%Y%M'), date_format(hire_date,'%Y%m'))
 from employees;
 
 -- date_add(adddate), date(subdate)
 -- 날짜 date에 type(day, month, year) 형식으로 expr값을 더하거나 뺀다.
 -- 각 사원들의 근무 년 수가 5년이 되는 날은 언제 인가요?
 
 select first_name, hire_date ,date_add(hire_date, interval 5 year)
 from employees;
 
 -- cast
 select cast('2021-05-07' as date);
 select cast('1123' as int) + 10;
 
 -- mysql type 
 -- VARCHAR, CHAR, text
 -- signed(unsigned) int(integer), medium int, big int, int(11)
 -- float, dlouble
 -- time, date, datetime
 -- lob(large OBject) : CLOB, BLOB
 select now(), cast(now() as date);
  select cast(1-2 as unsigned);
 select cast(cast(1-2 as unsigned) as signed);
 
 
 
 
 