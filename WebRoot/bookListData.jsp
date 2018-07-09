<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>书籍列表json数据显示</title>
    
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
	$.ajax({
			type:"POST",
			url:"bookList?t="+new Date().getTime(),
			dataType:"json",
			cache:false,
			success:function(data){
				var info1="电子书:";
				var info2="实体书:";
				var info3="二手实体书:";
				var info4="热销书籍:"
				$.each(data["EBookList"],function(i,values){
				 info1+=values.ebookName+"||";
				});
				alert(info1);
				$.each(data["PBookList"],function(i,values){
				 info2+=values.PbookName+"||";
				});
				alert(info2);
				$.each(data["OBookList"],function(i,values){
				 info3+=values.obookName+"||";
				});
				alert(info3);
				$.each(data["SoldTopList"],function(i,values){
				 info4+=values.PbookName+"||";
				});
				alert(info4);
			},
			error:function(xhr){
				alert("error: "+xhr.responseText);
			}
	})
	})
	</script>

  </head>
  
  <body>
    <div id="dataDisplay"></div> <br>
  </body>
</html>
