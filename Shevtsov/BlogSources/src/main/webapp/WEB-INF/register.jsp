<%@include file="parts/begin.jsp" %>
<body>
<div class="content">
  <%@include file="parts/header.jsp" %>
  <div id="main">
    <div class="center">

      <! -- Begin  -->
      <h2><a href="#">Register a new user</a></h2>
      <form:form method="post" action="register">
        <table>
          <tr>
            <td><form:input path="email" placeholder="youremail@example.com" size="30" test-id="register-email" /></td>
          </tr>
          <tr>
            <td><form:input path="userName" placeholder="Username" size="30" test-id="register-username" /></td>
          </tr>
          <tr>
            <td><form:input path="password" type = "password" placeholder="Password" size="30" test-id="register-password" /></td>
          </tr>
          <tr>
            <td colspan="2">
              <input type="submit" value="Submit" test-id="submit-register"/>
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
