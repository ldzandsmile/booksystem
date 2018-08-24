$(function() {
	//显示表格数据
	var i = 1;
	$(".remove").remove();
	var url = "BookBorrow";
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
		var url = "BookBorrow";
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
		var book_id = $("<td id='borrow_id'>" + object.borrow_id + "</td>");
		var id = $("<td>" + i + "</td>");
		var student_name = $("<td>" + object.student_name + "</td>");
		var book_name = $("<td>" + object.book_name + "</td>");
		var borrow_managerName = $("<td>" + object.borrow_managername + "</td>");
		var return_managerName = $("<td>" + object.return_managername + "</td>");
		var borrow_date = $("<td>" + object.borrow_date + "</td>");
		var return_date = $("<td>" + object.return_date + "</td>");
		var money = $("<td>" + object.money + "</td>");
		var update = $("<td><button id='button_return'>归还</button></td>");
		
		tr.append(book_id).append(id).append(student_name).append(book_name).append(borrow_managerName)
		.append(return_managerName).append(borrow_date).append(return_date).append(money);
		
		if(object.return_date == ""){
			tr.append(update);
		}
		$("table").append(tr);
	}

	/*function displayIncomeCol(col,obj){
		var tb;
		var td;
		var tr;
		tb=document.getElementById("Data Table");
		//for(var i=0;i<tb.getElementsByTagName("tr").length;i++)
			{
			tr=tb.getElementsByTagName("tr")[i];
			for(var j=0;j<tr.childNodes.length;j++)
				{
				td=tr.childNodes[j];
				if(obj.checked==false)
					{
					if(j==col)
						{
						td.style.display="none";
						}
					}
				if(obj.checked==true)
					{
					if(j==col)
						{
						td.style.display="inline";
						}
					}
				}
			}
	}*/
	
	$("body").on('click', '#button_return', function() {
		var msg = "您真的确定要归还吗？";
		if (confirm(msg) == true) {
			i = $("table").find("tr").eq(1).find("td").eq(1).text();
			var url = "BookBorrow";
			var page = parseInt(parseInt($("table").find("tr").eq(1).find("td").eq(1).text()/10)+1);
			$(".remove").remove();
			var borrow_id = $(this).parent().parent().find("td").eq(0).text();
			var args = {
				method : "return",
				borrow_id : borrow_id,
				page : page,
				time : new Date()
			};

			$.getJSON(url, args, function(data) {
				$.each(data, function(index, object) {
					setMessage(object);
					i++;
				});
			});
		} else {
			return false;
		}
	});
	
	//上一页
	$("#last").click(function() {
		var url = "BookBorrow";
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
			var url = "BookBorrow";
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
					i++;
				});
				
				$(".page").remove();
				
				var nextpage = parseInt(page) + 1;
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
			var url = "BookBorrow";
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