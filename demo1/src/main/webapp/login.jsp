<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<base href="<%=basePath%>">
<title>【软帝集团】日报提交系统-学生登录</title>
<%@ include file="sourceCss.jsp" %>
<style>
	.btn-reg{
		margin-left:50%;
		width:50%;
	}
</style>
</head>
<body>
	<div class="container animated bounceInRight">
		<div class="page-header">
			<h3>学生登录</h3>
		</div>
		<div class="col-sm-5">		
			<form action="stu/login" method="get" class="form-horizontal form-login">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-phone"></span>
						</div>
						<input type="text" name="phone" required pattern="^1[3578]\d{9}$" class="form-control" value="${phone}" placeholder="请输入手机号"/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-lock"></span>
						</div>
						<input type="password" name="password" required class="form-control" value="${pwd}" placeholder="请输入密码"/>
					</div>
				</div>
				<div class="form-group text-right">
					<span>还没有账号？立即<a href="reg.jsp">注册</a></span>
				</div>
				<div class="form-group text-right">
					<button class="btn btn-primary btn-block btn-reg" type="submit">登录</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="sourceJs.jsp" %>
	<script>
		$(function(){
			$('.form-login').bootstrapValidator({
				message:'输入的字段信息有误',
				feedbackIcons:{
					valid:'glyphicon glyphicon-ok',
					invalid:'glyphicon glyphicon-remove',
					validating:'glyphicon glyphicon-refresh',	
				}
			});
			if('${msg}'){
				layer.msg('${msg}');
			}
			
		})
	</script>
</body>
</html>