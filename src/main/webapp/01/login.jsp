<%--
  Created by IntelliJ IDEA.
  User: yx
  Date: 2018/8/13
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆页面</title>
    <style type="text/css">
        body{
            color:#000;

            margin:20px auto;
        }
    </style>
    <script type="text/javascript">
        function check(form) {
            if(document.forms.loginForm.value==""){
                alert("请输入用户名！");
                document.forms.loginForm.uname.focus();
                return false;
            }

        }
    </script>
</head>
<body>
<form action="<%=request.getContextPath()%>/checkCustomerServlet" method="post" name="loginForm">
    <table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
        <tr>
            <td colspan="2" align="center" bgcolor="#EBEBEB">用户登陆</td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="uname"/></td>
        </tr>
        <%--<tr>--%>
            <%--<td>密码：</td>--%>
            <%--<td><input type="password" name="upwd"/></td>--%>
        <%--</tr>--%>
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
