CREATE DATABASE Project;

USE Project;
CREATE TABLE mess(
time VARCHAR(20),
monday varchar(20),
tuesday varchar(20),
wednsday varchar(20),
thursay varchar(20),
friday varchar(20),
saturday varchar(20),
sunday varchar(20)
);
CREATE TABLE student(
name VARCHAR(50),
dob VARCHAR(10),
phonenum VARCHAR(20),
email VARCHAR(50),
gender VARCHAR(10),
married VARCHAR(10),
address VARCHAR(255),
college VARCHAR(255),
class12pr float,
course VARCHAR(50),
cast VARCHAR(20),
pass VARCHAR(20),
rollno INT,
roomno INT
);

CREATE TABLE worker(
name VARCHAR(50),
dob VARCHAR(10),
phonenum VARCHAR(20),
email VARCHAR(50),
gender VARCHAR(10),
married VARCHAR(10),
address VARCHAR(255),
last_place VARCHAR(255),
field VARCHAR(50),
cast VARCHAR(20),
pass VARCHAR(20),
id INT
);
insert into mess
(time,monday,tuesday,wednsday,thursay,friday,saturday,sunday)
 values
('7:00 - 9:00 AM','Papadi','Mag','Khaman','Chavana','Chana','Bread','Dhokla'),
('','','','','','','',''),
('12:00 - 2:00 PM','Dudhi Bataka','Rasavada Chana','Dungari Bataka','Sev Tameta','Mix Sakbhaji','Bataka','Suki Bhaji'),
('','Dal-Bhat','Dal-Bhat','Dal-Bhat','Dal-Bhat','Dal-Bhat','Dal-Bhat','Pulav'),
('','Chas','Chas','Chas','Dahi','Chas','Dahi','Chas'),
('','','','','','','',''),
('7:00 - 9:00 PM','Paneer','Rasavada Mag','Chole Chana','Sev Tameta','Dungadi Bataka','Rasavda Bataka','Dal-Bati'),
('','Dal-Bhat','Dal-Bhat','Pulav','Dal-Bhat','Dal-Bhat','Dal-Bhat','Pulav'),
('','Chas','Dudh','Chas','Dudh','Chas','','Chas');

select * from complain;