Delimiter //
CREATE PROCEDURE addUser(IN nick varchar(255))
BEGIN

INSERT 
INTO users (nickname) 
values (nick);

END