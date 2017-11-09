<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/6
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<body>
    <div style="float: right;">
        欢迎光临${userName}
    </div>

        <a href="addCargo.jsp">添加商品</a>
    <div>
        <form id="cargoRsg">
            商品名称：<input type="text" name="rsg"> 价格: <input type="text" name="rsg">
            <input type="button" value="查询" onclick="doselectCargo()">
        </form>
        <table border="1" id="tab" >
            <tr>
                <td>商品名称</td>
                <td>价格</td>
                <td>图片</td>
                <td>管理</td>
            </tr>
        </table>
    </div>

    <div id="showcargo" style="width: 500px; height: 300px; border: 1px ridge red; position: absolute;left: 400px; top: 50px; display: none;">
        <span onclick="closeCargo()" style="float: right">关闭</span>
        <div id="cargoInfo"> </div>
    </div>
</body>
</html>
<script>
    //初始化页面数据
    function loadData(param){
        var param = $("#cargoRsg").serialize();
     $.post("cargoAction/findCargoList",param,function(data){
         $("#tab tr:not(:first)").remove();
        $.each(data,function(i,v){
           var tr = "<tr>";
               tr+="<td>"+v.cname+"</td>";
               tr+="<td>"+v.cprice+"</td>";
               tr+="<td><input type='image' src='${pageContext.request.contextPath}/images/"+v.curl+"' width='80px' height='50px'/>" +
                   "</td>";
               tr+="<td><a href='javascript:cargoInfo("+v.cno+")'>详细信息</a>|<a href='${pageContext.request.contextPath}/carAction/addCar?Cargo.cno="+v.cno+"&number=1'>加入购物车</a></td>";
               tr+="<tr/>"
            $("#tab").append(tr);
        })
     },"JSON")
    }

    //条件查询
    function doselectCargo(){
        loadData();
    }

    //查看商品详细信息
    function cargoInfo(cno){
        $("#showcargo").show();
        $("#cargoInfo table").remove();
        $.post("cargoAction/findCargo","cno="+cno,function(v){
                var table = "<table border='1'>";
                table+="<tr><td>商品名</td><td>"+v.cname+"</td></tr>";
                table+="<tr><td>图片</td><td><input type='image' src='${pageContext.request.contextPath}/images/"+v.curl+"' width='80px' height='50px'/></tr>";
                table+="<tr><td>价格</td><td>"+v.cprice+"</td></tr>";

            var newTime = new Date(v.ctime); //就得到普通的时间了
            var cDate = newTime.getFullYear() + "年"+ (newTime.getMonth() + 1) +"月"+ newTime.getDate() +"日";
            table+="<tr><td>生产日期</td><td>"+cDate+"</td></tr>";
                table+="<tr><td>生产商</td><td>"+v.cproducer+"</td></tr>";
                var cstate = v.cstate;
                 table+="<tr><td>状态</td><td>"+((cstate==1)?'上架':'下架')+"</td></tr>";
                table+="<tr><td><form method='post' action='carAction/addCar'>数量：<input type='text' name='number' size='5' value='1'>" +
                    "<input type='hidden' name='Cargo.cno' value='"+v.cno+"'/><input type='submit' value='加入购物车'></form></td></tr>";
                    table+="</table>";

                    $("#cargoInfo").append(table);

        },"json")

    }

    //初始化页面
    window.onload=loadData;

    //关闭详细信息层
    function closeCargo(){
        $("#showcargo").hide();
    }

</script>
