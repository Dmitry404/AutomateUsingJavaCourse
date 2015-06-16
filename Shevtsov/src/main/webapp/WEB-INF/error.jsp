<%@include file="parts/begin.jsp" %>
<body>
<div class="content">
  <%@include file="parts/header.jsp" %>
  <div id="main">
    <div class="center">

      <! -- Begin  -->
      <h2><a href="#">Error</a></h2>
      Error message: ${error_message}
      <! -- End  -->

    </div>
    <%@include file="parts/leftmenu.jsp" %>
  </div>
  <%@include file="parts/prefooter.jsp" %>
  <%@include file="parts/footer.jsp" %>
</div>
</body>
</html>
