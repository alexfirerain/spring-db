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
values ('1998-05-05 13:28:00', 3, 'stuff', 8),
       ('2003-12-12 22:54:56', 1, 'staff', 6),
       ('2017-08-15 15:12:24', 5, 'buff', 2),
       ('2015-04-08 06:25:19', 4, 'guff', 5),
       ('2014-06-12 08:10:25', 1, 'duff', 9),
       ('2014-09-12 07:37:09', 5, 'cuff', 12),
       ('2008-05-09 15:12:40', 4, 'laugh', 6),
       ('2000-09-04 19:01:47', 2, 'dove', 8);