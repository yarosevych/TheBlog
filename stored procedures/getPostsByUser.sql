Delimiter //
CREATE PROCEDURE getPostsByUser(IN userIdGet INT(11))
BEGIN

SELECT id, topic, body, postDateTime, userId
FROM posts
WHERE userId = userIdGet;

END;
