CREATE DATABASE project;

USE project;

CREATE TABLE student (
	name VARCHAR(50),
    dob VARCHAR(11),
    pnum VARCHAR(10),
    email VARCHAR(50),
    gender VARCHAR(20),
    isMarried VARCHAR(10),
    address VARCHAR(500),
    college VARCHAR(70),
    percent FLOAT NOT NULL,
    course VARCHAR(50),
    cast VARCHAR(10),
    password VARCHAR(50),
    room INT,
    roll INT 
);

CREATE TABLE worker (
	name VARCHAR(50),
    dob VARCHAR(11),
	pnum VARCHAR(10),
    email VARCHAR(50),
    gender VARCHAR(20),
    isMarried VARCHAR(10),
    address VARCHAR(500),
    lastWorkPlace VARCHAR(50),
    job VARCHAR(10),
    cast VARCHAR(10),
    password VARCHAR(10),
    id INT PRIMARY KEY
    
);

CREATE TABLE complain (
    roll VARCHAR(50),
    room VARCHAR(50),
	complainType VARCHAR(50),
    complain VARCHAR(100),
    dateOfCompalin VARCHAR(10)
);

CREATE TABLE admin (
	username VARCHAR(50),
    password VARCHAR(10)
);

CREATE TABLE rooms (
	roomNo INT PRIMARY KEY,
    roll INT
);

CREATE TABLE expenses (
	maintanance INT,
    electric INT,
    food INT,
    worker INT,
    othertype VARCHAR(25),
    other INT,
    total INT,
    date VARCHAR(50)
);

CREATE TABLE mess(
	time VARCHAR(20),
	monday VARCHAR(20),
	tuesday VARCHAR(20),
	wednsday VARCHAR(20),
	thursay VARCHAR(20),
	friday VARCHAR(20),
	saturday VARCHAR(20),
	sunday VARCHAR(20)
);

CREATE TABLE service (
	roll int,
    room int,
    isdone VARCHAR(50)
);

CREATE TABLE register (
	roll int,
    room int,
    isOut VARCHAR(50)
);

INSERT INTO service (roll,room,isdone)
VALUES
(23,43,1);

INSERT INTO rooms (roomNo,roll)
VALUES 
(1,0),
(2,0),
(3,0),
(4,0),
(5,0),
(6,0),
(7,0),
(8,0),
(9,0),
(10,0),
(11,0),
(12,0),
(13,0),
(14,0),
(15,0),
(16,0),
(17,0),
(18,0),
(19,0),
(20,0),
(21,0),
(22,0),
(23,0),
(24,0),
(25,0),
(26,0),
(27,0),
(28,0),
(29,0),
(30,0);

INSERT INTO mess
(time,monday,tuesday,wednsday,thursay,friday,saturday,sunday)
 VALUES
('7:00 - 9:00 AM','Papadi','Mag','Khaman','Chavana','Chana','Bread','Dhokla'),
('','','','','','','',''),
('12:00 - 2:00 PM','Dudhi Bataka','Rasavada Chana','Dungari Bataka','Sev Tameta','Mix Sakbhaji','Bataka','Suki Bhaji'),
('','Dal-Bhat','Dal-Bhat','Dal-Bhat','Dal-Bhat','Dal-Bhat','Dal-Bhat','Pulav'),
('','Chas','Chas','Chas','Dahi','Chas','Dahi','Chas'),
('','','','','','','',''),
('7:00 - 9:00 PM','Paneer','Rasavada Mag','Chole Chana','Sev Tameta','Dungadi Bataka','Rasavda Bataka','Dal-Bati'),
('','Dal-Bhat','Dal-Bhat','Pulav','Dal-Bhat','Dal-Bhat','Dal-Bhat','Pulav'),
('','Chas','Dudh','Chas','Dudh','Chas','','Chas');

CREATE VIEW adminS AS
SELECT roll,name,room,dob,pnum,email,gender,isMarried,address,college,percent,course,cast FROM student;

CREATE VIEW adminW AS
SELECT id,name,job,dob,pnum,email,gender,isMarried,address,lastWorkPlace,cast FROM worker;

SELECT * FROM student;
SELECT * FROM worker;
SELECT * FROM complain;
SELECT * FROM rooms;
SELECT * FROM admin;
SELECT * FROM mess;
SELECT * FROM adminS;
SELECT * FROM adminW;

SELECT roomNo from rooms where not roll  = 0;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM student WHERE percent = 46;

UPDATE student SET roll = 148 WHERE name = "Darsh";

DELETE FROM complain;
