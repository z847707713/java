<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   
    <form class="layui-form layui-form-pane" id="createForm" action="${pageContext.request.contextPath }/permission" method="POST">
        
         <div class="layui-form-item">
		    <label class="layui-form-label">名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="name" lay-verify="name" autocomplete="off" placeholder="请输入权限名" class="layui-input">
		    </div>
		 </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">URL</label>
		    <div class="layui-input-block">
		      <input type="text" name="url" lay-verify="url" placeholder="请输入url" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
                  <label class="layui-form-label">权限类型</label>
                <div class="layui-input-block">
                   <input type="radio" name="type" value="menu" title="菜单" checked="">
                   <input type="radio" name="type" value="button" title="按钮">
                  
                </div>
           </div>	
		
		  <div class="layui-form-item">
		    <label class="layui-form-label">权限</label>
		    <div class="layui-input-block">
		      <input type="text" name="permission" lay-verify="permission" placeholder="请输入权限" autocomplete="off" class="layui-input">
		    </div>
		  </div>  
		 </form>
   
   
</body>
</html>