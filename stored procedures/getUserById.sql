Delimiter //
CREATE PROCEDURE getUserById(IN userId INT(11))
BEGIN

SELECT id, nickname
FROM users 
WHERE id = userId;

END;
