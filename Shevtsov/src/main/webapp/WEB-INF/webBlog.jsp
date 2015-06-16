<%@include file="parts/begin.jsp" %>
<body>
    <div class="content">
        <%@include file="parts/header.jsp" %>
            <div id="main">
                <div class="center">

                    <! -- Begin  -->
                    <h2><a href="#">Blog Template</a></h2>
                    <c:forEach var="post" items="${posts}">
                         <h3>${post.title}</h3>
                         ${post.postContent}
                         <p class="date">Posted by Jack <img src="images/more.gif" alt="" /> <a href="#">Read more</a> <img src="images/comment.gif" alt="" /> <a href="#">Comments (15)</a> <img src="images/timeicon.gif" alt="" /> 17.01.</p>

                    </c:forEach>
                    <! -- End  -->

                </div>
                <%@include file="parts/leftmenu.jsp" %>
            </div>
        <%@include file="parts/prefooter.jsp" %>
        <%@include file="parts/footer.jsp" %>
    </div>
</body>
</html>
