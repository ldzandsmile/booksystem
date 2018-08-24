$(function() {
	var i = 1;
	$(".remove").remove();
	var url = "AdministratorsManager";
	var args = {
		method : "select",
		time : new Date()
	};

	$.getJSON(url, args, function(data) {
		$.each(data, function(index, object) {
			setMessage(object);
			i++;
		});
	});

	var setMessage = function(object) {
		var tr = $("<tr class='remove'></tr>");
		var manager_id = $("<td id='manager_id'>" + object.manager_id + "</td>");
		var id = $("<td>" + i + "</td>");
		var manager_name = $("<td>" + object.manager_name + "</td>");
		var cut = $("<td><a href='AdministratorsManager?method=" + "delete" + "&manager_id=" + object.manager_id + "' class='a_delete'>删除</a></td>");
		var update = $("<td><a class='a_update'>更新</a></td>");
		tr.append(manager_id).append(id).append(manager_name).append(cut).append(update);
		$("table").append(tr);
	}

	$("#addManager").click(function() {
		$(".background").removeClass("hide");
		$(".form").removeClass("hide");
		$(".form").addClass("insert");
	})

	$(".form>button").click(function() {
		$(".background").addClass("hide");
		$(".form").addClass("hide");
	})

	$(".form>form>input[type=submit]").click(function() {
		var password = $("input[name=manager_password]").val();
		var repassword = $("input[name=manager_repassword]").val();
		if(password != repassword){
			alert("两次密码不正确");
			return false;
		}
		
		$(".background").addClass("hide");
		$(".form").addClass("hide");
		var url = "AdministratorsManager";
		if ($(".form").hasClass("insert")) {
			var args = {
				method : "insert",
				manager_name : $("input[name=manager_name]").val(),
				manager_password : $("input[name=manager_password]").val(),
				time : new Date()
			};
		} else if ($(".form").hasClass("update")) {
			var args = {
				method : "update",
				manager_id : $("input[name=manager_id]").val(),
				manager_name : $("input[name=manager_name]").val(),
				manager_password : $("input[name=manager_password]").val(),
				time : new Date()
			};
		}

		$.getJSON(url, args, function(data) {
			$.each(data, function(index, object) {
				alert("success");
			});
		});
	})

	$("body").on('click','.a_delete',function(){
		var msg = "您真的确定要删除吗？";
		if (confirm(msg) == true) {
			return true;
		} else {
			return false;
		}
	});

	$("body").on('click','.a_update',function(){
		$(".background").removeClass("hide");
		$(".form").removeClass("hide");
		$(".form").addClass("update");
		
		var manager_name = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(2).text();
		
		$(".form>form>input[name=manager_name]").attr("value",manager_name);
		
		var manager_id = $('table').find("tr").eq($(this).parent().parent().index()).find("td").eq(0).text();
		var hidden = "<input type='hidden' value='" + manager_id + "' name='manager_id'>";
		$("form").append(hidden);
	});
})