<%@include file="parts/begin.jsp" %>
<body>
<div class="content">
  <%@include file="parts/header.jsp" %>
  <div id="main">
    <div class="center">

      <! -- Begin  -->
      <h2><a href="#">Please Log In</a></h2>
      <form:form method="post" action="login">
        <table>
          <tr>
            <td><form:input path="userName" placeholder="Username" size="30" /></td>
          </tr>
          <tr>
            <td><form:input path="password" type = "password" placeholder="Password" size="30" /></td>
          </tr>
          <tr>
            <td colspan="2">
              <input type="submit" value="Log In" test-id="submit-login"/>
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
