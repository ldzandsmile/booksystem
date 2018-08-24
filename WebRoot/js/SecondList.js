$(function() {
	$("#list_one").click(function() {
		$(".one").remove();
		$(".two").remove();

		var list = $("<li class='list_second one'></li>")
		
		var a1 = $("<a href='BookManager.jsp' class='href'></a>").text("图书管理");
		var a2 = $("<a href='AdministratorsManager.jsp' class='href'></a>").text("管理员设置");
		var a3 = $("<a href='BookShelfMessage.jsp' class='href'></a>").text("书架设置");
		
		var list1 = list.append(a1);
		var list2 = list.append(a2);
		var list3 = list.append(a3);
		
		$("#list_one").append(list1);
		$("#list_one").append(list2);
		$("#list_one").append(list3);
	})

	$("#list_two").click(function() {
		$(".one").remove();
		$(".two").remove();

		var list = $("<li class='list_second one'></li>")
		
		var a1 = $("<a href='BookBorrow' class='href'></a>").text("图书借阅");
		var a2 = $("<a href='BookRenow' class='href'></a>").text("图书续借");
		var a3 = $("<a href='BookReturn' class='href'></a>").text("图书归还");

		var list1 = list.append(a1);
		var list2 = list.append(a2);
		var list3 = list.append(a3);
		
		$("#list_two").append(list1);
		$("#list_two").append(list2);
		$("#list_two").append(list3);
	})

	$("#list_three").click(function() {
		$(".one").remove();
		$(".two").remove();
	})
})