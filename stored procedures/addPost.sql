Delimiter //
CREATE PROCEDURE addPost(IN topic varchar(255), body varchar(16000), nickname varchar(255))
BEGIN

CALL createOrGetUser(nickname, @userId);
INSERT into posts (topic, body, postDateTime, userId) VALUES (topic, body, NOW(), @userId);

END