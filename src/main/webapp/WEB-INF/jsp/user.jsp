<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>All Posts by ${user.nickname}</title>
    <h1>All Posts by ${user.nickname}</h1>
</head>

<body>
<c:forEach var="post" items="${posts}">
    <b><a href="/postId=${post.id}">${post.topic}</a></b> <i> by ${user.nickname}</i><br>
    ${post.body}
    <br><br>
</c:forEach>
</body>
</html>
