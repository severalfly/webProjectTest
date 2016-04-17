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
    
    <title>投票首页</title>
    
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
    	<p class="style2">${voteResult.vote.voteName }</p>
    	<form action="doVote.action" method="post">
    		<p>
    			<c:forEach items="${voteResult.voteOptions}" var="voteOption">
    				<input type="radio" name="voteOptionID" value="${voteOption.voteOptionID }"/>${voteOption.voteOptionName }<br>
    			</c:forEach>
    			<input type="radio" name="voteOptionID" value="0"/>其他<br/>
    			<input type="text" name="otherOption"/>
    			<input type="hidden" name="voteID" value="${voteResult.vote.voteID }"/>
    			<input type="hidden" name="channelID" value="${voteResult.vote.channelID }"/>
    			<a href="voteResult?voteID=${voteResult.vote.voteID }">查看投票结果</a>
    			 
    			</p>
    			<p>
    			<input type="submit" value="投票"/>
    			<input type="reset" value="重置"/>
    			</p>
    			
    	</form>
    </c:forEach>
    <c:if test="${empty voteResultList}">
    	没有任何投票内容！！！
    </c:if>
  
  </body>
</html>
