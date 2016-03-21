Delimiter //
CREATE PROCEDURE addComment(IN body VARCHAR(2000), postId INT(11), nickname VARCHAR(255))
BEGIN

CALL createOrGetUser(nickname, @userId);
INSERT INTO comments (body, commentDateTime, userId, postId) 
VALUES (body, NOW(), @userId, postId);

END;
