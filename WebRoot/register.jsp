<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="jquery/jquery-2.0.3.js"></script>
	<script>
	$(document).ready(function(){
	$("#btn").click(function(){
		$.ajax({
			type:"POST",
			url:"register?t="+new Date().getTime(),
			data:$("#registerform").serialize(),
			dataType:"json",
			cache:false,
			success:function(data){
				alert(data["RegisterResult"]);
			},
			error:function(xhr){
				alert("error: "+xhr.responseText);
			}
		})
	})
})
	</script>
  </head>
  
  <body>
    <div style="background-image:url('./img/managerLogin.jpg');width:100%;height:600px;background-position:center;background-size:cover;background-repeat:no-repeat;position:relative;">
	<div style="width:60%;margin-left:20%;margin-right:20%;height:320px;position:absolute;background-color:rgba(255,255,255,0.4);top:80px;">
		<div id="title_box" style="text-align:center;">
			<h1>书城注册</h1>
		</div>
		<div id="login_box" align="center">
			<form id="registerform" style="margin-left:26%;width:74%;height:auto">
				<div style="width:100%;height:50px;">
					<div style="width:15%;float:left;">用户名:</div>
					<div style="float:left;"><input type="text" name="userName" id="username" style="width:230px;height:25px;border-radius:3px;border-style:none;"/></div>
				</div>
				<div style="width:100%;height:50px;">
					<div style="width:15%;float:left;">密码:</div>
					<div style="float:left;"><input type="password" name="userPassword" id="password" style="width:230px;height:25px;border-radius:3px;border-style:none;"/></div>
				</div>
				<div style="width:100%;height:50px;">
					<div style="width:15%;float:left;">账号:</div>
					<div style="float:left;"><input type="text" name="userAccount" id="account" style="width:230px;height:25px;border-radius:3px;border-style:none;"/></div>
				</div>
				<div style="width:100%;height:50px;">
					<div style="width:15%;float:left;">电话:</div>
					<div style="float:left;"><input type="text" name="userPhone" id="phone" style="width:230px;height:25px;border-radius:3px;border-style:none;"/></div>
				</div>
				<div style="width:100%;height:50px;">
					<div style="width:15%;float:left;">地址:</div>
					<div style="float:left;"><input type="text" name="userAddress" id="address" style="width:230px;height:25px;border-radius:3px;border-style:none;"/></div>
				</div>
				<div><input type="button" value="注册" id="btn" style="width:230px;height:25px;border-radius:3px;border-style:none;float:left;margin-left:15%;"/></div>
			</form>
		</div>
   </div>
</div>
  </body>
</html>
