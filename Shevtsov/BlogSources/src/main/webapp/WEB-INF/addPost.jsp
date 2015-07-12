<%@include file="parts/begin.jsp" %>
<body>
<div class="content">
    <%@include file="parts/header.jsp" %>
    <div id="main">
        <div class="center">

            <! -- Begin  -->
            <h2><a href="#">Add a new post</a></h2>
            <form:form method="post" action="addPost">

                <table>
                    <tr>
                        <td><form:input path="title" placeholder="Please type your post's title" size="82" test-id="addpost-title" /></td>
                    </tr>
                    <tr>
                        <td><form:textarea path="postContent" rows="30" cols="62" placeholder="Please type your post"  test-id="addpost-content" /></td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Add Post" test-id="submit-addpost"/>
                        </td>
                    </tr>
                </table>

            </form:form>
            <! -- End  -->

        </div>
        <%@include file="parts/leftmenu.jsp" %>
    </div>
    <%@include file="parts/prefooter.jsp" %>
    <%@include file="parts/footer.jsp" %>
</div>
</body>
</html>
