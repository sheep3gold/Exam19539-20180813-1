<%--
  Created by IntelliJ IDEA.
  User: yx
  Date: 2018/8/13
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello
<form action="<%=request.getContextPath()%>/showFilm" method="post" name="showFilmForm">
<input type="submit" name="submit">
</form>
</body>
</html>
