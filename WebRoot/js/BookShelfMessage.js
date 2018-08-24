$(function() {
	//显示表格数据
	var i = 1;
	$(".remove").remove();
	var url = "BookShelfManager";
	var args = {
		method : "select",
		page : 1,
		time : new Date()
	};

	$.getJSON(url, args, function(data) {
		$.each(data, function(index, object) {
			setMessage(object);
			i++;
		});
		$("#next").before("<lable class='page'>1</lable>")
			.before("<lable class='page'>2</lable>");
	});

	//查询
	$("#select").keyup(function() {
		$(".remove").remove();
		var url = "BookShelfManager";
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
				i++;
			});
		});
	})

	//添加表格数据
	var setMessage = function(object) {
		var tr = $("<tr class='remove'></tr>");
		var bookshelf_id = $("<td id='bookshelf_id'>" + object.bookshelf_id + "</td>");
		var id = $("<td>" + i + "</td>");
		var bookshelf_type = $("<td>" + object.bookshelf_type + "</td>");
		var cut = $("<td><a href='BookShelfManager?method=" + "delete" + "&bookshelf_id=" + object.bookshelf_id + "' class='a_delete'>删除</a></td>");
		var update = $("<td><a class='a_update'>更新</a></td>");
		tr.append(bookshelf_id).append(id).append(bookshelf_type).append(cut).append(update);
		$("table").append(tr);
	}

	//增加图书 显示弹窗
	$("#addBookShelf").click(function() {
		$(".background").removeClass("hide");
		$(".form").removeClass("hide");
		$(".form").addClass("insert");
	})

	//点击取消 移除弹窗
	$(".form>button").click(function() {
		$(".background").addClass("hide");
		$(".form").addClass("hide");
	})

	//点击确定 储存数据
	$(".form>form>input[type=submit]").click(function() {
		$(".background").addClass("hide");
		$(".form").addClass("hide");
		var url = "BookShelfManager";
		if ($(".form").hasClass("insert")) {
			var args = {
				method : "insert",
				bookshelf_id : $("input[name=bookshelf_id]").val(),
				bookshelf_type : $("input[name=bookshelf_type]").val(),
				time : new Date()
			};
		} else if ($(".form").hasClass("update")) {
			var args = {
				method : "update",
				bookshelf_id : $("input[name=bookshelf_id]").val(),
				bookshelf_type : $("input[name=bookshelf_type]").val(),
				time : new Date()
			};
		}

		$.getJSON(url, args, function(data) {
			$.each(data, function(index, object) {
				alert("success");
			});
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
		$(".form").removeClass("hide");
		$(".form").addClass("update");

		var bookshelf_type = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(2).text();

		$(".form>form>input[name=bookshelf_type]").attr("value",bookshelf_type);
		
		var bookshelf_id = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(0).text();
		var hidden = "<input type='hidden' value='" + bookshelf_id + "' name='bookshelf_id'>";
		$("form").append(hidden);
	});

	//上一页
	$("#last").click(function() {
		i = $("table").find("tr").eq(1).find("td").eq(1).text()-10;
		var url = "BookShelfManager";
		var page = $(this).next().text();
		
		if (page < 1) {
			page = 1
		}else if (page == 1){
			
		}else {
			$(".remove").remove();
			var args = {
					method : "select",
					page : page-1,
					time : new Date()
			};
			
			$.getJSON(url, args, function(data) {
				$.each(data, function(index, object) {
					setMessage(object);
					i++;
				});
				
				$(".page").remove();
				
				var lastpage = parseInt(page)-1;
				$("#next").before("<lable class='page'>" + lastpage + "</lable>")
				.before("<lable class='page'>" + page + "</lable>");
			});
		}
	})

	//下一页
	$("#next").click(function() {
		i = parseInt($("table").find("tr").eq(1).find("td").eq(1).text())+10;
		var length = $("table").find("tr").length;
		if(length < 11){
		}else {
			$(".remove").remove();
			var url = "BookShelfManager";
			var page = $(this).prev().text();
			var args = {
				method : "select",
				page : page,
				time : new Date()
			};
	
			$.getJSON(url, args, function(data) {
				$.each(data, function(index, object) {
					setMessage(object);
					i++;
				});
	
				$(".page").remove();
				
				var nextpage = parseInt(page)+1;
				$("#next").before("<lable class='page'>" + page + "</lable>")
					.before("<lable class='page'>" + nextpage + "</lable>");
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
			var url = "BookShelfManager";
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