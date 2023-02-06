/**********************member insert************************/
insert into userinfo(userid,password,name,email) values('guard1','1111','김경호1','guard1@korea.com');
insert into userinfo(userid,password,name,email) values('guard2','2222','김경호2','guard2@korea.com');
insert into userinfo(userid,password,name,email) values('guard3','3333','김경호3','guard3@korea.com');

/**********************categories insert*********************/
insert into categories values(10,'카테테스트');
/**********************product insert************************/
insert into product values(product_p_no_SEQ.nextval,'테스트',10000,'defalut.png','보드테스트용',10);
/**********************cart insert***************************/

/**********************orders insert*************************/

/**********************board insert**************************/
/*
 * groupno : 최상위글과 그글의 답글모두들을 하나의 구룹으로 묶기위한컬럼
 * step    : 같은그룹내에서의 순서를 가지고있는 컬럼
 * depth   : 답글의 깊이를 가지고있는 컬럼
 */


--새글쓰기(최상위글) 
/*
 * groupno : boardno
 * step    : 1
 * depth   : 0
 */
--새글쓰기
insert into board(boardno, title, content, groupno, step, userId, p_no)
values(board_boardno_SEQ.nextval,
        '게시판타이틀'||board_boardno_SEQ.currval,
        '내용'||board_boardno_SEQ.currval,
        board_boardno_SEQ.currval,
        1,
        'guard1',
        2
        );

--답글쓰기

/*현재글의 데이타를 기반으로 작업한다.
    1. boardno : 시퀀스증가
    2. groupno : 현재글의 groupno
    3. step    : 현재글의 step  + 1
    4. depth   : 현재글의 depth + 1
 */
-- update 현재글과 같은그룹번호들중에서현재글의 step보다큰 step을가진 게시물들의 step을 1씩 증가시킨다.
update board set step=step+1 where step > 1 and groupno=30 and p_no=2;
-- insert
insert into board(boardno,title,content,groupno,step,depth, p_no) 
        values(board_boardno_SEQ.nextval,
            '후기답글'||board_boardno_SEQ.currval,
            '내용용'||board_boardno_SEQ.currval,
            30,
            2,
            1,
            2
            );
insert into board(boardno, title, content, groupno, step, userId, p_no)
values (board_boardno_SEQ.nextval);



commit;
desc order_item;


