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
    
    <title>所有投票页面</title>
    
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
    <c:forEach items="${voteResultList }" var="voteResult">
    	<tr>
    		<td><div>${voteResult.vote.voteID }</div></td>
    		<td><div>${voteResult.vote.voteName }</div></td>
    		<c:forEach items="${voteResult.voteOptions }" var="voteOption">
    			<td><div>${voteOption.voteOptionName }</div></td>
    		</c:forEach>
    		<td><div><span><img src="images/010.gif" width="9" height="9"/></span>
    			<span>[</span><a href="deleteVote.action?voteID=${voteResult.vote.voteID }">删除</a>
    			<span class="STYLE1">]</span>
    		</div>
    		</td>
    	</tr>
    </c:forEach>
  </body>
</html>
