<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/6
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>完善资料</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<body>
        <div>

            <h2>完善个人资料</h2>
            账号：${userInfo.uname}<br/>
            <form action="${pageContext.request.contextPath}/userAction/addUserInfo" method="post" enctype="multipart/form-data">
                用户姓名：<input type="text" name="iname"><br/>
                性别：<input type="radio" name="isex" value="男" checked/>男
                <input type="radio" name="isex" value="女"/>女 <br/>
                联系电话：<input type="text" name="iphone"><br/>
                出生日期：<input type="date" name="itime"  /><br/>
                邮寄地址：<input type="text" name="iemalisite"><br/>
                用户图像：<input type="file" name="ufile">
                <input type="hidden" name="user.uno" value="${userInfo.uno}" >
                <input type="submit" value="确认">
            </form>
        </div>
</body>
</html>
<script>

</script>