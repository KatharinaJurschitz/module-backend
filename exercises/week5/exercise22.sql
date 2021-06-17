insert into persons (id, firstName, lastName, email) values ("s01", "Harry", "Potter", "h.potter@hogwarts.com");
insert into persons (id, firstName, lastName, email) values ("s02", "Hermione", "Granger", "h.granger@hogwarts.com");
insert into persons (id, firstName, lastName, email) values ("s03", "Ronald", "Weasley", "r.weasley@hogwarts.com");
insert into persons (id, firstName, lastName, email) values ("t01", "Cuthbert", "Binns", "c.binns@hogwarts.com");
insert into persons (id, firstName, lastName, email) values ("t02", "Severus", "Snape", "s.snape@hogwarts.com");
insert into persons (id, firstName, lastName, email) values ("t03", "Remus", "Lupin", "r.lupin@hogwarts.com");

insert into courses (id, courseName) values ("c01", "History of Magic");
insert into courses (id, courseName) values ("c02", "Potions");
insert into courses (id, courseName) values ("c03", "Defence Against the Dark Arts");

insert into exercises (id, exerciseName, dueDate, course, teacher, student) values ("ex01", "Essay: Goblin Rebellion", 2021-06-20, "c01", "t01", "s01");
insert into exercises (id, exerciseName, dueDate, course, teacher, student) values ("ex02", "Essay: Veritaserum", 2021-06-10, "c02", "t02", "s02");
insert into exercises (id, exerciseName, dueDate, course, teacher, student) values ("ex03", "Essay: Boggarts", 2021-06-30, "c03", "t03", "s03");

insert into results (exerciseId, result) values ("ex01", 68);
insert into results (exerciseId, result) values ("ex02", 100);
insert into results (exerciseId, result) values ("ex03", null);
