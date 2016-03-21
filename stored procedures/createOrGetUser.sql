Delimiter //
CREATE PROCEDURE createOrGetUser(IN nick VARCHAR(40), OUT userId INT)
BEGIN

SELECT ID INTO userId  FROM users WHERE nickname = nick;

IF userId is null
THEN
   INSERT INTO users (nickname) VALUES(nick);
   SELECT ID INTO userId  FROM users WHERE nickname = nick;
END IF;

END