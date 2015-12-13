<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>The Blog</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

    <script>
        function deleteComment(commentId) {
            $.post("/deleteComment/" + commentId);
            window.location = "/postId=${post.id}";
        }

        function addComment() {
            var body;
            var nickname;

            nickname = document.getElementById("nickname").value;
            body = document.getElementById("body").value;

            var json = '{body: ' + body + ', postId: ' + ${post.id} +', nickname: ' + nickname + '}';
            console.log(json);

            $.ajax("addComment/add", {
                type: 'POST',
                data: json
            });

            window.location = "/postId=${post.id}";
        }
    </script>

</head>

<body>
<b>${post.topic}</b> <i> by ${post.user.nickname}</i><br>
${post.body}
<br><br>

<h3>Comments</h3>
<c:forEach var="comment" items="${commentsList}">
    ${comment.commentDateTime} <b>${comment.user.nickname}</b> wrote: <br>
    ${comment.text}<br>
    <button onclick="deleteComment('${comment.id}')">Delete</button>
    <br><br>
</c:forEach>
<br>

<h3>Add a comment...</h3>

Nickname:<br>
<input type="text" id="nickname" size="50" required><br><br>
Comment:<br>
<textarea style="height:20%; width: 40%" id="body" required></textarea><br><br>

<button style="width: 25%; height: 50px" onclick="addComment()">Add Comment</button>
</body>
</html>
