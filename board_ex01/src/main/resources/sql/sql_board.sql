
drop table board_tbl;
create table board_tbl(
bno int auto_increment primary key,
title varchar(300) not null,
contents text not null,
writer varchar(50) not null,
regDate timestamp default current_timestamp,
updateDate timestamp default current_timestamp

);
select * from board_tbl;

insert into board_tbl(title, contents, writer) value('게시물 제목입니다', '배가 고프네', '옥승훈');
insert into board_tbl(title, contents, writer) value('게시물 제목입니다2', '배가 고프네2', '옥승훈2');
insert into board_tbl(title, contents, writer) value('게시물 제목입니다3', '배가 고프네3', '옥승훈3');
insert into board_tbl(title, contents, writer) value('게시물 제목입니다4', '배가 고프네4', '옥승훈4');
