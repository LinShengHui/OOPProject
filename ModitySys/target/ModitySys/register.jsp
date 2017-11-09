<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/6
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<body>

    <h2>用户注册</h2>
    <form action="userAction/addUser" method="post" onsubmit="return check();">
        用户名：<input type="text" name="uname"/><br>
        密码: <input type="text" name="upwd"><br>
        重复密码: <input type="text" id="pwdtwo"><br>
        <input type="submit" value="注册">
    </form>
    <a href="index.jsp">取消</a>
</body>
</html>
<script>

    //验证重复密码
    function check(){
        if($("input[name='upwd']").val()!=$("#pwdtwo").val()){
            alert("两次密码不一样");
            return false;
        }else{
            return true;//不写此返回值也行，此时就直接提交了
        }
    }
</script>
