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
<title>导入</title>
<style>
	.content{
		width:1200px;
		margin:0 auto;
	}
	.info{
		width:700px;
		margin:0 auto;
		border-bottom:1px solid #ccc;
	}
	.info > form > p:first-child{
		font-size:14px;
		color:#827c7c;
		margin: 60px 0 40px 30px;
   		width: 500px;
	}
	.upload-btn{
		width: 90px;
	    height: 30px;
	    border: none;
	    background: #2196F3;
	}
	form > p{
	display:inline-block;
	}  
</style>
</head>
<body>
<div class="content">
    <h1 style="text-align: center;margin-top: 20px;margin-bottom:60px;">信息导入</h1>
    <div class="info">
        <form class="upload" action="${ctx}/address/fileUpload" method="post" enctype="multipart/form-data">
            <p>
            	<label> 选择文件收货人信息文件:</label>
               <input type="file" name="multipartFile"/>
            </p>
            <p></p>
            <p style="margin-top: 20px;">
                <input style="" type="submit" value="上传并检测" class="upload-btn"/> 
            </p>
        </form>
    </div>
    <div class="info">
        <form class="upload" action="${ctx}/address/uploadPostNum" method="post" enctype="multipart/form-data">
            <p>
            	<label> 选择快递单号信息文件:</label>
               <input type="file" name="multipartFile"/>
            </p>
            <p></p>
            <p style="margin-top: 20px;">
                <input style="" type="submit" value="上传并检测" class="upload-btn"/> 
            </p>
        </form>
    </div>
</div>
</body>
</html>