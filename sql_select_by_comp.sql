CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

select * from company;
select * from person;

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'Компания 1');
insert into company(id, name) values (2, 'Рога и копыта');
insert into company(id, name) values (3, 'ООО АУДИ');
insert into company(id, name) values (4, 'Росгосстрах');
insert into company(id, name) values (5, 'Сбербанк');

insert into person(id, name, company_id) values (1, 'Иванов Иван', 1);
insert into person(id, name, company_id) values (2, 'Иванов Петр', 1);
insert into person(id, name, company_id) values (3, 'Зильбердович Геннадий', 2);
insert into person(id, name, company_id) values (4, 'Петров Илья', 2);
insert into person(id, name) values (5, 'Елецкий Игорь');
insert into person(id, name, company_id) values (6, 'Коринжук Станислав', 3);
insert into person(id, name, company_id) values (7, 'Белов Борис', 4);
insert into person(id, name, company_id) values (8, 'Ионова Мария', 5);
insert into person(id, name, company_id) values (9, 'Ион Анастасия', 1);

--имена всех person, которые не состоят в компании с id = 5 + название компании для каждого человека
select p.name, c.name, p.company_id from person p
join company c on c.id=p.company_id
where p.company_id != 5;
--название компании с максимальным количеством человек + количество человек в этой компании
select c.name, count(p.id) as Количество_сотрудников from company c
join person p on c.id = p.company_id
group by c.name
having count(p.id) = (select max(m) from (select count(g.id) as m from company g 
					  join person q on g.id = q.company_id group by g.name) as d);

