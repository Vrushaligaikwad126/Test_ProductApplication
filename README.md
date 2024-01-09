Place Order Procedure

delimiter //
create procedure placeOrder(in cName varchar(20), in proId int, in proQty int)
begin
	declare qty int;
     declare price double;
    select pQty into qty from product_info where   pId  = proId;
    select pPrice into price from product_info where  pId  = proId;
    if proQty<=qty then
		insert into order_info ( customer_Name ,  pId ,pQty) values (cName, proId,proQty);
        update product_info set pQty =  pQty- proQty where   pId  = proId;
        update order_info set total_Bill=(price*proQty) where oId=last_insert_id();
	end if;
end//
delimiter ;
