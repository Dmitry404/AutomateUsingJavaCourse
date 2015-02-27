<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
<title> New Post </title>
</head>

<body>
<form:form method="POST" action="addPost" commandName="post">

    <table>
        <tr>
              <td><form:label path="title">Title</form:label></td>
              <td><form:input path="title" /></td>
        </tr>

        <tr>
            <td><form:label path="message">Message</form:label></td>
            <td><form:input path="message" /></td>
        </tr>

        <tr>
            <td><form:label path="url">Url</form:label></td>
            <td><form:input path="url" /></td>
        </tr>

        <tr>
            <td><form:label path="img">Img</form:label></td>
            <td><form:input path="img" /></td>
        </tr>

        <tr>
            <td colspan="2">
            <input type="submit" value="Add Post"/>
            </td>
        </tr>
    </table>

</form:form>
</body>

</html>
