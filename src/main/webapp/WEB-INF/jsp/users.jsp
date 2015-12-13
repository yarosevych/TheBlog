<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Users List</title>

    <h1>Users List</h1>
</head>

<body>
<c:forEach var="user" items="${users}">
    <b><a href="/user=${user.id}">${user.nickname}</a><br>
    <br><br>
</c:forEach>
</body>
</html>
