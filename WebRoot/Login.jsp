<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
<style type="text/css">
*{
	margin: 0px;
	padding: 0px;
}
.titleb{
	width: 100%;
	height: 1280px;
	background-image: url(img/conatc.jpg);
	background-size: cover;
	position: absolute;
	color: #fff;
	font-size: 25px;
	text-align: center;
}
p{
	position: relative;
	margin: 2% auto;
}
form{
	position: absolute;
	margin: 15% auto auto 37%;
	padding-top: 20px;
	width: 500px;
	height: 250px;
	background: #fff;
	font-size: 22px;
}
input{
	width: 260px;
	height: 30px;
}
.pass{
	position: absolute;
	margin-left: 4%;
}
.sub{
	position: absolute;
	margin-left: 15%;	
	margin-top: 2%;
	width: 200px;
	height: 35px;
	font-size: 18px;
	background: #000;
	color: #fff;
}
ul{
	position: relative;
	margin: 7% auto auto 10%;
}
ul li{
	height: 60px;
	list-style-type: none;
	margin-left: 30px;
}
</style>
</head>
<body>
	<div class="titleb">
		<p>长春工业大学图书管理系统</p>
	</div>
	<form id="manager_form" action="Login" method="post">
		<ul>
			<li>用户名：<input type="text" name="username"></li>
			<li>密码：<input class="pass" type="password" name="password"></li>
			<li><input class="sub" type="submit" value="登录"></li>
		</ul>
	</form>
	
	<!-- <script type="text/javascript">
	$(function() {  
		$("#manager_form").submit(function() {
			alert($("input[type=text]").val());
			var url = "Login";
			var args = {
				"user" : $("input[type=text]").val(),
				"password" : $("input[type=password]").val(),
				"time" : new Date()
			}; 

		 	$.getJSON(url,args,function(data){
				
			}) 
			
			 /* $.ajax({    
                 type:'post',        
                 url:'s',    
                 data:$("#manager_form").serialize(),    
                 cache:false,    
                 dataType:'json',    
                 success:function(data){   
                     alert("请求成功");
                 }    
             });     */
			alert($("input[type=password]").val());
		})
	})
</script> -->
</body>
</html>
