<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/6
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${param.message==1}">
    <p style="color: green">添加成功！</p>
</c:if>
<c:if test="${param.message==0}">
    <p style="color: red">添加失败！</p>
</c:if>

<h2>添加商品</h2>
<form action="${pageContext.request.contextPath}/cargoAction/addCargo" enctype="multipart/form-data" method="post">
    商品名称: <input type="text" name="cname"><br/>
    价格： <input type="text" name="cprice"><br/>
    生产日期: <input type="text" name="ctime"><br/>
    生产商: <input type="text" name="cproducer"><br/>
    产品状态: <input type="radio" name="cstate" value="1" checked>上架
    <input type="radio" name="cstate" value="0" >下架<br/>
    商品图片: <input type="file" name="imgfile"><br/>
    <input type="submit" value="添加">
</form>
<a href="main.jsp">查看商品</a>
</body>
</html>
