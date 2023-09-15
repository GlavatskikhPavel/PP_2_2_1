create table Users
(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL ,
name      varchar(20)  not null ,
last_name varchar(30)  not null ,
email     varchar(40)  not null
);

create table Car
(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL ,
model varchar(100)  not null ,
series int not null ,
user_id int UNIQUE REFERENCES Users(id) ON DELETE CASCADE
)