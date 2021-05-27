<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>Đăng nhập</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="<c:url value='/template/login/style.css' />" rel="stylesheet" type="text/css" media="all"/>
</head>
<body id="LoginForm">
	<div class="container">
		<div class="login-form">
			<div class="main-div">
				<c:if test="${not empty message}">
					<div class="alert alert-${alert}">
					    ${message}
					</div>
				</c:if>
				<form action="<c:url value='/dang-nhap'/>" id="formLogin" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="username" name = "username"
							placeholder="Tên đăng nhập" required>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password" name = "password"
							placeholder="Mật khẩu" required>
					</div>
					<input type="hidden" value="login" name="action"/>
					<button type="submit" class="btn btn-primary" id = "btnLogin">Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>