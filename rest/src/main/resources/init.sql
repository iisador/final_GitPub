create table POSITION (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into position(id, code) values (0, 'Начальник цеха');
insert into position(id, code) values (1, 'Мастер');
insert into position(id, code) values (2, 'Старший мастер');
insert into position(id, code) values (3, 'Магистр черной магии');
insert into position(id, code) values (4, 'Повелитель метлы');
insert into position(id, code) values (5, 'Фрезеровщик с тремя пальцами');
insert into position(id, code) values (6, 'Фрезеровщик с четырьмя пальцами');
insert into position(id, code) values (7, 'Батрак');

create table user (
        id BIGINT primary key auto_increment,
        name VARCHAR(100) not null,
        position BIGINT,
        type NUMBER default 0
);
insert into user (id, name, position) values (0, 'Андрей Геннадьевич', 0);
insert into user (id, name, position) values (1, 'Абрам Альбертович', 0);

insert into user (id, name, position) values (10, 'Петрович', 1);
insert into user (id, name, position) values (11, 'Иваныч', 1);
insert into user (id, name, position) values (12, 'Георгич', 1);
insert into user (id, name, position) values (13, 'Палыч', 1);
insert into user (id, name, position) values (14, 'Петровна', 1);
insert into user (id, name, position) values (15, 'Львовна', 1);
insert into user (id, name, position) values (16, 'Ильинична', 1);
insert into user (id, name, position) values (17, 'Петровна', 1);
insert into user (id, name, position) values (18, 'Санна', 1);
insert into user (id, name, position) values (19, 'Батьковна', 1);

insert into user (id, name, position) values (100, 'Работяга 100', 7);
insert into user (id, name, position) values (101, 'Работяга 101', 7);
insert into user (id, name, position) values (102, 'Работяга 102', 7);
insert into user (id, name, position) values (103, 'Работяга 103', 7);
insert into user (id, name, position) values (104, 'Работяга 104', 7);
insert into user (id, name, position) values (105, 'Работяга 105', 7);
insert into user (id, name, position) values (106, 'Работяга 106', 7);
insert into user (id, name, position) values (107, 'Работяга 107', 7);
insert into user (id, name, position) values (108, 'Работяга 108', 7);
insert into user (id, name, position) values (109, 'Работяга 109', 7);

insert into user (id, name, position) values (110, 'Работяга 110', 7);
insert into user (id, name, position) values (111, 'Работяга 111', 7);
insert into user (id, name, position) values (112, 'Работяга 112', 7);
insert into user (id, name, position) values (113, 'Работяга 113', 7);
insert into user (id, name, position) values (114, 'Работяга 114', 7);
insert into user (id, name, position) values (115, 'Работяга 115', 7);
insert into user (id, name, position) values (116, 'Работяга 116', 7);
insert into user (id, name, position) values (117, 'Работяга 117', 7);
insert into user (id, name, position) values (118, 'Работяга 118', 7);
insert into user (id, name, position) values (119, 'Работяга 119', 7);

insert into user (id, name, position) values (120, 'Работяга 120', 7);
insert into user (id, name, position) values (121, 'Работяга 121', 7);
insert into user (id, name, position) values (122, 'Работяга 122', 7);
insert into user (id, name, position) values (123, 'Работяга 123', 7);
insert into user (id, name, position) values (124, 'Работяга 124', 7);
insert into user (id, name, position) values (125, 'Работяга 125', 7);
insert into user (id, name, position) values (126, 'Работяга 126', 7);
insert into user (id, name, position) values (127, 'Работяга 127', 7);
insert into user (id, name, position) values (128, 'Работяга 128', 7);
insert into user (id, name, position) values (129, 'Работяга 129', 7);

insert into user (id, name, position) values (130, 'Работяга 130', 7);
insert into user (id, name, position) values (131, 'Работяга 131', 7);
insert into user (id, name, position) values (132, 'Работяга 132', 7);
insert into user (id, name, position) values (133, 'Работяга 133', 7);
insert into user (id, name, position) values (134, 'Работяга 134', 7);
insert into user (id, name, position) values (135, 'Работяга 135', 7);
insert into user (id, name, position) values (136, 'Работяга 136', 7);
insert into user (id, name, position) values (137, 'Работяга 137', 7);
insert into user (id, name, position) values (138, 'Работяга 138', 7);
insert into user (id, name, position) values (139, 'Работяга 139', 7);

insert into user (id, name, position) values (140, 'Работяга 140', 7);
insert into user (id, name, position) values (141, 'Работяга 141', 7);
insert into user (id, name, position) values (142, 'Работяга 142', 7);
insert into user (id, name, position) values (143, 'Работяга 143', 7);
insert into user (id, name, position) values (144, 'Работяга 144', 7);
insert into user (id, name, position) values (145, 'Работяга 145', 7);
insert into user (id, name, position) values (146, 'Работяга 146', 7);
insert into user (id, name, position) values (147, 'Работяга 147', 7);
insert into user (id, name, position) values (148, 'Работяга 148', 7);
insert into user (id, name, position) values (149, 'Работяга 149', 7);

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

create table TASKTYPE (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into TASKTYPE(id, code) values (0, 'Постоянная заявка');
insert into TASKTYPE(id, code) values (1, 'Периодическая заявка');
insert into TASKTYPE(id, code) values (2, 'Информационное сообщение');
insert into TASKTYPE(id, code) values (3, 'Поручение: организационное');
insert into TASKTYPE(id, code) values (4, 'Поручение: технологическое');
insert into TASKTYPE(id, code) values (5, 'Поручение: техническое');

create table STATUS_TYPE (
    id BIGINT primary key auto_increment,
    code VARCHAR(100)
);
insert into status_type(id, code) values (0, 'Новая');
insert into status_type(id, code) values (1, 'В работе');
insert into status_type(id, code) values (2, 'Простаивает');
insert into status_type(id, code) values (3, 'Выполнено');
insert into status_type(id, code) values (4, 'Ознакомлен');
insert into status_type(id, code) values (5, 'фтопку');

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

create table Task (
    id BIGINT primary key auto_increment,
    type BIGINT not null,
    assignee BIGINT,
    dateTo TIMESTAMP,
    dateFact TIMESTAMP,
    tstmpCreate TIMESTAMP default CURRENT_TIMESTAMP,
    author BIGINT,
    header VARCHAR(250),
    info VARCHAR(2500),
    status BIGINT DEFAULT 0,
    priority BIGINT default 3,
    parent_id BIGINT
);
insert into Task (type, assignee, dateTo, dateFact, author, header, info) values (
0, 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'Выпить, закусить', 'Петрович, выпей, закуси, потом захерач чугунный болт');