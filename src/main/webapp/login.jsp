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
   #content{
      position: absolute;
      top: 50%;
      left: 50%;
      height: 240px;
      width:400px;
      margin-top: -120px; /* negative half of the height */
      margin-left: -200px;
   }
</style>
<script language="JavaScript">
//判断当前窗口是否有顶级窗口，如果有就让当前的窗口的地址栏发生变化，
//这样就可以让登陆窗口显示在整个窗口了
function loadTopWindow(){
    if (window.top!=null && window.top.document.URL!=document.URL){
        window.top.location= document.URL; 
    }
}
</script>

</head>
<body class="layui-bg-gray" onload="loadTopWindow()">
       
      <div style="width: 100%;height:100%">
	   <center>
		<div id="content">
			<form action="login" method="post" class="layui-form">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label"><img alt="" width="25px" height="25px" src="static/images/user.png"></label>
						<div class="layui-input-inline">
							<input type="text" name="username" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
						</div>
					</div>
				
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label"><img alt="" width="25px" height="25px"  src="static/images/password.png"></label>
						<div class="layui-input-inline">
							<input type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
			</form>
		</div>
	</center>
    </div>
	<script type="text/javascript">
		layui.use(
						[ 'form', 'layedit', 'laydate' ],
						function() {
							var form = layui.form,$=layui.jquery;



							//自定义验证规则
							form.verify({
							
								pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
								
							});

							
							//监听提交
							form.on('submit(demo1)', function(data) {
								
								return true;
							});

						});
	</script>

</body>
</html>