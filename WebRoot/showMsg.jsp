<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMsg.jsp' starting page</title>
    
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
  <br/>
    <h2 align="center">&nbsp;t${message.title }</h2>
    ${message.content }
    <div align="right">发布人ID：${message.employeeID } 发布时间：${message.publishTime }</div>
    
    <div align="left">
    	<p>回复</p>
    	<p><font color="red">${error }</font></p>
    	<form action="<%=path %>/servlet/CommitReply" method="post">
    		<textarea rows="4" cols="15" name="replyContent"></textarea>
    		<input type="hidden" name="messageID" value="${message.id }"/>
    		<input type="submit" value="提交"/>
    		<input type="reset" value="重置"/>
    	</form>
    </div>
    <c:forEach items="${requestScope.replyList }" var="reply">
    	<div>
    		${reply.content }
    		<div align="right">
    			回复人ID：${reply.id } 回复时间：${reply.replyTime }
    		</div>
    		<hr/>
    	</div>
    </c:forEach>
    <div align="center">
    	第<c:forEach varStatus="stat" begin="1" end="${page.totalPage }">
    	<a href="<%=path %>/servlet/GetMessage?messageID=${message.id }&currentPage=${stat.index }">${stat.index }</a>
    	</c:forEach>页
    </div>
  </body>
</html>
