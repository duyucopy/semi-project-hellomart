/**********************member insert************************/
insert into userinfo(userid,password,name,email) values('guard1','1111','김경호1','guard1@korea.com');
insert into userinfo(userid,password,name,email) values('guard2','2222','김경호2','guard2@korea.com');
insert into userinfo(userid,password,name,email) values('guard3','3333','김경호3','guard3@korea.com');

/**********************categories insert*********************/
insert into categories values(1,'TV/냉장고/세탁기');
insert into categories values(2,'스마트폰/컴퓨터/노트북');
insert into categories values(1,'가구');
/**********************product insert************************/
--제품번호 이름 가격 사진 제품상세
insert into product values(product_p_no_SEQ.nextval,'LG전자 스텐드TV',990000,'defalut.png','자유롭게 이동하며 필요할때 내 곁에 두는 스크린',10);
insert into product values(product_p_no_SEQ.nextval,'삼성전자 TV',980000,'defalut.png','현실에서 보는 듯한 UHD 모니터',10);
insert into product values(product_p_no_SEQ.nextval,'삼성전자 양문형 냉장고',1430000,'defalut.png','수납은 넉넉하게,공간은 슬림하게',10);
insert into product values(product_p_no_SEQ.nextval,'LG전자 오브제컬렉션 노크온',1700000,'defalut.png','어디에나 자연스럽게 아름답게',10);
insert into product values(product_p_no_SEQ.nextval,'LG전자 일반 세탁기',395000,'defalut.png','일반 통돌이 세탁기',10);
insert into product values(product_p_no_SEQ.nextval,'삼성전자 드럼 세탁기',889000,'defalut.png','더 편히하고 위생적인 관리',10);
insert into product values(product_p_no_SEQ.nextval,'아이폰 14',1598000,'defalut.png','갬성있고 간지나는 디자인',10);
insert into product values(product_p_no_SEQ.nextval,'갤럭시 S22',889900,'defalut.png','편하고 삼성페이가능',10);
insert into product values(product_p_no_SEQ.nextval,'프리플로우 컴퓨터 본체',1109000,'defalut.png','그래픽 높은 게임 다돌아감',10);
insert into product values(product_p_no_SEQ.nextval,'삼보컴퓨터',50000,'defalut.png','지뢰찾기 돌아감',10);
insert into product values(product_p_no_SEQ.nextval,'삼성전자 갤럭시 북3',3600000,'defalut.png','초슬림&초경량 노트북',10);
insert into product values(product_p_no_SEQ.nextval,'에플 맥북에어 ',2124000,'defalut.png','초갬성&초슬림 노트북',10);
insert into product values(product_p_no_SEQ.nextval,'에이스침대',1258280,'defalut.png','편한침대',10);
insert into product values(product_p_no_SEQ.nextval,'일룸 책상세트',519000,'defalut.png','책상의자세트',10);
insert into product values(product_p_no_SEQ.nextval,'리바트 행거',95000,'defalut.png','어린이 옷걸이 행거',10);
insert into product values(product_p_no_SEQ.nextval,'일룸 로이모노 책상서랍',149000,'defalut.png','예쁜색상서랍',10);
insert into product values(product_p_no_SEQ.nextval,'필립스 스탠드 조명',119000,'defalut.png','책상 스텐드 조명',10);
insert into product values(product_p_no_SEQ.nextval,'누하스 안마의자',2069000,'defalut.png','안마 해주는 의자',10);

/**********************cart insert***************************/

/**********************orders insert*************************/

/**********************board insert**************************/




commit;
desc order_item;


