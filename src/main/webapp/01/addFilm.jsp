<%--
  Created by IntelliJ IDEA.
  User: yx
  Date: 2018/8/13
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function check(form) {
            if(document.forms.addFilm.value==""){
                alert("请输入title!");
                document.forms.addFilm.title.focus();
                return false;
            }
            if(document.forms.addFilm.description.value==""){
                alert("请输入description！");
                document.forms.addFilm.description.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<form action="<%=request.getContextPath()%>/addFilm" method="post" name="addFilm">
    <table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
        <tr>
            <td colspan="2" align="center" bgcolor="#EBEBEB">添加电影</td>
        </tr>
        <tr>
            <td>title：</td>
            <td><input type="text" name="title"/></td>
        </tr>
        <tr>
        <td>description：</td>
        <td><input type="text" name="description"/></td>
        </tr>

        <tr>
            <td>language：</td>
            <td>
                <select name="language">
                <option value="English">English</option>
                <option value="Italian">Italian</option>
                <option value="Japanese">Japanese</option>
                <option value="Mandarin">Mandarin</option>
                <option value="French">French</option>
                <option value="German">German</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="centet">
                <input type="submit" name="submit" onclick="return check(this)"/>
                <input type="reset" name="reset"/>
            </td>
            <td></td>
        </tr>
    </table>

</form>
</body>
</html>
