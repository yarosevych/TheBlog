<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>The Blog</title>
</head>

<body>
<h2>Posts</h2>
<table id="postList">
    <tr style="font-size: large"></tr>
    <c:forEach var="post" items="${postList}">
        <b>${post.topic}</b> <i> by ${post.user.nickname}</i><br>
        ${post.body}
        <br><br>
    </c:forEach>
</table>
</body>
</html>
