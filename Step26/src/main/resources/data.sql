insert into TODO values (10001, 'Learn spring 5', false, sysdate(), 'yusuf');
insert into TODO values (10002, 'Learn kubernetes', false, sysdate(), 'yusuf');
insert into TODO values (10003, 'Learn chef', false, sysdate(), 'yusuf');


CREATE TABLE todo_example.FlashCard (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
word VARCHAR(30) NOT NULL,
definition VARCHAR(30) NOT NULL,
type VARCHAR(50),
wordorder int(6)
) ;

ALTER TABLE `todo_example`.`flashcard` 
CHANGE COLUMN `definition` `definition` VARCHAR(3000) NOT NULL ;