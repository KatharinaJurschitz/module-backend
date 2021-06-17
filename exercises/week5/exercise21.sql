create database week5exercise;
use week5exercise;

create table persons (
	id varchar(10),
    	firstName varchar(50),
    	lastName varchar(50),
    	email varchar(100),
    	unique key email_unique (email),
    	primary key (id)
);

create table courses (
	id varchar(10),
    	courseName varchar(50),
    	primary key (id)
);

create table exercises (
	id varchar(10),
    	exerciseName varchar(50),
    	dueDate varchar(10),
    	course varchar(50) NOT NULL,
    	teacher varchar(50) NOT NULL,
    	student varchar(50) NOT NULL,
    	primary key (id),
    	constraint exc_fk_courses foreign key (course) references courses (id),
    	constraint exc_fk_teacher foreign key (teacher) references persons (id),
    	constraint exc_fk_student foreign key (student) references persons (id),
    	constraint exc_chk_teacherstudent check (teacher <> student)
);

create table results (
	exerciseId varchar(10),
    	result int,
    	constraint res_chk_range check (result between 0 AND 100),
constraint res_fk_id foreign key (exerciseId) references exercises (id)
);
