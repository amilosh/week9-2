drop database items if exists;
create database items;

Data base shemas are created autonatically after application running.

create table item_attribute(item_id INT(11), attribute_id INT(11));


insert into item (code) values (1), (2), (3);

insert into item_ru (name) values ("телефон"), ("ноутбук"), ("принтер");

insert into item_en (name) values ("phone"), ("laptop"), ("printer");


insert into attribute_ru (name) values ("модель"), ("производитель"), ("размер экрана"), ("процессор"), ("видеокарта"), ("тип принтера");

insert into attribute_en (name) values ("model"), ("manufacture"), ("screen size"), ("cpu"), ("video card"), ("printer type");


insert into item_attribute (item_id, attribute_id) values
(1, 1), (1, 2), (1, 3),
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5),
(3, 1), (3, 2), (3, 6);

EXPLAIN
select i.name as name from item as item
            join item_ru as i
            on item.id = i.id
            where item.code=1
EXPLAIN
select a.name from item as item
            join item_attribute as ia
            on item.id = ia.item_id
            join attribute_ru as a
            on ia.attribute_id = a.id
            where item.code = 1