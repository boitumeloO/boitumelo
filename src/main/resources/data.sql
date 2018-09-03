insert into Savings_Account(account_id,balance) values (1,2000);
insert into Savings_Account(account_id,balance) values (2,5000);

insert into Current_Account(account_id,balance,over_draft) values (3,1000,10000);
insert into Current_Account(account_id,balance,over_draft) values (4,-5000,20000);
insert into customer(customer_id,customer_number,name, surname,address,saving_account_id ) values (1,'1','cust1','cust1', 'adress1',1);
insert into customer(customer_id,customer_number,name, surname,address,saving_account_id ) values (2,'2','cust2','cust2', 'adress2',2);
insert into customer(customer_id,customer_number,name, surname,address,curent_account_id) values (3,'3','cust3','cust3', 'adress3',3);
insert into customer(customer_id,customer_number,name, surname,address,curent_account_id) values (4,'4','cust4','cust4', 'adress4',4);
