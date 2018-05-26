<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/layui/css/layui.css">
<script type="text/javascript" src="style/layui/layui.js"></script>
<style type="text/css">
</style>
</head>
<body>

	<div class="demoTable">

		<div class="layui-inline">
			<label class="layui-form-label"> ID：</label>
			<div class="layui-inline">
				<input class="layui-input" name="id" id="id" autocomplete="on">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">角色名称：</label>
			<div class="layui-inline">
				<input class="layui-input" name="roleName" id="roleName" autocomplete="on">
			</div>
		</div>

		<div class="layui-inline">
			<label class="layui-form-label">角色描述</label>
			<div class="layui-inline">
				<input class="layui-input" name="roleDesc" id="roleDesc" autocomplete="on">
			</div>
		</div>

		<button class="layui-btn" data-type="reload">搜索</button>

	</div>
	<div class="createNew">
		<button class="layui-btn">新增角色</button>
	</div>

	<table class="layui-hide" id="LAY_table_user" lay-filter="role"></table>




	<div id="innerCreateNew"></div>


  <script type="text/html" id="barDemo">
    
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  </script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
	 
		layui.use(['table','form'], function() {
			var table = layui.table;
			var $ = layui.jquery;
			var layer = layui.layer;
			var form = layui.form;
			//方法级渲染
			var myTable = table.render({
				elem : '#LAY_table_user',
				url : '${pageContext.request.contextPath }/roleTable',
				cols : [ [ {
					checkbox : true,
					fixed: 'left',
				}, {
					field : 'id',
					fixed: 'left',
					title : 'ID',
					sort : true
				}, {
					field : 'roleName',
					title : '角色名称',
				    edit  : 'text'
				}, {
					field : 'roleDesc',
					title : '角色描述',
 					sort : true,
 					edit  : 'text'
				}, {
					field : 'createTimeStr',
					title : '创建时间',
 					sort : true
				}, {
					field : 'createBy',
					title : '创建者',
 					sort : true
				}, {
					field : 'updateTimeStr',
					title : '更新时间',
 					sort : true
				}, {
					field : 'updateBy',
					title : '更新者',
 					sort : true
				}, {
 					toolbar:'#barDemo'
				}
				] ],
				id : 'testReload',
				page : true,
				height: 480
				
			});
            
			
			//监听编辑事件
			table.on('edit(role)', function(obj){
			   // var value = obj.value //得到修改后的值
			    var data = obj.data //得到所在行所有键值
			   // ,field = obj.field; //得到字段
			    data['_method'] = 'PUT';
			   // layer.msg(JSON.stringify(data));
			    //layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
			    $.ajax({
			    	url:'${pageContext.request.contextPath}/role',
			    	type:'POST',
			    	data:data,
			    	success:function(data){
			    		
			    	},
			    	error:function(e){
			    	 
			    	}
			    });
			    
			});
			
			 //监听单元格事件
			  table.on('tool(role)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'setType'){
			     
			    } else if(obj.event === 'del'){
			    	layer.confirm('真的删除行么', function(index){
			            $.ajax({
			            	url:"${pageContext.request.contextPath}/role",
			            	type:'POST',
			            	data:{
			            	  id:data.id,
			            	  _method:'DELETE'
			            	},
			            	success:function(){
			            		obj.del();
			            	}
			            });
			            layer.close(index);
			        });
			    }
 			    
			    
			  });
			
			
			
			$('.demoTable .layui-btn').on('click', function() {
			    reloadTable();
			});
			
		   function reloadTable(){
			   
			   myTable.reload({
					page : {
						curr : 1
					//重新从第 1 页开始
					},
					where : {
						id : $('#id').val(),
						roleName : $('#roleName').val(),
						roleDesc : $('#roleDesc').val() 
					}
				});
		   }
			
		   
		   function getFormData(tableId){
			    var d = {};
			    var t = $('#' + tableId).serializeArray();
			    $.each(t, function() {
				      d[this.name] = this.value;
				});
			    return d;
		   }
		 
		   
			/*
			  权限名称<input type="text">
			         <br>
			 url <input type="text">
			       <br>
			 类型 <checkbox>
			 权限 <input type="" />
			*/
			
			
			$(".createNew .layui-btn").on('click',function(){
				
						layer.open({
							  area: ['400px', '240px'],
							  title: '新增角色',
							  content: '<form class="layui-form layui-form-pane" id="createForm" action="" method="POST">'+
							    
					            '<div class="layui-form-item">'+
					            '<label class="layui-form-label">角色名称</label>'+
					            '<div class="layui-input-block">' + 
					            '<input type="text" name="roleName" lay-verify="roleName" autocomplete="off" placeholder="请输入角色名称" class="layui-input">'+
					            '</div>'+
					            '</div>'+
					            '<div class="layui-form-item">'+
					            '<label class="layui-form-label">角色描述</label>'+
					            '<div class="layui-input-block">'+
					            '<input type="text" name="roleDesc" lay-verify="roleDesc" placeholder="请输入角色描述" autocomplete="off" class="layui-input">'+
					            '</div>'+
					            '</div>'+
					            '</form>',
							  success: function(layero, index){
								    form.render('radio');  
							  },btn: ['确认']
							  ,yes: function(index, layero){
								    var d = getFormData("createForm");
								    $.ajax({
								    	url:"${pageContext.request.contextPath}/role",
								    	method:'POST',
								    	data:d
								    });
								    layer.close(index);
								    reloadTable();
							  }
						}); 
					
				  
			});  
			
		});
	</script>

</body>
</html>