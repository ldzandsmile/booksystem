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
.after{
	position: relative;
	top: 60px;
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
.blank2{
	background-color: #d9588e;
 	height: 1px;
 	width: 25%;
 	position: relative;
 	margin: 150px auto 0px auto;
}
.team {
    padding: 2em 0em;
    margin: 0px;
}
.team-main{
    position: relative;
    top: 20px;
}
.team-top {
    margin-bottom: 4em;
}
.team-top h3 {
    font-size: 2em;
    color: #EA548E;
    text-align: center;
    font-family: 'Oswald', sans-serif;
}
.team-top p {
    font-size: 1em;
    color:#929292;
    text-align: center;
}
.team-bottom {
    text-align: center;
    margin: 1em auto auto 17%;
    width: 70%; 
    padding: 0px;
}/* 
.one-two .three-four{
	width: 85%;
	margin: 0 auto;
}  */
.col-md-3{
	float: left;
	width: 40%;
	padding: 20px 40px;
	margin: 0px;
}
.team-bottom p{
	width: 100%;
	margin: 0 auto;
}
.team-bottom ul {
    padding: 0px;
    list-style: none;
    margin-top: 0.5em;
}
.team-bottom ul li {
	display: inline-block;
	margin-left: 0.2em;
}
.team-bottom ul li a {
    background: url(../images/t-icn.png)no-repeat;
    width: 25px;
    height: 25px;
    display: inline-block;
}
.team-bottom ul li a.fa {
    background-position: 0px 0px;
}
.team-bottom ul li a.tw {
    background-position: -27px 0px;
}
.team-bottom ul li a.g {
    background-position: -53px 0px;
}
.team-bottom ul li a.fa:hover {
    background-position: 0px 0px;
    opacity: 0.8;
}
.team-bottom ul li a.tw:hover {
    background-position: -27px 0px;
     opacity: 0.8;
}
.team-bottom ul li a.g:hover {
    background-position: -53px 0px;
     opacity: 0.8;
}
/* Better spacing on download options in getting started */
.bs-docs-dl-options h4 {
  margin-top: 15px;
  margin-bottom: 5px;
}
.ih-item {
  position: relative;
  -webkit-transition: all 0.35s ease-in-out;
  -moz-transition: all 0.35s ease-in-out;
  transition: all 0.35s ease-in-out;
}
.ih-item,
.ih-item * {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}
.ih-item a {
  color: #333;
}
.ih-item a:hover {
  text-decoration: none;
}
.ih-item img {
  width: 100%;
  height: 100%;
}

.ih-item.circle {
  position: relative;
  width: 220px;
  height: 220px;
  border-radius: 50%;
  margin: 0 auto;
}
.ih-item.circle .img {
  position: relative;
  width: 220px;
  height: 220px;
  border-radius: 50%;
}
.ih-item.circle .img:before {
  position: absolute;
  display: block;
  content: '';
  width: 100%;
  height: 100%;
  border-radius: 50%;
  box-shadow: inset 0 0 0 16px rgba(255, 255, 255, 0.6), 0 1px 2px rgba(0, 0, 0, 0.3);
  -webkit-transition: all 0.35s ease-in-out;
  -moz-transition: all 0.35s ease-in-out;
  transition: all 0.35s ease-in-out;
}
.ih-item.circle .img img {
  border-radius: 50%;
}
.ih-item.circle .info {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
  border-radius: 50%;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
}
/*--*/

.ih-item.circle.effect5 {
  -webkit-perspective: 900px;
  -moz-perspective: 900px;
  perspective: 900px;
}
.ih-item.circle.effect5.colored .info .info-back {
  background: #1a4a72;
  background: rgba(26, 74, 114, 0.6);
}
.ih-item.circle.effect5 .info {
  -webkit-transition: all 0.35s ease-in-out;
  -moz-transition: all 0.35s ease-in-out;
  transition: all 0.35s ease-in-out;
  -webkit-transform-style: preserve-3d;
  -moz-transform-style: preserve-3d;
  -ms-transform-style: preserve-3d;
  -o-transform-style: preserve-3d;
  transform-style: preserve-3d;
}
.ih-item.circle.effect5 .info .info-back {
  visibility: hidden;
  border-radius: 50%;
  width: 100%;
  height: 100%;
  background: #333333;
  background: rgba(0, 0, 0, 0.6);
  -webkit-transform: rotate3d(0, 1, 0, 180deg);
  -moz-transform: rotate3d(0, 1, 0, 180deg);
  -ms-transform: rotate3d(0, 1, 0, 180deg);
  -o-transform: rotate3d(0, 1, 0, 180deg);
  transform: rotate3d(0, 1, 0, 180deg);
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
}
.ih-item.circle.effect5 .info h3 {
    color: #fff;
    position: relative;
    letter-spacing: 0px;
    font-size: 1.3em;
    margin: 0 30px;
    padding: 99px 0 0 0;
    height: 110px;
    font-family: 'Oswald', sans-serif;
}
.ih-item.circle.effect5 .info p {
  color: #bbb;
  padding: 10px 5px;
  font-style: italic;
  margin: 0 30px;
  font-size: 12px;
  border-top: 1px solid rgba(255, 255, 255, 0.5);
}
.ih-item.circle.effect5 a:hover .info {
  -webkit-transform: rotate3d(0, 1, 0, -180deg);
  -moz-transform: rotate3d(0, 1, 0, -180deg);
  -ms-transform: rotate3d(0, 1, 0, -180deg);
  -o-transform: rotate3d(0, 1, 0, -180deg);
  transform: rotate3d(0, 1, 0, -180deg);
}
.ih-item.circle.effect5 a:hover .info .info-back {
  visibility: visible;
}
.foot{
	width: 100%;
	height: 70px;
	background: #000;
	opacity: 0.7;
	position: relative;
	top: 850px;
}
.form {
	background-color: #eeeeee;
	position: absolute; 
	width: 400px;
	height: 270px;
	z-index: 3;
	margin-top: -600px;
	margin-left: 39%;
	opacity: 0.9;
	line-height: 35px;
	font-size: 16px;
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
	margin: 20px auto auto 23%;
}

.one{
	margin-left: 16px;
}
.two{
	margin-left: 32px;
}
.four{
	margin: 20px 80px 0px 35px;
}
#manager_id{
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
	</div>
	<button id="addManager">添加管理员</button>
	<div class="blank"></div>

<!-- 导航栏	 -->
	<div class="fixed">
		<div calss="listboder">
			<div id="navbar" class="navbar-collapse collapse">
				<nav class="cl-effect-1">
					<ul class="navbar-nav">
					<li id="list_one" class="list_main"><a href="#">管理员设置</a>
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
	
<!-- 表格 -->
	<div class="after">
		<p>AdministratorsManager</p>
		<div class="after-late">
			<div class="after-img">
				<img src="img/p8.jpg">
			</div>
			<table>
				<tr>
					<td class="big" id="manager_id">序号</td>
					<td class="big">序号</td>
					<td class="big">用户名</td>
					<td class="big" colspan="2">删除/更新</td>
				</tr>
			</table>
		</div>
	</div>

<!-- 图 -->		
<div class="blank2"></div>
<div class="team">
		<div class="team-main">
			<div class="team-top wow fadeInDown" data-wow-delay="0.3s">
				<h3>文学巨匠</h3>
				<span class="heading-line"> </span>
				<p>Great masters of literature.</p>
			</div>
			<div class="team-bottom wow fadeInRight" data-wow-delay="0.3s">
				<div class="one-two">
				  <div class="col-md-3 team-grids">
				    <!-- normal -->
					  <div class="ih-item circle effect5">
						    <a href="#">
						        <div class="img"><img src="img/76e9930ff9d0ab9361afe1cf0f8a52c5.jpg" 
						        alt="img" class="img-responsive">
						        </div>
						        <div class="info">
						          <div class="info-back">
						            <h3>Shakespeare</h3>		          
						          </div>			          
						        </div>
						    </a>
					  </div>
				        <div class="team-bottom">
				        	  <p>威廉·莎士比亚，华人社会常尊称为莎翁，清末民初鲁迅在《摩罗诗力说》称莎翁为“狭斯丕尔”
								是欧洲文艺复兴时期最重要、最伟大的作家、戏剧家，全世界最卓越的文学家之一。</p>
				        	  <ul>
				        	  	<li><a href="#" class="fa"> </a></li>
				        	  	<li><a href="#" class="tw"> </a></li>
				        	  	<li><a href="#" class="g"> </a></li>
				        	  </ul>
				        </div>
				        
				    <!-- end normal -->
				   </div>
				 <div class="col-md-3 team-grids">
				   <!-- normal -->
					  <div class="ih-item circle effect5">
						    <a href="#">
						        <div class="img"><img src="img/822a49bbe583497d4ed383af2383767a.jpg" 
						        alt="img" class="img-responsive">
						        </div>
						        <div class="info">
						            <div class="info-back">
						              <h3>Dickens</h3>		           	            
						            </div>
						        </div>
						    </a>
					   </div>
				        <div class="team-bottom">
				        	  <p>查尔斯·狄更斯，英国作家。主要作品有《大卫·科波菲尔》、《匹克威克外传》、《雾都孤儿》 、
				        	  《老古玩店》、《艰难时世》、《我们共同的朋友》、《双城记》等。</p>
				        	  <ul>
				        	  	<li><a href="#" class="fa"> </a></li>
				        	  	<li><a href="#" class="tw"> </a></li>
				        	  	<li><a href="#" class="g"> </a></li>
				        	  </ul>
				        </div>
				    <!-- end normal -->		 
				  </div>
			  </div>
			  <div class="three-four">
				  <div class="col-md-3 team-grids">
				    <!-- normal -->
				        <div class="ih-item circle effect5">
				        	<a href="#">
						        <div class="img"><img src="img/8f57bbf6e144ac3b5425e2bd6eb4fe90.jpg" 
						        alt="img" class="img-responsive">
						        </div>
						        <div class="info">
						            <div class="info-back">
						                 <h3>鲁迅</h3>			       
						            </div>
						        </div>
					        </a>
					    </div>
					    <div class="team-bottom">
					        <p>鲁迅，著名文学家、思想家，五四新文化运动的重要参与者，中国现代文学的奠基人。毛泽东曾评价：
					        “鲁迅的方向，就是中华民族新文化的方向。”</p>
					        <ul>
					        	<li><a href="#" class="fa"> </a></li>
					        	<li><a href="#" class="tw"> </a></li>
					        	<li><a href="#" class="g"> </a></li>
					        </ul>
					    </div>
				    <!-- end normal -->
				  </div>
				   <div class="col-md-3 team-grids">
				    <!-- normal -->
					    <div class="ih-item circle effect5">
						    <a href="#">
						        <div class="img"><img src="img/46bbecca05c89c2bb5e82ffa1cfe4991.jpg" 
						        alt="img" class="img-responsive">
						        </div>
							    <div class="info">
							        <div class="info-back">
							             <h3>Balzac</h3>		           
							        </div>
							    </div>
						    </a>
					    </div>
					    <div class="team-bottom">
					        <p>奥诺雷·德·巴尔扎克，法国小说家，被称为“现代法国小说之父”，生于法国中部图尔城一个中产
					        	 者家庭，1816年入法律学校学习.</p>
					        <ul>
					        	<li><a href="#" class="fa"> </a></li>
					        	<li><a href="#" class="tw"> </a></li>
					        	<li><a href="#" class="g"> </a></li>
					        </ul>
					    </div>
					<!-- end normal -->			 
				   </div>
				 </div>
			</div>
		</div>
</div>

<div class="foot"></div>
		
<!-- 注册弹窗 -->
	<div class="form hide">
		<p>管理员注册</p><hr>
		<form>
			用户名：<input type="text" name="manager_name" class="one"><br> 
			密码：<input type="password" name="manager_password" class="two"><br>
			确认密码：<input type="password" name="manager_repassword" class="three"><br>
			<br>
			<input type="submit" value="确定" class="four">
			<button class="five">取消</button>
		</form>
	</div>
	
	<script type="text/javascript" src="js/AdministratorsManager.js"></script>
</body>
</html>
