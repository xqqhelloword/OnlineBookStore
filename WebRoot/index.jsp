<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>书城登录</title>
	<script src="jquery/jquery-2.0.3.js"></script><!-- 这个是jquery库，需自己下载 -->
	<!--  <script src="jquery/jquery-2.0.3.min.js"></script>-->
	<script>
	$(document).ready(function(){
	$("#btn").click(function(){
		$.ajax({
			type:"POST",
			url:"login?t="+new Date().getTime(),
			data:$("#loginform").serialize(),
			dataType:"json",
			cache:false,
			success:function(data){
				alert(data["result"]);
			},
			error:function(xhr){
				alert("error: "+xhr.responseText);
			}
		})
	})
})
	</script>
  </head>
<body >
<div style="background-image:url('./img/managerLogin.jpg');width:100%;height:600px;background-position:center;background-size:cover;background-repeat:no-repeat;position:relative;">
	<div style="width:60%;margin-left:20%;margin-right:20%;height:320px;position:absolute;background-color:rgba(255,255,255,0.4);top:80px;">
		<div id="title_box" style="text-align:center;">
			<h1>书城登录</h1>
		</div>
		<div id="login_box" align="center">
			<form id="loginform" style="margin-left:26%;width:74%;">
				<div style="width:100%;height:50px;">
				<div style="width:15%;float:left;">用户名:</div>
				<div style="float:left;"><input type="text" name="userAccount" id="username" style="width:230px;height:25px;border-radius:3px;border-style:none;"/></div>
				</div>
				<div style="width:100%;height:50px;">
				<div style="width:15%;float:left;">密码:</div>
				<div style="float:left;"><input type="password" name="userPassword" id="password" style="width:230px;height:25px;border-radius:3px;border-style:none;"/></div>
				</div>
				<div><input type="button" value="登录" id="btn" style="width:230px;height:25px;border-radius:3px;border-style:none;float:left;margin-left:15%;"/></div>
			</form>
		</div>
   </div>
</div>
</body>
</html>
