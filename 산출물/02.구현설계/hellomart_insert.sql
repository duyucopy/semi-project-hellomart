/**********************member insert************************/
insert into userinfo(userid,password,name,email) values('guard1','1111','김경호1','guard1@korea.com');
insert into userinfo(userid,password,name,email) values('guard2','2222','김경호2','guard2@korea.com');
insert into userinfo(userid,password,name,email) values('guard3','3333','김경호3','guard3@korea.com');

/**********************product insert************************/



/**********************cart insert************************/
insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_SEQ.nextval,'guard1',2,1);
insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_SEQ.nextval,'guard2',1,2);
insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_SEQ.nextval,'guard3',3,1);

/**********************orders insert************************/



commit;
desc order_item;


