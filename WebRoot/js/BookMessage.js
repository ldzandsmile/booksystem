$(function() {
	//显示表格数据
	var i = 1;
	$(".remove").remove();
	var url = "BookManager";
	var args = {
		method : "select",
		page : 1,
		time : new Date()
	};

	$.getJSON(url, args, function(data) {
		$.each(data, function(index, object) {
			setMessage(object);
			i = i + 1;
		});
		$("#next").before("<lable class='page'>1</lable>")
			.before("<lable class='page'>2</lable>");
	});

	//模糊查询
	$("#select").keyup(function() {
		i = 1;
		$(".remove").remove();
		var url = "BookManager";
		var args = {
			method : "select",
			selectName : $("#select").val(),
			selectType : $("select").val(),
			page : $("#last").next().text(),
			time : new Date()
		};

		$.getJSON(url, args, function(data) {
			$.each(data, function(index, object) {
				setMessage(object);
				i = i + 1;
			});
		});
	})

	//添加表格数据
	var setMessage = function(object) {
		var tr = $("<tr class='remove'></tr>");
		var book_id = $("<td id='book_id'>" + object.book_id + "</td>");
		var id = $("<td>" + i + "</td>");
		var book_name = $("<td>" + object.book_name + "</td>");
		var book_author = $("<td>" + object.book_author + "</td>");
		var book_number = $("<td>" + object.book_number + "</td>");
		var book_record = $("<td>" + object.book_record + "</td>");
		var book_shelfid = $("<td>" + object.book_shelfid + "</td>");
		var cut = $("<td><a href='BookManager?method=" + "delete" + "&book_id=" + object.book_id + "' class='a_delete'>删除</a></td>");
		var update = $("<td><a class='a_update'>更新</a></td>");
		var borrow = $("<td><a class='a_borrow'>借书</a></td>");
		/*var update = $("<td><a href='BookManager?method=" + "update" + "&book_id=" + object.book_id + "' class='a_update'>更新</a></td>");*/
		/*var cut = $("<td><button class='delete'>删除</button></td>");
		var update = $("<td><button class='update'>更新</button></td>");*/
		tr.append(book_id).append(id).append(book_name).append(book_author).append(book_number)
			.append(book_record).append(book_shelfid).append(cut).append(update).append(borrow);
		$("table").append(tr);
	}

	//增加图书 显示弹窗
	$("#addBook").click(function() {
		$(".background").removeClass("hide");
		$(".book").removeClass("hide");
		$(".book").addClass("insert");
	})

	//点击取消 移除弹窗
	$(".form>button").click(function() {
		$(".background").addClass("hide");
		$(".book").addClass("hide");
	})

	//点击确定 储存数据
	$(".book>form>input[type=submit]").click(function() {
		$(".background").addClass("hide");
		$(".book").addClass("hide");
		var url = "BookManager";
		if ($(".book").hasClass("insert")) {
			var args = {
				method : "insert",
				book_name : $("input[name=book_name]").val(),
				book_author : $("input[name=book_author]").val(),
				book_number : $("input[name=book_number]").val(),
				book_shelfid : $("input[name=book_shelfid]").val(),
				time : new Date()
			};
		} else if ($(".book").hasClass("update")) {
			var args = {
				method : "update",
				book_id : $("input[name=book_id]").val(),
				book_name : $("input[name=book_name]").val(),
				book_author : $("input[name=book_author]").val(),
				book_number : $("input[name=book_number]").val(),
				book_shelfid : $("input[name=book_shelfid]").val(),
				time : new Date()
			};
		}

		$.getJSON(url, args, function(data) {
			alert("添加成功");
		});
	})

	//事件委托 确定确认
	$("body").on('click', '.a_delete', function() {
		var msg = "您真的确定要删除吗？";
		if (confirm(msg) == true) {
			return true;
		} else {
			return false;
		}
	});

	//事件委托 更新操作 添加class用以识别
	$("body").on('click', '.a_update', function() {
		$(".background").removeClass("hide");
		$(".book").removeClass("hide");
		$(".book").addClass("update");

		var book_name = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(2).text();
		var book_author = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(3).text();
		var book_number = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(4).text();
		var book_shelfid = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(6).text();
		
		$(".book>form>input[name=book_name]").attr("value",book_name);
		$(".book>form>input[name=book_author]").attr("value",book_author);
		$(".book>form>input[name=book_number]").attr("value",book_number);
		$(".book>form>input[name=book_shelfid]").attr("value",book_shelfid);
		
		var book_id = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(0).text();
		var hidden = "<input type='hidden' value='" + book_id + "' name='book_id'>";
		$(".book").append(hidden);
	});

	//事件委托 借书
	$("body").on('click', '.a_borrow', function() {
		$(".background").removeClass("hide");
		$(".borrow").removeClass("hide");

		var borrow_book_id = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(0).text();
		var borrow_book_name = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(2).text();
		var borrow_book_number = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(4).text();
		
		var hidden_bookid = "<input type='hidden' value='" + borrow_book_id + "' name='borrow_book_id'>";
		var hidden_bookname = "<input type='hidden' value='" + borrow_book_name + "' name='borrow_book_name'>";
		
		$(".borrow>form>input[name=borrow_book_name]").attr("value",borrow_book_name);
		$(".borrow>form>input[name=borrow_book_number]").attr("value",borrow_book_number);
			
		$(".borrow>form").append(hidden_bookid).append(hidden_bookname);
	});

	//点击确定 借书
	$(".borrow>form>input[type=submit]").click(function() {
		$(".background").addClass("hide");
		$(".borrow").addClass("hide");
		var url = "BookBorrow";
		var args = {
			method : "insert",
			book_id : $(".borrow>form>input[name=borrow_book_id]").val(),
			student_id : $(".borrow>form>input[name=borrow_student_id]").val(),
			manager_id : $(".borrow>form>input[name=borrow_manager_id]").val(),
			time : new Date()
		};

		$.getJSON(url, args, function(data) {
			alert("借书成功");
		});
	})

	//上一页
	$("#last").click(function() {
		var url = "BookManager";
		var id = $("table").find("tr").eq(1).find("td").eq(1).text();
		var page = parseInt(parseInt(id)/10+1)
		i = $("table").find("tr").eq(1).find("td").eq(1).text()-10;

		if (page < 1) {
			page = 1;
		}else if(page == 1){
			
		}else {
			$(".remove").remove();
			var args = {
					method : "select",
					selectName : $("#select").val(),
					selectType : $("select").val(),
					page : page-1,
					time : new Date()
			};
			
			$.getJSON(url, args, function(data) {
				$.each(data, function(index, object) {
					setMessage(object);
					i = i + 1;
				});
				
				$(".page").remove();
				
				var lastpage = parseInt(page) - 1;
				/*if (page == 1) {
					$("#next").before("<lable class='page'>1</lable>")
					.before("<lable class='page'>2</lable>");
				} else {
					$("#next").before("<lable class='page'>" + lastpage + "</lable>")
					.before("<lable class='page'>" + page + "</lable>");
				}*/
				$("#next").before("<lable class='page'>" + lastpage + "</lable>")
					.before("<lable class='page'>" + page + "</lable>");
			});
		}
	})

	//下一页
	$("#next").click(function() {
		var length = $("table").find("tr").length;
		i = parseInt($("table").find("tr").eq(1).find("td").eq(1).text())+10;
		if(length < 11){
		}else {
			$(".remove").remove();
			var url = "BookManager";
			var page = $(this).prev().text();
			var args = {
				method : "select",
				selectName : $("#select").val(),
				selectType : $("select").val(),
				page : page,
				time : new Date()
			};
	
			$.getJSON(url, args, function(data) {
				$.each(data, function(index, object) {
					setMessage(object);
					i = i + 1;
				});
	
				$(".page").remove();
	
				var lastpage = parseInt(page) - 1;
				var nextpage = parseInt(page) + 1;
				length = $("table").find("tr").length;
				if(length < 11){
					$("#next").before("<lable class='page'>" + lastpage + "</lable>")
					.before("<lable class='page'>" + page + "</lable>");
				}else {
					$("#next").before("<lable class='page'>" + page + "</lable>")
					.before("<lable class='page'>" + nextpage + "</lable>");
				}
			});
		}
	})

	//中间的页码
	$("body").on('click', '.page', function() {
		var id = parseInt($("table").find("tr").eq(1).find("td").eq(1).text());
		var page = $(this).text();
		var oldpage = $(this).text();
		if(page == parseInt(id/10+1)){
		}else {
			if(page > parseInt(id/10+1)){
				page = parseInt(page) + 1;
				i = parseInt($("table").find("tr").eq(1).find("td").eq(1).text())+10;
			}else if(page < parseInt(id/10+1)){
				page = parseInt(page) - 1;
				i = parseInt($("table").find("tr").eq(1).find("td").eq(1).text())-10;
			}
				
			$(".remove").remove();
			var url = "BookManager";
			var last = $(this).prev().text();
			var next = $(this).next().text();
			var args = {
					method : "select",
					selectName : $("#select").val(),
					selectType : $("select").val(),
					page : oldpage,
					time : new Date()
			};
			
			$.getJSON(url, args, function(data) {
				$.each(data, function(index, object) {
					setMessage(object);
					i++;
				});
				
				$(".page").remove();
				
				var lastpage = parseInt(oldpage) - 1;
				var nextpage = parseInt(oldpage) + 1;
				var length = $("table").find("tr").length;
				
				if(oldpage < page){
					if(length < 11){
						$("#next").before("<lable class='page'>" + lastpage + "</lable>")
						.before("<lable class='page'>" + oldpage + "</lable>");
					}else{
						$("#next").before("<lable class='page'>" + oldpage + "</lable>")
						.before("<lable class='page'>" + nextpage + "</lable>");
					}
				}else if(oldpage > page){
					if(oldpage == 1){
						$("#next").before("<lable class='page'>1</lable>")
						.before("<lable class='page'>2</lable>");
					} else {
						$("#next").before("<lable class='page'>" + oldpage + "</lable>")
						.before("<lable class='page'>" + nextpage + "</lable>");
					}
				}
			});
		}
	});
})