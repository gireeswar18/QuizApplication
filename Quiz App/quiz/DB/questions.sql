create database quiz;
use quiz;

create table questions (
		id int auto_increment,
		question_title text not null,
        option1 text not null,
        option2 text not null,
        option3 text not null,
        option4 text not null,
        right_answer text not null,
        difficulty_level text not null,
        category text not null,
        primary key(id)
);

select id, right_answer from questions where id = 6 or id = 2 or id = 7 or id = 3 or id = 11;

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What is the default value of int datatype in Java?', '0', '1', '-1', 'null', '1', 'easy', 'Java');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('Which keyword is used to define a constant in Java?', 'constant', 'final', 'immutable', 'static', '2', 'easy', 'Java');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What is the main purpose of the "static" keyword in Java?', 'To create a static class', 'To define a constant', 'To allow only one instance of a class', 'To allow the class to be accessed without instantiation', '4', 'easy', 'Java');

-- Python Easy Questions
INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('Which of the following is NOT a valid variable name in Python?', 'my_var', '_myvar', '2myvar', 'myVar', '3', 'easy', 'Python');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What is the output of print(2 * 3 ** 3 % 2)?', '1', '2', '3', '0', '3', 'easy', 'Python');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What is the output of 12 >> 2 in Java?', '3', '6', '12', '2', '3', 'medium', 'Java');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What is the output of the following code?\nint x = 5;\nSystem.out.println(x++);', '5', '6', '4', 'Compiler Error', '5', 'medium', 'Java');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('Which of the following is true about Python?', 'Python is strongly typed', 'Python is a procedural programming language', 'Python does not support object-oriented programming', 'Python is dynamically typed', '4', 'medium', 'Python');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What does the "pass" statement do in Python?', 'It terminates the current loop', 'It raises an exception', 'It does nothing', 'It skips the current iteration of the loop', '3', 'medium', 'Python');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What is the result of Math.pow(2, 3) in Java?', '8', '6', '5', '9', '1', 'difficult', 'Java');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What will be the output of the following code?\nint x = 3;\nint y = ++x + x++ + x;\nSystem.out.println(y);', '13', '14', '15', '16', '16', 'difficult', 'Java');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What is the output of the following code?\ndef f(x, l=[]):\n    for i in range(x):\n        l.append(i*i)\n    print(l)\nf(2)\nf(3, [3, 2, 1])', '[0, 1]', '[0, 1, 4]', '[0, 1, 4, 0, 1, 4]', '[3, 2, 1, 0, 1, 4]', '[0, 1]', 'difficult', 'Python');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What will be the output of the following code?\nlist = [1, 2, 3, 4]\nprint(list[5])', 'IndexError: list index out of range', '5', 'None', '4', 'IndexError: list index out of range', 'difficult', 'Python');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What is the purpose of a constructor in Java?', 'To initialize class variables', 'To define class methods', 'To create objects of a class', 'To provide inheritance', '1', 'easy', 'Java');

INSERT INTO questions (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES ('What is the output of the following code in Python?\nprint("Hello" + 3)', 'TypeError', 'Hello3', 'Hello 3', 'SyntaxError', 'TypeError', 'easy', 'Python');


select * from questions;
