<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <div id="employee">
    	<c:choose>
    		<c:when test="${empty sessionScope.employee }">
    			没有进行身份验证，
    			<br/>
    			<a href="<%=path %>/servlet/StatusRecognise">身份识别</a>
    		</c:when>
    		<c:otherwise>
    			<ul>
    				<li>员工编号：${employee.id }</li>
    				<li>员工姓名：${employee.name }</li>
    				<li>员工性别：${employee.sex }</li>
    				<li>出生日期：${birth }</li>
    				<li>办公室电话：${phone }</li>
    				<li>地址：${place }</li>
    				<li>管理层领导：${employee.lead?'是':'否' }</li>
    			</ul>
    		</c:otherwise>
    	</c:choose>
    </div>
  </body>
</html>
