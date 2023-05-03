drop table if exists users;

create table users(userID int primary key, username varchar(100),password varchar(100), firstname varchar(100),lastname varchar(100),address text, phone varchar(100),mailid varchar(100),usertype int);

insert into users values(1,'demo','demo','Demo','User','Demo Home','42502216225','demo@gmail.com',2);

insert into users values(2,'Admin','Admin','Mr.','Admin','Haldia WB','9584552224521','admin@gmail.com',1);

insert into users values(3,'shashi','shashi','Shashi','Raj','Bihar','1236547089','shashi@gmail.com',2);