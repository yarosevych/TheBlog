Delimiter //
CREATE PROCEDURE getAllPosts(IN postId INT(11))
BEGIN

SELECT a.id, a.topic, a.body, a.postDateTime, b.id, b.nickname
FROM posts a, users b
WHERE a.userId = b.id;

END;
