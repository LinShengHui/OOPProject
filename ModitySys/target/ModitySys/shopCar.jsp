<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.modity.entity.Cargo" %>
<%@ page import="com.modity.entity.Carltem" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/7
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<body>
    <form action="" id="seleCargo">
    <table border="1">
        <tr>
            <td>商品编号</td>
            <td>商品名字</td>
            <td>商品图片</td>
            <td>商品数量</td>
        </tr>
        <c:forEach var="bb" items="${car}" varStatus="ids">
            <tr>
                <input type="hidden" name="cno" value="${bb.value.cargo.cno}">
                <td>${ids.count}</td>
                <td>${bb.value.cargo.cname}</td>
                <td><input type="image" src="${pageContext.request.contextPath}/images/${bb.value.cargo.curl}" width='80px' height='50px'/></td>
                <td>${bb.value.number}</td>
                <input type="hidden" name="number" value="${bb.value.number}" >
            </tr>
        </c:forEach>
    </table>
        <input type="button" value="提交订单" onclick="doIndent()">
    </form>
    <a href="main.jsp">返回继续购买</a>

</body>
</html>
<script>
        function doIndent(){
            var param = $("#seleCargo").serialize();
            $.post("carAction/docarItem",param,function () {

            })
        }
</script>
