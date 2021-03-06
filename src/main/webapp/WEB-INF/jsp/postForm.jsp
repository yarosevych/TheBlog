<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>The Blog</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

    <script>
        $(document).ready(function () {
            $.ajaxSetup({
                async: false
            });
        });

        function addPost() {
            var topic;
            var body;
            var nickname;

            nickname = document.getElementById("nickname").value;
            topic = document.getElementById("topic").value;
            body = document.getElementById("body").value;
            var json = '{nickname: ' + nickname + ', topic: ' + topic + ', body: ' + body + '}';

            console.log(json);

            $.ajax("addPost/add", {
                type: 'POST',
                data: json
            });

            window.location = "/";
        }
    </script>
</head>

<body>
<h2>Add a post</h2>

Nickname:<br>
<input type="text" style="width: 15%;" id="nickname"><br><br>
Topic:<br>
<input type="text" style="width: 40%;" id="topic"><br><br>
Text:<br>
<textarea style="width: 40%; height: 20%" id="body"></textarea><br><br>

<button style="width: 25%; height: 50px" onclick="addPost()">Add Post</button>

</body>
</html>
