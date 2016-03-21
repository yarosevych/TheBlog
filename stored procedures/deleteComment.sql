Delimiter //
CREATE PROCEDURE deleteComment(IN commentId INT(11))
BEGIN

DELETE FROM comments
WHERE id = commentId;

END