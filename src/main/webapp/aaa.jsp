<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/layui/css/layui.css">
<script type="text/javascript" src="style/layui/layui.js"></script>
</head>
<body>
   
    <div class="demoTable">

			<div class="layui-inline">
				<label class="layui-form-label"> 搜索ID：</label>
				<div class="layui-inline">
					<input class="layui-input" name="queryId" id="queryId"
						autocomplete="on">

				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">搜索用户名</label>
				<div class="layui-inline">
					<input class="layui-input" name="queryName" id="queryName"
						autocomplete="on">
				</div>
			</div>
		<button class="layui-btn" data-type="reload">搜索</button>
	
	</div>

	<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>


	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
		layui.use('table', function() {
			var table = layui.table;
			var $ = layui.jquery;
			//方法级渲染
			var myTable = table.render({
				elem : '#LAY_table_user',
				url : 'usersTable',
				cols : [ [ {
					checkbox : true,
					fixed : true,
					width :50
				}, {
					field : 'id',
					title : 'ID',
				    width:200,
					sort : true,
					fixed : true
				}, {
					field : 'username',
					title : '用户名',
					width : 200
				}, {
					field : 'roles',
					title : '角色',
					width : 200,
 					sort : true
				} ] ],
				id : 'testReload',
				page : true,
				height : 522
			});

			$('.demoTable .layui-btn').on('click', function() {
				var demoReload = $('#queryId');
				var nameReload = $('#queryName');
			
				myTable.reload({
					page : {
						curr : 1
					//重新从第 1 页开始
					},
					where : {
						queryId : demoReload.val(),
						queryName : nameReload.val()
					}
				});
			});
		});
	</script>
   
</body>
</html>