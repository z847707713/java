<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/layui/css/layui.css">
<script type="text/javascript" src="style/layui/layui.js"></script>

</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">layui 后台布局</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="logout">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test1">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">所有商品</a>
						<dl class="layui-nav-child">
						    <c:forEach items="${menus}" var="menu" >
						       
						       <shiro:hasPermission name="${menu.permission }">
						       <dd>
								<a data-url="${pageContext.request.contextPath}${menu.url}" data-id="${menu.id }" data-title="${menu.name }" href="#test1=${menu.id }"  class="site-demo-active" data-type="tabAdd">${menu.name }</a>
							   </dd>
							   </shiro:hasPermission>
						    </c:forEach>
						</dl>	
						</li>
					<li class="layui-nav-item"><a href="javascript:;">解决方案</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">列表一</a>
							</dd>
							<dd>
								<a href="javascript:;">列表二</a>
							</dd>
							<dd>
								<a href="">超链接</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="">云市场</a></li>
					<li class="layui-nav-item"><a href="">发布商品</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<div class="layui-tab layui-tab-brief" lay-allowClose="true" lay-filter="test1">
				<ul class="layui-tab-title">
					<li class="layui-this" >网站设置</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">1</div>
				</div>
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© layui.com - 底部固定区域
		</div>
	</div>

	<script>
		layui.use('element', function() {
			var $ = layui.jquery;
			var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

			//触发事件
			  var active = {
			    tabAdd: function(url,id,name){
			      //新增一个Tab项
			      element.tabAdd('test1', {
			         title: name
			        ,content: '<iframe data-frameid="'+id+'" class="iframe" scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;"></iframe>'
			        ,id:id //实际使用一般是规定好的id，这里以时间戳模拟下
			      })
			    }
			    ,tabDelete: function(othis){
			      //删除指定Tab项
			      // element.tabDelete('test1', '44'); //删除：“商品管理”
			      
			      // othis.addClass('layui-btn-disabled');
			    }
			    ,tabChange: function(id){
			      //切换到指定Tab项
			      element.tabChange('test1',id); //切换到：指定id 的页面
			    }
			  };
			  
			
			  //具体触法事件，以及需要传入的参数，都在下面执行
			  $('.site-demo-active').on('click', function() {
	                var dataid = $(this);
                  
	                //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tabl项数目
	                if ($(".layui-tab-title li[lay-id]").length <= 0) {
	                    //如果比零小，则直接打开新的tab项
	                    active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
	                   
	                } else {
	                    //否则判断该tab项是否以及存在
             
	                    var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
	                    $.each($(".layui-tab-title li[lay-id]"), function () {
	                        //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
	                        if ($(this).attr("lay-id") == dataid.attr("data-id")) {
	                            isData = true;
	                        }
	                    })
	                    if (isData == false) {
	                        //标志为false 新增一个tab项
	                        active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
	                    }
	                }
	                //最后不管是否新增tab，最后都转到要打开的选项页面上
	                active.tabChange(dataid.attr("data-id"));
	                
	                myVar = setInterval(function(){
	        			mySetInterval();
	        		},7);
	                myStopFunction();
	               
	            });
			
			
			
			//获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
			var layid = location.hash.replace(/^#test1=/, '');
		  
			 
			//监听Tab切换，以改变地址hash值
			element.on('tab(test1)', function(data) {
				location.hash = 'test1=' + this.getAttribute('lay-id');
				console.log(data);
			});

		});
		
		//利用setInterval来定时执行iframe的动态适应高度
		var myVar;
		function mySetInterval(){
			var iframes = document.getElementsByClassName("iframe");
			try{
		    for(var i=0;i<iframes.length;i++){
		    	var bHeight = iframes[i].contentWindow.document.body.scrollHeight;
				var dHeight = iframes[i].contentWindow.document.documentElement.scrollHeight;
				var height = Math.max(bHeight, dHeight);
				iframes[i].height = height;
				console.log(height);
		    }
			
			}catch (ex){
				console.log(ex);
			}
		}
		
		function myStopFunction() {
			setTimeout(function(){ clearInterval(myVar); }, 3000);
		}
		
	
		
		
		
		
		
		
 
	</script>
</body>
</html>