<%@ page import="demo.Users.User" %>
<%@ page session="true" %>
<div id="header">

      <div class="title">
      <c:choose>
        <c:when test="${sessionScope.currentUser.userName != null}">
          Hi <span id="username">${sessionScope.currentUser.userName}</span>,  <span id="top-logout"><a href="<c:url value="//logout" />">Log out</a> </span>
        </c:when>
        <c:otherwise>
          Please <span id ="top-login"><a href="<c:url value="//login" />">Log In</a></span>
        </c:otherwise>
      </c:choose>
        <h1> Web Blog</h1>
      </div>
</div>