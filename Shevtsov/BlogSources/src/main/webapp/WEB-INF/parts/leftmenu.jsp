<div class="leftmenu">
  <div class="nav">
    <ul>
      <li><a href="<c:url value="//welcome" />">Home</a></li>

      <c:choose>
        <c:when test="${sessionScope.currentUser.userName != null}">
          <li><a href="<c:url value="//logout" />">Log Out</a></li>
        </c:when>
        <c:otherwise>
          <li><a href="<c:url value="//register" />">Register</a></li>
          <li><a href="<c:url value="//login" />">Log In</a></li>
        </c:otherwise>
      </c:choose>

      <c:choose>
        <c:when test="${sessionScope.currentUser.userPrivilegeLevel == 0}">
          <li><a href="<c:url value="//addPost" />">Add new Post</a></li>
          <%--
          <li><a href="<c:url value="//addUser" />">Add new User</a></li>
          --%>
        </c:when>
      </c:choose>
      <li><a href="<c:url value="//about" />">About</a></li>

    </ul>
  </div>
</div>

