<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include.jsp"%>
<c:if test="${sessionScope.adminUser == null}">
	<jsp:forward page="login.jsp"/>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>order</title>
<link rel="stylesheet" href='./style/order.css'>
</head>
<body>
<div class="content">
	<nav>
		<ul>
			<li class="nav-selected nav-item" onclick="switchNav(this)">未支付</li>
		</ul>
		<ul>
			<li class="nav-item" onclick="switchNav(this)">待支付</li>
		</ul>
		<ul>
			<li class="nav-item" onclick="switchNav(this)">已完成</li>
		</ul>
		<ul>
			<li>
				<span class="reg-box">添加任务</span>
				<div class="reg-start-box">
					<input type="text" placeholder="请输入注册人数" class="reg-amount"/>
					<input type="text" placeholder="请输入地址" class="reg-url"/>
					<select class="select-people">
						<option value="" style="color:black;font-weight: bold;">选择指派人员</option>
					</select>
					<select class="match-business">
						<option value="" style="color:black;font-weight: bold;">选择对应商家</option>
					</select>
					<input type="button" value="确认添加" class="reg-btn"/>
					<span class="close-btn">X</span>
				</div>
			</li>
		</ul>
	</nav>
	<div class="comfire-box">
		<span>是否确认完成？</span>
		<div>
			<input type="button" value="是" class="sure-btn">
			<input type="button" value="否" class="refuse-btn">
		</div>
	</div>
	<div class="modify-box">
		<span>修改订单号？</span>
		<div><input type="text" class="modify-input" placeholder="订单号"></div>
		<div>
			<input type="button" value="是" class="modify-sure-btn">
			<input type="button" value="否" class="modify-refuse-btn">
		</div>
	</div>
	<div class="statical"></div>
	<table class="gridtable"></table>
	<table class="task-list"></table>
	<div class="pagination">
		<span class="current-page page home-page">首页</span>
		<span class="page">上一页</span>
		<span class="page">下一页</span>
		<span class="page">尾页</span>
	</div>
</div>
<script src='./js/jquery-1.11.3.min.js'></script>
<script src='./js/order.js'></script>
</body>
</html>