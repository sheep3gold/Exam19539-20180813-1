<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page import="com.hand.entity.Film" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: yx
  Date: 2018/8/13
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function getId(id) {
            var s=document.getElementsByName("aa")
        }
    </script>
</head>
<body>
<%
    Map<Integer,Film> filmMap= (Map<Integer, Film>) request.getAttribute("myfilm");
//    System.out.println(filmMap);
%>
<div>
    <p align="center" >所有的电影列表</p>
    <form action="<%=request.getContextPath()%>/addFilmweb" method="post" name="addFilmweb" align="center">
        <input type="submit" name="submit" value="增加">
    </form>
    <br>
</div>

<div>
<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
    <%--<c:forEach items="${list}" var="item">--%>
        <%--<tr>--%>
            <%--<td>${film.film_id}</td>--%>
            <%--<td>${film.title}</td>--%>
            <%--<td>${film.description}</td>--%>
            <%--<td>${film.name}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>


<%
    Iterator<Integer> iter = filmMap.keySet().iterator();
    while (iter.hasNext()){
        int key=iter.next();
        Film film=filmMap.get(key);
        %>
<tr>
<%
        out.print("<td>"+film.getFilm_id()+"</td>"+"<td>"+film.getTitle()+"</td>"
                +"<td>"+film.getDescription()+"</td>"+"<td>"+film.getLanguage()+"</td>"
        );

        %>
   <td>
       <form action="<%=request.getContextPath()%>/editFilm" method="post" id ="formID" name="bb">
           <%--<%System.out.println(film.getFilm_id()) ;%>--%>
           <%--<% int id=film.getFilm_id(); %>--%>
           <input type="hidden" value='<%=film.getFilm_id()%>' name="aa">
           <input type="submit" value="修改" >
           <%--<button onclick="getId(this.id)"></button>--%>

   </form>
   </td>
    <td>
        <form action="<%=request.getContextPath()%>/deleteFilm" method="post" name="cc">
            <input type="hidden" value='<%=film.getFilm_id()%>' name="dd">
            <input type="submit" value="删除" >
            <%--<button id="bid" onclick="getId(this.id)" name="<%film.getFilm_id();%>">删除</button>--%>
        </form>
    </td>
    <%
    }
%>
</tr>
</table>
</div>
</body>
</html>
