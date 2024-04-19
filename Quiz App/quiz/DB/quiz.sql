use quiz;

create table quiz (id int primary key auto_increment, title text, questions text);

create table quiz_questions (quiz_id int, questions_id int);


select * from quiz_questions;
select * from quiz;