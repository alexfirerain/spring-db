# use enterprise;
insert into customers
    (name, surname, age, phone_number)
values ('Ame', 'Sury', 19, '+93789'),
       ('Bame', 'Suro', 29, '+93723'),
       ('Game', 'Suri', 50, '+94899'),
       ('Came', 'Sura', 33, '+95734'),
       ('Dame', 'Suru', 26, '+94483'),
       ('Fame', 'Sure', 25, '+93156');

insert into orders
    (date, customer_id, product_name, amount)
values ('05-05-1998', 3, 'stuff', 8),
       ('12-12-2003', 1, 'staff', 6),
       ('15-08-2017', 5, 'buff', 2),
       ('04-08-2015', 4, 'guff', 5),
       ('06-12-2014', 1, 'duff', 9),
       ('09-12-2014', 5, 'cuff', 12),
       ('05-09-2008', 4, 'laugh', 6),
       ('09-04-2000', 2, 'dove', 8);