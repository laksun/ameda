#MYSQL docker

docker run --name mysqldev -v mysql_volume:/var/lib/mysql -p 3306:3306  -e MYSQL_ROOT_PASSWORD=??????? --restart=always  -d mysql:8.0  --skip-name-resolve

#on mysql workbench


create database todo_example;

create user 'todouser'@'10.10.0.174' identified by 'todopassword';

grant all on todo_example.* to 'todouser'@'10.10.0.174';


#show all users on mysql
SELECT * FROM mysql.user;


# cretae table in the todo_example schema

use todo_example;

create table todo (id integer not null, description varchar(255), is_done boolean not null, target_date timestamp, user varchar(255), primary key (id));

INSERT INTO todo_example.todo VALUES(10001, 'Learn Spring Boot', false, sysdate(),'in28Minutes');

INSERT INTO todo_example.todo VALUES(10002, 'Learn RESTful Web Services', false, sysdate(),'in28Minutes');

INSERT INTO todo_example.todo VALUES(10003, 'Learn SOAP Web Services', false, sysdate(),'in28Minutes');
