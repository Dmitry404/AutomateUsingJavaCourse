<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title> ${post.title} </title>
<body>
        <table>

                <tbody>
                    <c:forEach var="post" items="${posts}">
                             <h3>${post.title}</h3>
                             ${post.message}
                             ${post.url}
                             ${post.img}
                             <form action="topic/${post.title}">
                                        <input type="submit" value="View topic">
                             </form>
                             <br> -----------------------------------------------------------

                    </c:forEach>
                </tbody>
        </table>
</body>
<a href="/post/viewAllPost">Back</a>
</head>