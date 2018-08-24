<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
/* #addManager{
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
} */
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
	position: absolute;
	top: 740px;
	width: 100%;
	margin: 0 auto;
	text-align: center;
}
.after p{
	color: #8a8a90;
	font-size: 40px;font: italic 2em Georgia, serif;
}
table{
	position: absolute;
	width: 70%;
	padding: 0px;
	margin-top: 35px;
	margin-left: 15%;
	font-size: 20px;
	text-align: center;
	color: #fff;
	background: #3b3d41;
	border-collapse: collapse;
}
table tr td{
	height: 40px;
	border: 1px solid #e0dfdf;
	padding: 0px 15px;
}
table a{
	color: #fff;
}
.la{
	position: absolute;
	margin-top: 550px;
	margin-left: 46%;
}


.blank2{
	background-color: #d9588e;
 	height: 1px;
 	width: 25%;
 	position: relative;
 	margin: 650px auto 0px auto;
}
.service {
    padding: 3em 0em;
    margin: 0 auto;
	position: relative;
}
.serice-layer{
	position: absolute;
	width: 300px;
}
.services-bottom{
	margin-left: 20%;
}
.services-bottom2{
	margin-left: 20%;
}
#zz{
	width: 450px;
}
.serv-text{
	width: 30%;
	float: left;
	padding: 50px;
	margin: 
}
.serv-text h4 {
    font-size: 1.1em;
    color: #006e96;
    margin-bottom: 0.5em;
    font-family: 'Oswald', sans-serif;
}
.serv-text p {
    font-size:1em;
    color:#929292;
    line-height: 1.8em;
}
.service-top h3 {
    font-size: 3em;
    color: #EA548E;
    text-align: center;
    font-family: 'Oswald', sans-serif;  
}
.service-top p {
    font-size: 1em;
    color:#929292;
    text-align: center;
}
/*--ser strip--*/
/* .ser-strip-main {
    margin-top: 2em;
}
.ser-strip {
    background: url(../images/ser-strip.jpg)no-repeat;
    background-size: cover;
    min-height: 370px;
    padding: 5em 0em;
    text-align:center;
}
.ser-strip-main h3 {
    font-size:3em;
    color: #fff;
    margin-bottom: 0.9em;
    font-family: 'Oswald', sans-serif;
}
.ser-strip-main a {
    font-size: 1em;
      color: #EA548E;
    border: 1px solid #EA548E;
    
    padding: 0.5em 1.5em;
    display: inline-block;
}
.ser-strip-main a:hover{
    color:#006e96;
    border: 1px solid #006e96;
} *//* 

.blog-discription{
	-webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -ms-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}
.blog-discription {
    text-align: center;
    position: absolute;
    bottom: 0;
    opacity: 0;
    overflow: hidden;
    height: 100%;
    width: 100%;
    padding: 10px;
    background: rgba(0, 0, 0, 0.80);
    color: #fff;
}
.theme-border {
    height: 100%;
    width: 100%;
    border: 2px;
    border: 1px solid rgba(255,255,255,.5);
    position: relative;
}
.tg-display-table {
    width: 100%;
    height: 100%;
    display: table;
}
.tg-display-table-cell {
    display: table-cell;
    vertical-align: middle;
    width: 100%;
    height: 100%;
}
.blog-title {
    padding:1em 1em;
}
.serv-img h4{
    -webkit-transition: all 0.5s ease-in-out;
    -moz-transition: all 0.5s ease-in-out;
    -ms-transition: all 0.5s ease-in-out;
    -o-transition: all 0.5s ease-in-out;
    transition: all 0.5s ease-in-out;
}
.blog-title h4 {
    font-weight: bold;
    color: #fff;
    position: relative;
    right:0%;
	font-size: 1.5em;
	margin-top: 0.5em;
}
.blog-title h4 a{
	color:#fff;
}
.blog-title h4:before {
    background: #fff;
    content: "";
    position: absolute;
    margin: 0 0 0 -21px;
    width: 40px;
    left: 50%;
    bottom: -10px;
    height: 1px;
}
.blog-title h4 a {
    color: #fff;
} *//* 
.serv-img .blod-meta {
    -webkit-transition: all 0.9s ease-in-out;
    -moz-transition: all 0.9s ease-in-out;
    -ms-transition: all 0.9s ease-in-out;
    -o-transition: all 0.9s ease-in-out;
    transition: all 0.9s ease-in-out;
}
.blod-meta {
    margin: 0;
    padding: 0;
    list-style: none;
    display: inline-block;
    position: relative;
    right: 120%;
    padding: 0 0 10px;
    margin:1em 0;
}
.blod-meta li {
    float: left;
	font-size: 13px;
}
.blod-meta li a{
	color:#fff;
}
.blod-meta li:first-child::before {
    content: "";
    margin: 0;
}
.blod-meta li::before {
    content: "|";
    margin: 0 10px;
}
.blog-title p {
    color: #fff;
    margin: 0;
    position: relative;
    right: 120%;
	font-size: 13px;
    line-height: 1.8em;
}  */

.hide {
	display: none;
}
.foot{
	width: 100%;
	height: 70px;
	background: #000;
	opacity: 0.7;
	position: relative;
	top: 600px;
}
.form {
	background-color: #eeeeee;
	position: absolute; 
	width: 400px;
	height: 400px;
	z-index: 3;
	margin-top: -800px;
	margin-left: 39%;
	opacity: 0.9;
	line-height: 35px;
}
.form p{
	text-align: center;
	color: #fff;
	z-index: 5;
	height: 35px;
	background: #000;
}
.input1{
	width: 210px;
}
.input2{
	width: 80px;
	font-size: 17px;
	position: relative;
	top: 20px;
	padding: 0px 20px;
}
form{
	margin: 10px auto auto 23%;
}
.form button{
	width: 80px;
	font-size: 17px;
	position: relative;
	top: 20px;
	left: 45px;
	padding: 0px 20px;
}
.borrow{
	height: 300px;
}
#borrow{
	position: relative;
	left: -40px;
	top: 20px;
}
#book_id{
	visibility : hidden;
	display : none;
}
.one{
	position:relative;
	left: 32px;
}
.two{
	position:relative;
	left: 32px;
}
.button{
	position:relative;
	left: 40px;
}
</style>
</head>

<body>
	<%session.setAttribute("manager_id", "1"); %>
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
				<option>书名</option>
				<option>作者</option>
				<option>书架号</option>
			</select>
			<input type="text" id="select">
			<button id="addBook">添加图书</button>
		</div>
	</div>

<!-- 表格 -->
	<div class="after">
		<p>BookMessage</p>
		<div class="after-late">
			<table>
				<tr>
					<td class="table-one" id="book_id">书本编号</td>
					<td class="table-two">序号</td>
					<td class="table-twoo">书名</td>
					<td class="table-three">作者</td>
					<td class="table-four">剩余数量</td>
					<td class="table-five">上架时间</td>
					<td class="table-six">书架号</td>
					<td class="table-seven">删除</td>
					<td class="table-eight">更新</td>
					<td class="table-nine">借书</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="la">
		<lable id="last">上一页</lable><lable id="next">下一页</lable>
	</div>
	
<!-- 书目   -->
<div class="blank2"></div>
<div class="service" id="services">
		<div class="service-main">
			<div class="service-top">
				<h3>文学经典</h3>
				<span class="heading-line"> </span>
				<p>Literary classics.</p>
			</div>
			<!-- 1 -->
			<div class="services-bottom">
				<div class="serice-layer">
			   		<img src="img/hx.jpg" alt="" class="img-responsive">
				</div>
				<div class="col-md-6 serv-text">
					<h4>《呼啸山庄》</h4>
					<p>是由威廉·惠勒执导，劳伦斯·奥利弗、梅尔·奥勃朗主演的爱情片，于1939年4月13日在美国上映。
					该片改编自英国作家艾米莉·勃朗特的同名小说，讲述了希斯克利夫在自己最爱的女人凯西嫁给别人之后，
					开始对社会充满了仇恨并着手复仇的故事。1940年格雷格·托兰德凭借该片获得第12届奥斯卡奖最佳摄影奖。</p>
				</div>
			</div>
			<!-- 2 -->
			<div class="services-bottom">
				<div class="serice-layer">
					<img src="img/bl.jpg" alt="" class="img-responsive">
				</div>
				<div class="col-md-6 serv-text">
					<h4>《巴黎圣母院》</h4>
					<p>以离奇和对比手法写了一个发生在15世纪法国的故事：巴黎圣母院副主教克罗德道貌岸然、蛇蝎心肠，
					先爱后恨，迫害吉ト赛女郎埃斯梅拉达。面目丑陋、心地善良的敲钟人卡西莫多为救女郎舍身。小说揭露了宗教的虚伪，
					宣告禁欲主义的破产，歌颂了下层劳动人民的善良、友爱、舍己为人，反映了雨果的人道主义思想。</p>
				</div>
			</div>
			<!-- 3 -->	
			<div class="services-bottom2">
				<div class="services-bottom">
					<div class="serice-layer">
						<img src="img/hh.jpg" alt="" class="img-responsive">				</div>
					</div>
					<div class="col-md-6 serv-text">
						<h4>《红与黑》</h4>
						<p>小说发表后，当时的社会流传“不读《红与黑》，就无法在政界混”的谚语，而该书则被许多国家列为禁书。
						《红与黑》在心理深度的挖掘上远远超出了同时代作家所能及的层次。它开创了后世“意识流小说”、“心理小说”的先河。
						后来者竞相仿效这种“司汤达文体”，使小说创作“向内转”，发展到重心理刻画、重情绪抒发的现代形态。</p>
					</div>
				</div>
				<!-- 4 -->
				<div class="services-bottom">
					<div class="serice-layer">
						<img src="img/zz.jpg" alt="" class="img-responsive">			</div>
					</div>
					<div class="col-md-6 serv-text" id="zz">
						<h4>《战争与和平》</h4>
						<p>是俄国作家列夫·尼古拉耶维奇·托尔斯泰创作的长篇小说，也是其代表作。该作以1812年的卫国战争为中心，
						反映从1805到1820年间的重大历史事件。以鲍尔康斯、别祖霍夫、罗斯托夫和库拉金四大贵族的经历为主线，
						在战争与和平的交替描写中把众多的事件和人物串联起来。</p>
					</div>
				</div>
			</div>
	</div>			
</div>
<div class="foot"></div>

<!-- 添加弹窗 -->
	<div class="book form hide middle">
		<p>书本添加/更新</p><hr>
		<form id="book">
			<span>书名：</span></br>
			<input class="input1" type="text" name="book_name"><br> 
			<span>作者：</span></br>
			<input class="input1" type="text" name="book_author"><br>
			<span>剩余数量：</span></br>
			<input class="input1" type="text" name="book_number"><br> 
			<span>书架号：</span></br>
			<input class="input1" type="text" name="book_shelfid"><br>
			<input class="input2" type="submit" value="确定">
			<button class="input2">取消</button>
		</form>
	</div>
	
	<div class="borrow hide form">
		<p>借书</p><hr>
		<form id="borrow">
			书名：<input class="input1 one" type="text" name="borrow_book_name" readonly="readonly"><br> 
			剩余数量：<input class="input1" type="text" name="borrow_book_number" readonly="readonly"><br> 
			学号：<input class="input1 two" type="text" name="borrow_student_id"><br>
			<input type="hidden" name="borrow_manager_id" value="${sessionScope.manager_id}">
			<div class="button">
				<input class="input2" type="submit" value="确定">
				<button class="input2">取消</button>
			</div>
		</form>
	</div>
	
	<script type="text/javascript" src="js/BookMessage.js"></script>
</body>
</html>
