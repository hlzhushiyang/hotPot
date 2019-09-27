<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>web-16-springmvc...home.jsp</h1>
	<hr/>
	${u1.name}
	${u1.age}
	${u1.addr}
	<hr/>
	<c:forEach items="${list }" var="user">
	${user.name }:${user.age }:${user.addr }<br/>
	</c:forEach>
</body>
</html>