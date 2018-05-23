window.onload = function (){
	getOrderList();
	getOrderListStatical();
	getAdminList();
	getBusinessList();
	getTaskList();
	var paginationTab = $('.page');
	$(paginationTab).click(function(e){
		var target = e.target;
		setPagination(target);
	})
	$('.reg-box').click(function(){
		$('.reg-start-box').show();
	})
	$(document).click(function(e){
		var _con = $('.reg-start-box');
		var _tab = $('.reg-box');
		 if(!_con.is(e.target) && _con.has(e.target).length === 0 && !_tab.is(e.target) && _tab.has(e.target).length === 0){
			 $('.reg-start-box').hide();
		  }
	})
	$('.close-btn').click(function(){
		 $('.reg-start-box').hide();
	})
	$('.reg-btn').click(function(){
		var count = $('.reg-amount').val();
		var goods_url = $('.reg-url').val();
		var adminId = $('.select-people').val();
		var businessId = $('.match-business').val();
		addTask(count,goods_url,adminId,businessId);
	})
	$('.sure-btn').click(function(){
		console.log(finish_userId,1)
		if(finish_userId){
			finishPayment(finish_userId);
		}
	})
	$('.refuse-btn').click(function(){
		$('.comfire-box').hide();
	})
	$('.modify-sure-btn').click(function(){
		var OrderId = $('.modify-input').val();
		if(!OrderId){
			$('.modify-input').attr('placeholder','订单号不能为空');
		}
		if(userId && OrderId){
			modifyOrderNum(OrderId,userId);
		}
	})
	$('.modify-refuse-btn').click(function(){
		$('.modify-input').attr('placeholder','订单号');
		$('.modify-box').hide();
	})
}
var orderListUrl = ctx + '/addInfo/getAllUsers';
var orderNotPayment = ctx + '/admin/getNotPay';
var beginPaymentUrl = ctx + '/admin/begin';
var finishPaymentUrl = ctx + '/admin/end';
var getHasSuccessUrl = ctx + '/admin/getHasSuccess';
var orderListStaticalUrl=ctx + '/addInfo/getDatas';
var orderSuccessStaticalUrl = ctx + '/admin/getTodayData';
var addTaskUrl = ctx + '/addInfo/addTask';
var getAdminListUrl= ctx + '/admin/getAdminList';
var getBusinessListUrl = ctx + '/business/getBusinessList';
var currentPage = 1,count = 10,totalPage,finish_userId,userId;
var getTaskListUrl= ctx + '/admin/getTaskList';
var modifyOrderNumUrl = ctx + '/admin/exchange';

function switchNav(tab){
	var val = $(tab).text();
	var _type = $(tab).attr('_type');
	var navItems = $('.nav-item');
	for(var i=0;i<navItems.length;i++){
		if($(navItems[i]).hasClass('nav-selected')){
			$(navItems[i]).removeClass('nav-selected');
		}
	}
	$(tab).addClass('nav-selected');
	if(val == '未支付'){
		$('.pagination').hide();
		$('.statical').empty();
		$('.task-list').show();
		$('.task-list').empty();
		getOrderList();
		getTaskList();
	}else if(val == '待支付'){
		$('.pagination').hide();
		$('.statical').empty();
		$('.task-list').hide();
		getNotPaymentOrderList();
	}else if(val == '已完成'){
		$('.pagination').show();
		$('.statical').empty();
		$('.task-list').hide();
		var selectedPage = $('.pagination').children('.current-page');
		$(selectedPage).removeClass('current-page');
		$('.home-page').addClass('current-page');
		currentPage = 1;
		getOrderSuccessStatical();
		getHasSuccessList(currentPage,count);
	}
}

function getOrderList(){
	$('.gridtable').empty();
	$.ajax({
		type:'get',
		url:orderListUrl,
		success(data){	
			if(data.success){
				var html_head = '<thead><tr><th>序号</th><th>手机号</th><th>订单号</th><th>时间</th><th>操作</th></tr></thead></thead>';
				$(html_head).appendTo('.gridtable');
				var t_body = '<tbody class="gridtable-body"></tbody>';
				$(t_body).appendTo('.gridtable');
				for(var i=0;i<data.userList.length;i++){
					var time = formatDate(data.userList[i].updateTime);
					var html_body = '<tr><td>'+ (i+1) +"."+'</td>'+
									'<td>'+ data.userList[i].userMobile +'</td>'+
									'<td>'+ data.userList[i].orderNum +'</td>'+
									 '<td>'+ time +'</td>'+
									 '<td><input type="button" value="支付" class="pay-btn" id="'+ data.userList[i].userId +'" onclick="beginPayment(this)"/></td>'+
									 '</tr>';
					$(html_body).appendTo('.gridtable-body');
				}
			}
		}
	})
}
function getNotPaymentOrderList(){
	$('.gridtable').empty();
	$.ajax({
		type:'get',
		url:orderNotPayment,
		success(data){	
			if(data.success){
				console.log('in')
				var html_head = '<thead><tr><th>序号</th><th>手机号</th><th>订单号</th><th>时间</th><th>操作1</th><th>操作2</th></tr></thead></thead>';
				$(html_head).appendTo('.gridtable');
				var t_body = '<tbody class="gridtable-body"></tbody>';
				$(t_body).appendTo('.gridtable');
				for(var i=0;i<data.list.length;i++){
					var time = formatDate(data.list[i].updateTime);
					var html_body = '<tr><td>'+ (i+1) +"."+'</td>'+
					'<td>'+ data.list[i].userMobile +'</td>'+
					'<td><span class="order-text">'+ data.list[i].orderNum +'</span></td>'+
					 '<td>'+ time +'</td>'+
					 '<td><input type="button" value="完成" class="pay-btn" id="'+ data.list[i].userId +'" onclick="showFinishPaymentBox(this)"/></td>'+
					 '<td><input type="button" value="修改" class="modify-btn" id="'+ data.list[i].userId +'" onclick="modifyOrderNumBox(this)"/></td>'+
					 '</tr>';
					$(html_body).appendTo('.gridtable-body');
				}
			}
		}
	})
}

function getHasSuccessList(currentPage,count = 10){
	$('.gridtable').empty();
	$.ajax({
		type:'get',
		url:getHasSuccessUrl,
		data:{
			page:count,
			record:currentPage,
		},
		success(data){	
			if(data.success){
				totalPage = data.pages;
				var html_head = '<thead><tr><th>序号</th><th>手机号</th><th>订单号</th><th>价格</th><th>时间</th></tr></thead></thead>';
				$(html_head).appendTo('.gridtable');
				var t_body = '<tbody class="gridtable-body"></tbody>';
				$(t_body).appendTo('.gridtable');
				for(var i=0;i<data.list.length;i++){
					var time = formatDate(data.list[i].updateTime);
					var html_body = '<tr><td>'+ (i+1) +"."+'</td>'+
					'<td>'+ data.list[i].userMobile +'</td>'+
					'<td>'+ data.list[i].orderNum +'</td>'+
					'<td>'+ data.list[i].orderPrice +'</td>'+
					 '<td>'+ time +'</td>'+
					 '</tr>';
					$(html_body).appendTo('.gridtable-body');
				}
			}
		}
	})
}

function formatDate(_date){
	if(!_date){
		return _date
	}
	var _date = new Date(_date);
	var _year = _date.getFullYear();
	var _month = _date.getMonth()+1;
	var _day = _date.getDate();
	var _hour = _date.getHours();
	var _minutes = _date.getMinutes();
	var _seconds = _date.getSeconds();
	var time = _month + '/' + _day + '/' + _year + ' ' + _hour + ':' + _minutes + ':'+_seconds;
	return time;
}

function beginPayment(tab){
	var userId = $(tab).attr('id');
	$.ajax({
		type:'post',
		url:beginPaymentUrl,
		data:{
			userId:userId,
		},
		success(data){
			if(data.success){
				
			}else{
				alert('商品已被抢购');
			}
			getOrderList();
		}
	})
}
function showFinishPaymentBox(tab){
	finish_userId = $(tab).attr('id');
	$('.comfire-box').show();
}
function modifyOrderNumBox(tab){
	userId = $(tab).attr('id');
	$('.modify-box').show();
}
function finishPayment(userId){
	$.ajax({
		type:'post',
		url:finishPaymentUrl,
		data:{
			userId:userId,
		},
		success(data){
			if(data.success){
				$('.comfire-box').hide();
			}else{
				alert('支付失败');
			}
			getNotPaymentOrderList();
		}
	})
}
function modifyOrderNum(OrderId,userId){
	$.ajax({
		type:'post',
		url:modifyOrderNumUrl,
		data:{
			OrderId:OrderId,
			userId:userId
		},
		success(data){
			if(data.success){
				$('.modify-input').val('');
				$('.modify-box').hide();
			}else{
				alert('支付失败');
			}
			getNotPaymentOrderList();
		}
	})
}
function setPagination(target){
	var val = $(target).text();
	var selectedPage = $('.pagination').children('.current-page');
	if(val == '首页'){
		$(selectedPage).removeClass('current-page');
		$(target).addClass('current-page');
		getHasSuccessList(1);
	}else if(val == '下一页'){
		$(selectedPage).removeClass('current-page');
		$(target).addClass('current-page');
		currentPage++;
		getHasSuccessList(currentPage);
	}else if(val == '上一页'){
		if(currentPage >1){
			$(selectedPage).removeClass('current-page');
			$(target).addClass('current-page');
			currentPage--;
			getHasSuccessList(currentPage);
		}
	}else if(val == '尾页'){
		if(totalPage > 1){
			$(selectedPage).removeClass('current-page');
			$(target).addClass('current-page');
			getHasSuccessList(totalPage);
		}
	}
}
/**
 * getOrderListStatical:未完成页面，订单统计
 * @returns  count未完成 PCount已完成
 */
function getOrderListStatical(){
	$.ajax({
		type:'get',
		url:orderListStaticalUrl,
		success(data){
			if(data.success){
				var html = '<span style="margin-right:30px;">已完成订单数：'+data.PCount+'</span><span>未完成订单数：'+data.count+'</span>';
				$(html).appendTo('.statical');
			}
		}
	})
}
/**
 * 
 * @returns totalMoney今日完成金额;orderNum今日完成订单数
 */
function getOrderSuccessStatical(){
	$.ajax({
		type:'get',
		url:orderSuccessStaticalUrl,
		success(data){
			if(data.success){
				var html = '<span style="margin-right:30px;">今日完成订单数：'+data.orderNum+'</span><span>今日完成金额：'+data.totalMoney+'</span>';
				$(html).appendTo('.statical');
			}
		}
	})
}

function addTask(count,goods_url,adminId,businessId){
	if(!count || !goods_url || !adminId || !businessId){
		alert('注册人数，地址，指派人选不能为空');
		return;
	}
	$.ajax({
		type:'get',
		url:addTaskUrl,
		data:{
			count:count,
			goods_url:goods_url,
			adminId:adminId,
			businessId:businessId,
		},
		success(data){
			if(data.success){
				$('.reg-amount').val('');
				$('.reg-url').val('');
				$('.select-people').val('');
				alert('添加任务成功');
			}else{
				alert('添加任务失败');
			}
		}
	})
}

function getAdminList(){
	$.ajax({
		type:'get',
		url:getAdminListUrl,
		success(data){
			if(data.success){
				var html = '';
				for(var key in data.adminList){
					html+="<option value='"+key+"'>"+data.adminList[key]+"</option>"
				}
				$(html).appendTo('.select-people');
			}
		}
	})
}

function getBusinessList(){
	$.ajax({
		type:'get',
		url:getBusinessListUrl,
		success(data){
			if(data.success){
				var html = '';
				for(var key in data.businesses){
					html+="<option value='"+key+"'>"+data.businesses[key]+"</option>"
				}
				$(html).appendTo('.match-business');
			}
		}
	})
}

function getTaskList(){
	$.get(getTaskListUrl,function(data){
		if(data.success){
			var html_head = '<thead><tr><th>商品地址</th><th>商品状态</th><th>商品数量</th><th>用户</th></tr></thead>';
			$(html_head).appendTo('.task-list');
			var t_body = '<tbody class="taskList-body"></tbody>';
			$(t_body).appendTo('.task-list');
			for(var i=0;i<data.taskList.length;i++){
				var html_body = '<tr><td>'+ data.taskList[i].taskUrl +"."+'</td>'+
								'<td>'+ data.taskList[i].taskStatus +'</td>'+
								'<td>'+ data.taskList[i].taskCount +'</td>'+
								 '<td>'+ data.taskList[i].taskRemark +'</td>'+
								 '</tr>';
				$(html_body).appendTo('.taskList-body');
			}
		}
	})
}
