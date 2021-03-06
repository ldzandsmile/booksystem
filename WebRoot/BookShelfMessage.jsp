<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<!-- <script type="text/javascript" src="js/SecondList.js"></script> -->
<link rel="stylesheet" type="text/css" href="css/index.css">
<style type="text/css">
*{
	margin:0px;
	padding:0px;
}
.hide {
	display: none;
}
a {
  text-decoration: none;
}
a:hover {
  transition: 0.5s all;
  -webkit-transition: 0.5s all;
  -moz-transition: 0.5s all;
  -o-transition: 0.5s all;
  text-decoration:none;
}
.banner{
	color: #fff;
	text-align: center;
	height: 600px;
	background-attachment: scroll;
	background-clip: border-box;
	background-color: rgba(0, 0, 0, 0);
	background-image: url("file:///C:/Users/Ldj/Desktop/cpts_918_bpv/images/bann3.jpg");
	background-origin: padding-box;
	font-family:serif,sans-serif,fantasy,cursive
 }
.back{
 	width: 100%;
 	height: 100%;
 	float: left;
 }
.banner-down{
 	position: absolute;
 	margin: 250px auto auto 28%;
 }
.bann-line{
 	background-color: #fff;
 	height: 2px;
 	width: 340px;
 	position: absolute;
 	left: 32%;
 	margin: 10px 0px;
 }
.banner-down p{
 	position:relative;
	top: 25px;
 	line-height: 30px;
 	font-size: 15px;
  }
.fixed{
  	position: fixed;
	top: 0;
	width: 100%;
	height: 50px;
	margin: 0 auto;
	left:0;
	z-index: 999;
	background: #fff;
	opacity: 0.7;
}
.listborder{
	padding: 2em 0em 1.6em 0em;
    margin-top: 0px !important;
    line-height: 36px;
    border-bottom: 1px solid #AFAFAF;
}
#navbar {
    margin-bottom: 0px !important;   
    min-height: 0px !important;   
}
ul > li > a {
    padding: 10px 15px !important;
}
ul{
    float: right !important;
	margin-top: 0.6em;
	margin-right: 4.5em;
}
ul li{
    font-family: 'Oswald', sans-serif;
    font-size: 18px;
    line-height: 1.5em;
    list-style-type: none;
    float: left;
    font-weight: bold;
}
a:hover{
	color: #bd366c;
}
a:visited{
	color: #EA548E;
}
#addManager{
	background-color: #292426;
	color: #fff;
	position: absolute;
	margin-top: 20px;
	position: relative;
	float: right;
	margin-right: 20%;
	width: 130px;
	height: 30px;
	border-radius: 40px;
	border-style: none;
}
.blank{
	background-color: #3b3d41;
 	height: 1px;
 	width: 75%;
 	position: relative;
 	margin: 70px auto 0px auto;
}

.search{
	background: #e8e8e9;
	height: 68px;
	position: relative;
	top: -70px;
}
.bookname{
	float: right;
	margin-right: 12.5%;
	margin-top: 20px;
	font-size: 20px;
}
select{
	height: 30px;
	width: 70px;
	font-size: 17px;
}
input{
	height: 30px;
	width: 190px;
	font-size: 20px;
}
button{
	height: 30px;
	width: 90px;
	font-size: 17px;
	background: #fff;
	color: #000;
}
.after{
	position: relative;
	top: 0px;
	width: 60%;
	margin: 0 auto;
	text-align: center;
}
.after-late{
	position: absolute;
	top: 30px;
	height: 250px;
}
.after p{
	color: #8a8a90;
	font-size: 40px;font: italic 2em Georgia, serif;
}
.after-img img{
	width: 30%;
	float: left;
}
.after-late{
	position: relative;
	top: 35px;
}
table{
	position: absolute;
	width: 67%;
	margin-left: 33%;
	padding: 0;
	font-size: 20px;
	text-align: center;
	color: #fff;
	background: #3b3d41;
	border-collapse: collapse;
}
table tr td{
	height: 40px;
	border: 1px solid #e0dfdf;
}
table a{
	color: #fff;
}
.la{
	position: absolute;
	margin-top: 270px;
	margin-left: 63%;
}


.hide {
	display: none;
}
.foot{
	width: 100%;
	height: 70px;
	background: #000;
	opacity: 0.7;
	position: relative;
	top: 380px;
}
.background {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background: rgba(0, 0, 0, .5);
	z-index: 2;
}
.form {
	background-color: #eeeeee;
	position: absolute; 
	width: 400px;
	height: 270px;
	z-index: 3;
	margin-top: -250px;
	margin-left: 39%;
	opacity: 0.9;
	line-height: 40px;
}
.form p{
	text-align: center;
	color: #fff;
	z-index: 5;
	width: 400px;
	height: 35px;
	background: #000;
}
form{
	width: 280px;
	margin: 50px auto auto 23%;
	
}
.one{
	margin-left: 0px;
	width: 80%;
}
.two{
	margin-left: 15px;
	width: 80px;
	margin-top: 30px;
	padding: 0 5px;
	font-size:17px;
}
.three{
	margin-left: 15px;
	width: 80px;
	margin-top: 30px;
	padding: 0 5px;
}
#bookshelf_id{
	visibility : hidden;
	display : none;
}
</style>
</head>

<body>
		<!-- 主图 -->
	<div class="banner">
		<div class="back" style="background-image:url(img/bann3.jpg)"></div>
			<div class="banner-down" data-wow-delay="0.3s">
				<h1>长春工业大学图书管理系统</h1>
				<div class="bann-line"> </div>
				<p>长春工业大学图书管理系统功能完善，经济适用，自带书目库，支持一卡通；<br>
				加快书籍清点速度，实现读者自助借还书服务，提高图书流通效率，更有效发挥图书的信息传递功能，提高图书馆智能化管理水平。</p>
			</div>
	</div><!-- 
	<button id="addManager">添加管理员</button> -->
	<div class="blank"></div>

<!-- 导航栏	 -->
	<div class="fixed">
		<div calss="listboder">
			<div id="navbar" class="navbar-collapse collapse">
				<nav class="cl-effect-1">
					<ul class="navbar-nav">
					<li id="list_one" class="list_main"><a href="AdministratorsManager.jsp">管理员设置</a>
					</li>
					<li id="list_two" class="list_main"><a href="BookManager.jsp">图书管理</a>
					</li>
					<li id="list_four" class="list_main"><a href="BookShelfMessage.jsp">书架设置</a>
					</li>
					<li id="list_three" class="list_main">
						<a href="BookBorrow.jsp" class="BorrowMessage">借阅记录</a>
					</li>
					</ul>
				</nav>
				<script>
		$(document).ready(function() {
			 var navoffeset=$(".header").offset().top;
			 $(window).scroll(function(){
				var scrollpos=$(window).scrollTop(); 
				if(scrollpos >=navoffeset){
					$(".header").addClass("fixed");
				}else{
					$(".header").removeClass("fixed");
				}
			 });
			 
		});
				</script>
			</div>
		</div>	
	</div>

<!-- 搜索 -->
	<div class="search">
		<div class="bookname">
			查询： <select>
				<option>类别</option>
			</select>
			<input type="text" id="select">
			<button id="addBookShelf">添加分类</button>
		</div>
	</div>
		
<!-- 表格 -->

	<div class="after">
		<p>BookShelfMessage</p>
		<div class="after-late">
			<div class="after-img">
					<img src="img/p6.jpg">
			</div>
			<table>
				<tr>
					<td id="bookshelf_id">类别编号</td>
					<td>序号</td>
					<td>类别</td>
					<td>删除</td>
					<td>更新</td>
				</tr>
			</table>
		</div>
		<div class="la">
			<lable id="last">上一页</lable><lable id="next">下一页</lable>
		</div>
	</div>
	<div class="foot"></div>

<!-- 添加弹窗 -->
	<div class="hide middle form">
		<p>类别添加</p><hr>
		<form>
			<span>类别：</span></br>
			<input type="text" name="bookshelf_type" class="one"><br> 
			<input  type="submit" value="确定" class="two">
			<button class="three">取消</button>
		</form>
	</div>
	
	<script type="text/javascript" src="js/BookShelfMessage.js"></script>
</body>
</html>
