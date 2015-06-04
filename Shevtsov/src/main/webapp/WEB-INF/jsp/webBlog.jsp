<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page errorPage="error.jsp" %>
<html lang="en">

<body>
<h1> Web Blog</h1>
<a href="/demo/addPost">Add new Post</a>

	<c:forEach var="post" items="${posts}">
         <h3>${post.title}</h3>
         ${post.body}

         <br> -----------------------------------------------------------

    </c:forEach>
</body>

</html>
