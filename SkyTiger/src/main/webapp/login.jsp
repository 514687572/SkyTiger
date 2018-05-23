<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>order</title>
<link rel="stylesheet" href='./style/login.css'>
</head>
<body>
<div class="content">
	<h2>管理员登录</h2>
	<div class="login-box">
		<div class="username">
			<label>用户名:</label>
			<input type="text" />
		</div>
		<div class="password">
			<label>密&nbsp;&nbsp;&nbsp;码:</label>
			<input type="text" />
		</div>
		<div>
			<input type="button" value="登录" class="login-btn">
			<input type="button" value="重置" class="reset-btn">
		</div>
	</div>
</div>
<script src='./js/jquery-1.11.3.min.js'></script>
<script src='./js/login.js'></script>
</body>
</html>
