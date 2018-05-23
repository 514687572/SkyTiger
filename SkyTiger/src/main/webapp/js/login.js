window.onload = function(){
	
	$('.login-btn').click(function(){
		var _username = $('.username > input').val();
		var _password = $('.password > input').val();
		if(!_username || !_password){
			alert('用户名或密码不能为空');
		}
		startLogin(_username,_password);
	})
	
	$('.reset-btn').click(function(){
		$('.username > input').val('');
		$('.username > input').focus();
		$('.password > input').val('');
	})
}

var loginUrl = ctx + '/admin/login';
function startLogin(userName,password){
	$.ajax({
		type:'post',
		url:loginUrl,
		data:{
			userName:userName,
			password:password
		},
		success(data){
			if(data.success){
				locationPage('','/order.jsp');
			}else{
				locationPage('用户名或密码错误');
			}
		}
	})
}
function locationPage(info,url){
	if(!info){
		window.location.href = ctx+url;
	}else{
		alert(info);
	}
}