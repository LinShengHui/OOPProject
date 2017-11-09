<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/6
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请先登陆</title>
</head>
<body>
${message}

${sessionScope['org.springframework.web.servlet.support.SessionFlashMapManager.FLASH_MAPS'][0]['message']}
    <h2>用户登陆</h2>
    <form action="${pageContext.request.contextPath}/userAction/userLogin" method="post">
        用户名:<input type="text" name="uname"><br/>
        密码:<input type="text" name="upwd"><br/>
        <input type="submit" value="登陆"> <input type="button" value="用户注册" onclick="register()">
    </form>
</body>
</html>
<script>
    function  register() {
        location.href="register.jsp";
    }
</script>
