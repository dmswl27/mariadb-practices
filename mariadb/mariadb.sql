-- 테이블 삭제하기
drop table pet;

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