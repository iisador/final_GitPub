create table POSITION (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into position(id, code) values (0, 'Начальник цеха');
insert into position(id, code) values (1, 'Мастер');
insert into position(id, code) values (2, 'Старший мастер');
insert into position(id, code) values (3, 'Зам. мастера');
insert into position(id, code) values (4, 'Технолог');
insert into position(id, code) values (5, 'Фрезеровщик');
insert into position(id, code) values (6, 'Фрезеровщик I разряда');
insert into position(id, code) values (7, 'Рабочий');

create table user (
        id BIGINT primary key auto_increment,
        name VARCHAR(100) not null,
        position_id BIGINT,
        type NUMBER default 0
);
insert into user (id, name, position_id) values (0, 'Андрей Геннадьевич', 0);
insert into user (id, name, position_id) values (1, 'Абрам Альбертович', 0);

insert into user (id, name, position_id) values (10, 'Петрович', 1);
insert into user (id, name, position_id) values (11, 'Иваныч', 1);
insert into user (id, name, position_id) values (12, 'Георгич', 1);
insert into user (id, name, position_id) values (13, 'Палыч', 1);
insert into user (id, name, position_id) values (14, 'Петровна', 1);
insert into user (id, name, position_id) values (15, 'Львовна', 1);
insert into user (id, name, position_id) values (16, 'Ильинична', 1);
insert into user (id, name, position_id) values (17, 'Петровна', 1);
insert into user (id, name, position_id) values (18, 'Санна', 1);
insert into user (id, name, position_id) values (19, 'Батьковна', 1);

insert into user (id, name, position_id) values (100, 'Рабочий 100', 7);
insert into user (id, name, position_id) values (101, 'Рабочий 101', 7);
insert into user (id, name, position_id) values (102, 'Рабочий 102', 7);
insert into user (id, name, position_id) values (103, 'Рабочий 103', 7);
insert into user (id, name, position_id) values (104, 'Рабочий 104', 7);
insert into user (id, name, position_id) values (105, 'Рабочий 105', 7);
insert into user (id, name, position_id) values (106, 'Рабочий 106', 7);
insert into user (id, name, position_id) values (107, 'Рабочий 107', 7);
insert into user (id, name, position_id) values (108, 'Рабочий 108', 7);
insert into user (id, name, position_id) values (109, 'Рабочий 109', 7);

insert into user (id, name, position_id) values (110, 'Рабочий 110', 7);
insert into user (id, name, position_id) values (111, 'Рабочий 111', 7);
insert into user (id, name, position_id) values (112, 'Рабочий 112', 7);
insert into user (id, name, position_id) values (113, 'Рабочий 113', 7);
insert into user (id, name, position_id) values (114, 'Рабочий 114', 7);
insert into user (id, name, position_id) values (115, 'Рабочий 115', 7);
insert into user (id, name, position_id) values (116, 'Рабочий 116', 7);
insert into user (id, name, position_id) values (117, 'Рабочий 117', 7);
insert into user (id, name, position_id) values (118, 'Рабочий 118', 7);
insert into user (id, name, position_id) values (119, 'Рабочий 119', 7);

insert into user (id, name, position_id) values (120, 'Рабочий 120', 7);
insert into user (id, name, position_id) values (121, 'Рабочий 121', 7);
insert into user (id, name, position_id) values (122, 'Рабочий 122', 7);
insert into user (id, name, position_id) values (123, 'Рабочий 123', 7);
insert into user (id, name, position_id) values (124, 'Рабочий 124', 7);
insert into user (id, name, position_id) values (125, 'Рабочий 125', 7);
insert into user (id, name, position_id) values (126, 'Рабочий 126', 7);
insert into user (id, name, position_id) values (127, 'Рабочий 127', 7);
insert into user (id, name, position_id) values (128, 'Рабочий 128', 7);
insert into user (id, name, position_id) values (129, 'Рабочий 129', 7);

insert into user (id, name, position_id) values (130, 'Рабочий 130', 7);
insert into user (id, name, position_id) values (131, 'Рабочий 131', 7);
insert into user (id, name, position_id) values (132, 'Рабочий 132', 7);
insert into user (id, name, position_id) values (133, 'Рабочий 133', 7);
insert into user (id, name, position_id) values (134, 'Рабочий 134', 7);
insert into user (id, name, position_id) values (135, 'Рабочий 135', 7);
insert into user (id, name, position_id) values (136, 'Рабочий 136', 7);
insert into user (id, name, position_id) values (137, 'Рабочий 137', 7);
insert into user (id, name, position_id) values (138, 'Рабочий 138', 7);
insert into user (id, name, position_id) values (139, 'Рабочий 139', 7);

insert into user (id, name, position_id) values (140, 'Рабочий 140', 7);
insert into user (id, name, position_id) values (141, 'Рабочий 141', 7);
insert into user (id, name, position_id) values (142, 'Рабочий 142', 7);
insert into user (id, name, position_id) values (143, 'Рабочий 143', 7);
insert into user (id, name, position_id) values (144, 'Рабочий 144', 7);
insert into user (id, name, position_id) values (145, 'Рабочий 145', 7);
insert into user (id, name, position_id) values (146, 'Рабочий 146', 7);
insert into user (id, name, position_id) values (147, 'Рабочий 147', 7);
insert into user (id, name, position_id) values (148, 'Рабочий 148', 7);
insert into user (id, name, position_id) values (149, 'Рабочий 149', 7);

insert into user (id, name, type) values (20, 'Мастера цеха 0', 1);
insert into user (id, name, type) values (21, 'Мастера цеха 1', 1);
insert into user (id, name, type) values (22, 'Мастера цеха 2', 1);
insert into user (id, name, type) values (23, 'Мастера цеха 3', 1);
insert into user (id, name, type) values (24, 'Мастера цеха 4', 1);

create table UserGroup (
    group_id bigint not null,
    user_id bigint not null
);
insert into UserGroup (group_id, user_id) values (20, 10);
insert into UserGroup (group_id, user_id) values (20, 11);
insert into UserGroup (group_id, user_id) values (21, 12);
insert into UserGroup (group_id, user_id) values (21, 13);
insert into UserGroup (group_id, user_id) values (22, 14);
insert into UserGroup (group_id, user_id) values (22, 15);
insert into UserGroup (group_id, user_id) values (23, 16);
insert into UserGroup (group_id, user_id) values (23, 17);
insert into UserGroup (group_id, user_id) values (24, 18);
insert into UserGroup (group_id, user_id) values (24, 19);

create table taskgroup (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into taskgroup(id, code) values (0, 'Постоянная задача');
insert into taskgroup(id, code) values (1, 'Периодическая задача');

create table TASKTYPE (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into TASKTYPE(id, code) values (0, 'Информационное сообщение');
insert into TASKTYPE(id, code) values (1, 'Поручение: организационное');
insert into TASKTYPE(id, code) values (2, 'Поручение: технологическое');
insert into TASKTYPE(id, code) values (3, 'Поручение: техническое');

create table STATUSTYPE (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into STATUSTYPE(id, code) values (0, 'Новая');
insert into STATUSTYPE(id, code) values (1, 'В работе');
insert into STATUSTYPE(id, code) values (2, 'Простаивает');
insert into STATUSTYPE(id, code) values (3, 'Выполнено');
insert into STATUSTYPE(id, code) values (4, 'Ознакомлен');
insert into STATUSTYPE(id, code) values (5, 'Отменена');

create table reaction (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into reaction(id, code) values (0, 'Принято к сведению');
insert into reaction(id, code) values (1, 'Взял в работу');
insert into reaction(id, code) values (2, 'Конфликт выполнения');
insert into reaction(id, code) values (3, 'Отказано');

create table department (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into department(id, code) values (0, 'Цех 0');
insert into department(id, code) values (1, 'Цех 1');
insert into department(id, code) values (2, 'Цех 2');
insert into department(id, code) values (3, 'Цех 3');
insert into department(id, code) values (4, 'Цех 4');

create table housing (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into housing(id, code) values (0, 'Корпус 0');
insert into housing(id, code) values (1, 'Корпус 1');
insert into housing(id, code) values (2, 'Корпус 2');
insert into housing(id, code) values (3, 'Корпус 3');
insert into housing(id, code) values (4, 'Корпус 4');
insert into housing(id, code) values (5, 'Корпус 5');
insert into housing(id, code) values (6, 'Корпус 6');
insert into housing(id, code) values (7, 'Корпус 7');
insert into housing(id, code) values (8, 'Корпус 8');
insert into housing(id, code) values (9, 'Корпус 9');
insert into housing(id, code) values (10, 'Корпус 10');
insert into housing(id, code) values (11, 'Корпус 11');

create table DepartmentHousing (
    department_id bigint not null,
    housing_id bigint not null
);

insert into DepartmentHousing(department_id, housing_id) values (0, 0);
insert into DepartmentHousing(department_id, housing_id) values (0, 1);
insert into DepartmentHousing(department_id, housing_id) values (1, 2);
insert into DepartmentHousing(department_id, housing_id) values (1, 3);
insert into DepartmentHousing(department_id, housing_id) values (2, 4);
insert into DepartmentHousing(department_id, housing_id) values (2, 5);
insert into DepartmentHousing(department_id, housing_id) values (2, 10);
insert into DepartmentHousing(department_id, housing_id) values (3, 6);
insert into DepartmentHousing(department_id, housing_id) values (3, 7);
insert into DepartmentHousing(department_id, housing_id) values (4, 8);
insert into DepartmentHousing(department_id, housing_id) values (4, 9);
insert into DepartmentHousing(department_id, housing_id) values (4, 11);

create table priority (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into priority(id, code) values (0, 'Очень срочно');
insert into priority(id, code) values (1, 'Срочно');
insert into priority(id, code) values (2, 'Обычно');
insert into priority(id, code) values (3, 'Нормально');
insert into priority(id, code) values (4, 'Не срочно');
insert into priority(id, code) values (5, 'Очень не срочно');

create table Task (
    id BIGINT primary key auto_increment,
    type_id BIGINT not null,
    assignee_id BIGINT,
    dateTo TIMESTAMP,
    dateFact TIMESTAMP,
    tstmpCreate TIMESTAMP default CURRENT_TIMESTAMP,
    author_id BIGINT,
    header VARCHAR(250),
    info VARCHAR(2500),
    status_id BIGINT DEFAULT 0,
    priority_id BIGINT,
    parent_id BIGINT,
    group_id bigint,
    reaction_id bigint
);
insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, group_id, reaction_id) values (
1, 0, 10, PARSEDATETIME('29.11.2020 00:00:00','dd.MM.yyyy hh:mm:ss','en'), null, 0, 'Осмотреть фрезеровальный станок', 'осмотреть фрезеровальный станок 6Т13 на предмет износа', 1, 0, 0);
insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, parent_id) values (
2, 0, 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 10, 'Создание подзадач для рабочих', 'Будет создано 13 задач', 1, 1);

insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, group_id) values (
3, 3, 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'Проверить устойчивость детали 355332', 'Проверить устойчивость детали 355332 к устойчивости на температурные и вибрационные воздействия', 1, 1);
insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, parent_id) values (
4, 3, 110, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 11, 'Проверить устойчивость детали 355332', 'установка оснастки для температурных испытаний детали 355332 к устойчивости на температурные и вибрационные воздействия', 1, 3);

insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, group_id, reaction_id) values (
7, 0, 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'Проверить устойчивость детали 234', 'Проверить устойчивость детали 234 к устойчивости на температурные и вибрационные воздействия', 3, 0, 0);
insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, group_id, reaction_id) values (
10, 0, 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'Проверка детали 3312', 'Проверить устойчивость детали 3312 к устойчивости на температурные и вибрационные воздействия', 3, 0, 0);
insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, group_id, reaction_id) values (
8, 0, 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'Установить деталь М2-631 в корпус', 'Установить деталь М2-631 в корпус', 2, 0, 0);
insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, group_id, reaction_id) values (
9, 0, 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'Провести вибрационные испытания в рамках ОКР Зима-К', 'Провести вибрационные испытания в рамках ОКР Зима-К', 4, 0, 0);

insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, group_id, reaction_id) values (
11, 0, 13, PARSEDATETIME('29.11.2020 00:00:00','dd.MM.yyyy hh:mm:ss','en'), null, 0, 'Заполнить журнал техники безопасности', 'заполнить журнал ТБ за смену', 3, 0, 0);
insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, group_id, reaction_id) values (
12, 3, 13, PARSEDATETIME('29.11.2020 00:00:00','dd.MM.yyyy hh:mm:ss','en'), null, 0, 'Провести обучение сотрудников', 'Провести обучение сотрудников по работе с ПО "Призма"', 3, 0, 0);
insert into Task (id, type_id, assignee_id, dateTo, dateFact, author_id, header, info, priority_id, group_id, reaction_id, parent_id) values (
13, 2, 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'Провести обучение сотрудников', 'Собрать сотрудников в конференц-зале сегодня в 15:00 ', 4, 0, 0, 12);
create table comment (
        id BIGINT primary key auto_increment,
        task_id bigint not null,
        author_id bigint not null,
        content varchar(1500) not null,
        tstmpCreate timestamp default CURRENT_TIMESTAMP,
        closing boolean default false
);
insert into comment(id, task_id, author_id, content) values (1, 1, 10, 'так точно!');

create table attachment (
        id BIGINT primary key auto_increment,
        task_id bigint,
        tstmpCreate TIMESTAMP default CURRENT_TIMESTAMP,
        author_id bigint,
        name varchar(150),
        content blob,
        url varchar(1500),
        comment_id bigint
);
insert into attachment(task_id, author_id, name, content, url) values (1, 10, 'картинка.png', '032348762039847629837603874602', 'https://img5.lalafo.com/i/posters/original/3e/c6/aa50cf11f4b04cbf4790cee7169f.jpeg');
insert into attachment(comment_id, author_id, name, content, url) values (1, 10, 'картинка.png', '032348762039847629837603874602', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAQRPJxJzJVjGKhKu77fWr1jL1i5C-tlrudQ&usqp=CAU');

create table userhousing (
    id BIGINT primary key auto_increment,
    user_id BIGINT not null,
    housing_id BIGINT not null,
    document_id BIGINT not null
);

create table document (
    id BIGINT not null,
    name VARCHAR(250) not null,
    date DATE not null,
    author_id bigint,
    tstmpCreate timestamp default current_timestamp,
    content blob
);
