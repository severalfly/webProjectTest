<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'publishNewMsg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <a href="<%=path %>/index.jsp">首页</a>
    <div id="messageBox">
    	<p><font color="red">${requestScope.error }</font></p>
    	<form action="MsgPublish" method="post">
    		<p>消息标题:<input type="text" name="title" size="50"/></p>
    		<p>消息内容：</p>
    		<p><textarea name="content" rows="5" cols="3"></textarea>
    		<p><input type="submit" value="提交"/></p>
    		<p><input type="reset" value="重置"/></p>
    	</form>
    </div>
  </body>
</html>
