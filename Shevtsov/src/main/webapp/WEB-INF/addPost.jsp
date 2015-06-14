<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
<h2>Contact Manager</h2>
<form:form method="post" action="addPost">
 
    <table>
    <tr>
        <td><form:label path="title">Title</form:label></td>
        <td><form:input path="title" /></td>
    </tr>
    <tr>
        <td><form:label path="postContent">Content</form:label></td>
        <td><form:input path="postContent" /></td>
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