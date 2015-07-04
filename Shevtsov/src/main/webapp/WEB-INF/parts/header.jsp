<%@ page import="demo.Users.User" %>
<%@ page session="true" %>
<div id="header">

    <div class="title">
      <c:choose>
        <c:when test="${sessionScope.currentUser.userName != null}">
          Hi ${sessionScope.currentUser.userName}
          <br />
          <a href="<c:url value="//logout" />">Log out</a>
        </c:when>
        <c:otherwise>
          Please <a href="<c:url value="//login" />">Log In</a>
        </c:otherwise>
      </c:choose>
  <h1> Web Blog</h1>
</div>
</div>