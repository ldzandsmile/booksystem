<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/SecondList.js"></script>
    <link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  
  <body>
    <div class="list">
    	<ul id="list_one" class="list_main">信息设置</ul>
    	<ul id="list_two" class="list_main">图书借阅</ul>
    	<ul id="list_three" class="list_main"><a href="BorrowMessage.jsp">借阅记录</a></ul>
    </div>
    
    <div>
    	欢迎进入图书馆管理系统<br>
    </div>
  </body>
</html>