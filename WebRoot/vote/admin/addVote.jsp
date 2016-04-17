<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加投票</title>
    
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
    <form action="addVote.action" method="post" name="addForm"> 
    	<br>选择投票频道：<select name="channel">
    		<option value="1">NBA</option>
    		<option value="1">CBA</option>
    		<option value="1">足球世界杯</option>
    		<option value="1">中超</option>
    		<option value="1">英超</option>
    		<option value="1">F1</option>
    	</select>
    	<br/>
    	请输入投票名称：<input type="text" name="voteName"/><br/>
    	<div id="voteOptionList">
    		选项1 名称：<input type="text" name="voteOption"/><br/>
    		选项2 名称：<input type="text" name="voteOption"/><br/>
    		选项3 名称：<input type="text" name="voteOption"/><br/>
    	</div>
    	<input type="button" value="新增投票选项" onclick="addVoteOption()"/>
    	<input type="submit" value="发布"/>
    	<input type="reset" value="重置"/>
    </form>
  </body>
  
 <script type="text/javascript">
 	var i = 4;
 	function addVoteOption()
 	{
 		var voteP = document.getElementById("voteOptionList");
 		var inputText = document.createTextNode("选项" + (i++) + " 名称：");
 		voteP.appendChild(inputText);
 		var inputP = document.createElement("input");
 		inputP.type="text";
 		inputP.name="voteOption";
 		voteP.appendChild(inputP);
 		var brP = document.createElement("br");
 		alert("haha");
 		voteP.appendChild(brP);
 	}
 </script>
</html>
