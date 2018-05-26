<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   
   <form class="layui-form layui-form-pane" id="bindRole" action=""
		method="POST">
		<input  type="hidden" name="_method" value="PUT">
		<div class="layui-form-item">
	<c:forEach items="${roles }" var="role">
            <c:set var="flag" value="false"></c:set>
			<label class="layui-form-label">${role.roleDesc }</label>
			<div class="layui-input-block">
			    <c:forEach items="${hasRoles }" var="hasRole">
			         <c:if test="${hasRole.id == role.id }">
			             <c:set var="flag" value="true"></c:set>
			         </c:if>
			    </c:forEach>
			    <c:if test="${flag == true }">
			      <input type="checkbox" name="roleId[]" title="${role.roleName }" value="${role.id }" checked="checked"> 
			    </c:if>
				<c:if test="${flag == false }">
				 <input type="checkbox" name="roleId[]" title="${role.roleName }" value="${role.id }"> 
				</c:if>
				
			</div>
	</c:forEach>

		</div>
	</form>


</body>
</html>