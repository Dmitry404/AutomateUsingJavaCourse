<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title> View All Posts </title>
</head>

<body>
    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Message</th>
                <th>Url</th>
                <th>Img</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${posts}">
                     <h3>${post.title}</h3>
                     ${post.message}
                     ${post.url}
                     ${post.img}

                     <br> -----------------------------------------------------------

                </c:forEach>
        </tbody>
    </table>
	<a href="/post/fillPost">Add new Post</a>
</body>

</html>
