update pet set daeth = '2000-01-01' where name = 'bowser';
-- 테이블 삭제하기
drop table pet;
select * from pet;

-- 테이블 만들기
create table pet(
	name varchar(20),
    owner varchar(20),
    species varchar(20),
    gender char(1),
    birth date,
    death date
);
-- 스키마 확인
desc pet;

-- 조회
select name, owner, species,gender,brith,death from pet;

-- 데이터 넣기(생성, create)
insert 
	into pet
values('성탄이', '한은지', 'dog', 'm', '2021-05-15', null);

delete from pet where name='성탄이';

-- 조회 연습1: where
-- 1990년 이후에 태어난 아이들은?
select * from pet where birth > '1990-12-31';

-- null 다루기1: 살아있는 애들은?
select * from pet where death is null;

-- null 다루기1: 죽은 애들은?
select * from pet where death is not null;

-- Gwen과 함께 사는 아이들은?
select * from pet where owner = 'gwen';

-- 조회 연습2: order by
-- 나이가 어린순으로 정렬하고 생일이 같으면 다시 정렬
select * from pet order by birth desc, name asc;

-- like 검색(매텀매칭): 이름이 b로 시작하는 사람?
select * from pet where name like 'b%';

-- like 검색(매텀매칭): 이름이 b로 시작하는 아이들중 이름이 6자인?
select * from pet where name like 'b_____';

-- 집계(통계) 함수 
select count(*) from pet ;
