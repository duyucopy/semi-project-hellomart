
/**********************member insert************************/
insert into userinfo(userid,password,name,email) values('guard1','1111','김경호1','guard1@korea.com');
insert into userinfo(userid,password,name,email) values('guard2','2222','김경호2','guard2@korea.com');
insert into userinfo(userid,password,name,email) values('guard3','3333','김경호3','guard3@korea.com');

/**********************categories insert*********************/
insert into categories values(1,'TV/냉장고/세탁기');
insert into categories values(2,'스마트폰/컴퓨터/노트북');
insert into categories values(3,'가구');

/**********************product insert************************/
--제품번호 이름 가격 사진 제품상세
insert into product values(product_p_no_SEQ.nextval,'LG전자 스텐드TV',990000,'defalut.png','자유롭게 이동하며 필요할때 내 곁에 두는 스크린',1);
insert into product values(product_p_no_SEQ.nextval,'삼성전자 TV',980000,'defalut.png','현실에서 보는 듯한 UHD 모니터',1);
insert into product values(product_p_no_SEQ.nextval,'삼성전자 양문형 냉장고',1430000,'defalut.png','수납은 넉넉하게,공간은 슬림하게',1);
insert into product values(product_p_no_SEQ.nextval,'LG전자 오브제컬렉션 노크온',1700000,'defalut.png','어디에나 자연스럽게 아름답게',1);
insert into product values(product_p_no_SEQ.nextval,'LG전자 일반 세탁기',395000,'defalut.png','일반 통돌이 세탁기',1);
insert into product values(product_p_no_SEQ.nextval,'삼성전자 드럼 세탁기',889000,'defalut.png','더 편히하고 위생적인 관리',1);
insert into product values(product_p_no_SEQ.nextval,'아이폰 14',1598000,'defalut.png','갬성있고 간지나는 디자인',2);
insert into product values(product_p_no_SEQ.nextval,'갤럭시 S22',889900,'defalut.png','편하고 삼성페이가능',2);
insert into product values(product_p_no_SEQ.nextval,'프리플로우 컴퓨터 본체',1109000,'defalut.png','그래픽 높은 게임 다돌아감',2);
insert into product values(product_p_no_SEQ.nextval,'삼보컴퓨터',50000,'defalut.png','지뢰찾기 돌아감',2);
insert into product values(product_p_no_SEQ.nextval,'삼성전자 갤럭시 북3',3600000,'defalut.png','초슬림 초경량 노트북',2);
insert into product values(product_p_no_SEQ.nextval,'에플 맥북에어 ',2124000,'defalut.png','초갬성 초슬림 노트북',2);
insert into product values(product_p_no_SEQ.nextval,'에이스침대',1258280,'defalut.png','편한침대',3);
insert into product values(product_p_no_SEQ.nextval,'일룸 책상세트',519000,'defalut.png','책상의자세트',3);
insert into product values(product_p_no_SEQ.nextval,'리바트 행거',95000,'defalut.png','어린이 옷걸이 행거',3);
insert into product values(product_p_no_SEQ.nextval,'일룸 로이모노 책상서랍',149000,'defalut.png','예쁜색상서랍',3);
insert into product values(product_p_no_SEQ.nextval,'필립스 스탠드 조명',119000,'defalut.png','책상 스텐드 조명',3);
insert into product values(product_p_no_SEQ.nextval,'누하스 안마의자',2069000,'defalut.png','안마 해주는 의자',3);

/**********************cart insert***************************/
insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_SEQ.nextval,'guard1',2,1);
insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_SEQ.nextval,'guard2',1,2);
insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_SEQ.nextval,'guard3',3,1);

insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_SEQ.nextval,'guard1',10,1);
insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_SEQ.nextval,'guard2',11,1);
insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_SEQ.nextval,'guard3',12,1);

/**********************orders insert*************************/
insert into orders(o_no, o_date, o_status, o_option, o_price, userid) values (orders_o_no_SEQ.nextval, sysdate, '배송 중', '문 앞에 놔주세요', 990000, 'guard1');
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval, 1, orders_o_no_SEQ.currval, 1);
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval, 1, orders_o_no_SEQ.currval, 2);
/**********************board insert**************************/

-- board.test  -> BoardDataInsertMain 실행

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
/*insert into board(boardno, title, content, groupno, step, userId, p_no)
values(board_boardno_SEQ.nextval,
        '게시판타이틀'||board_boardno_SEQ.currval,
        '내용'||board_boardno_SEQ.currval,
        board_boardno_SEQ.currval,
        1,
        'guard1',
        2
        );
*/

commit;
desc order_item;


