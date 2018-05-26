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
     <input type="checkbox" value="{{d.username}}" checked="" name="open" lay-skin="switch" lay-filter="switch" lay-text="在线|踢出">
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
				url : '${pageContext.request.contextPath }/onlineUserTable',
				cols : [ [ {
					checkbox : true,
					fixed: 'left',
				}, {
					field : 'username',
					fixed: 'left',
					title : '用户名',
					sort : true
				}, {
					field : 'ip',
					title : '登陆ip',
				}, {
					field : 'lastTime',
					title : '最后操作时间',
 					sort : true,
				} , {
					templet: '#barDemo',
					unresize: true
			    } 
				] ],
				id : 'testReload',
				page : true,
				height: 480
				
			});
            
			 form.on('switch(switch)', function(obj){
			        var current = $(this);
			        if(obj.elem.checked){
			        	$(this).removeAttr('checked');
			        	form.render();
			        } else {
			        	//进行踢出操作
			        	var username =this.value;
			        	$.ajax({
			        		url:"${pageContext.request.contextPath}/removeOnlineUser",
			        		type:'POST',
			        		data:{
			        		    username:username
			        		},
			        		success:function(){
			        			
			        		},
			        		error:function(){
			        			current.setAttribute("checked","checked");
			        		}
			        	});
			        	
			        }
		     });
			
			 //监听单元格事件
			  table.on('tool(role)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'switch'){
			       
			    	
			    	
			    	
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