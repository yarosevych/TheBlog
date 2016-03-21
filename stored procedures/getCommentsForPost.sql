Delimiter //
CREATE PROCEDURE getCommentsForPost(IN postIdIn INT(11))
BEGIN

SELECT a.id, a.body, a.commentDateTime, b.id, b.nickname
FROM comments a, users b
WHERE a.postId = postIdIn AND a.userId = b.id;

END