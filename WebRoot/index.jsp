<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录</title>
	<script src="jquery/jquery-2.0.3.js"></script>
	<script src="jquery/jquery-2.0.3.min.js"></script>
	<script>
	$(document).ready(function(){
	$("#loginBtn").click(function(){
	$.ajax({
				type:"POST",
				url:"login?t="+new Date().getTime(),
				data:$("#loginform").serialize(),
				cache:false, 
				dataType:"json",
				success:function(data){
				alert(data.result);
				},
				error:function(xhr){
					alert("error:"+xhr.resoponseText);
				}
		})
	})
	})
	</script>
  </head>
  <body>
    <Form id="loginform" >
   账号: <input type="text" name="userAccount" ><br>
   密码: <input type="password" name="userPassword"><br>
   <input type="button" value="提交" id="loginBtn">
    </Form>
  </body>
</html>
