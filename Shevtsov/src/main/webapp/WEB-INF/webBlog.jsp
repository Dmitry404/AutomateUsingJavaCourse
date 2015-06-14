<%@include file="parts/begin.jsp" %>
<body>
    <div class="content">
        <%@include file="parts/header.jsp" %>
            <div id="main">
                <div class="center">
                    <c:forEach var="post" items="${posts}">
                         <h3>${post.title}</h3>
                         ${post.postContent}

                         <br> -----------------------------------------------------------

                    </c:forEach>
                </div>
            </div>
        <%@include file="parts/leftmenu.jsp" %>
        <%@include file="parts/footer.jsp" %>
    </div>
</body>

</html>
