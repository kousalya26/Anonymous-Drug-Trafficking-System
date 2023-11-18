drop database reports;
create database reports;
use reports;
create table report (id INT auto_increment report_name varchar(255), report_content varchar(2000),location varchar(255), primary key(id));