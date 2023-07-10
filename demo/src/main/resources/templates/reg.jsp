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
<title>【软帝集团】日报提交系统-学生注册</title>
<%@ include file="sourceCss.jsp" %>
<style>
	.btn-reg{
		margin-left:50%;
		width:50%;
	}
	#validateCode{
		border:1px solid rgba(0,0,0,0.1);
	}
</style>
</head>
<body>
	<div class="container animated bounceInRight">
		<div class="page-header">
			<h3>学生注册</h3>
		</div>
		<div class="col-sm-5">		
			<form action="stu/reg" method="post" class="form-horizontal form-reg">
				<div class="form-group">
					<div class="col-sm-12">
						<div class="radio">
							<label for="" class="radio-inline">
								<input type="radio" name="sex" value="男" checked/>男
							</label>
							<label for="" class="radio-inline">
								<input type="radio" name="sex" value="女"/>女
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">				
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-user"></span>
							</div>
							<input type="text" name="name" required class="form-control" placeholder="请输入姓名"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-phone"></span>
							</div>
							<input type="text" name="phone" required pattern="^1[3578]\d{9}$" class="form-control" placeholder="请输入手机号"/>
						</div>
					</div>		
				</div>
				<div class="form-group">
					<div class="col-sm-12">					
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-lock"></span>
							</div>
							<input type="password" name="password" required class="form-control" placeholder="请输入密码"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-lock"></span>
							</div>
							<input type="password" name="repwd" id="" required class="form-control" placeholder="再次输入密码"/>
						</div>
					</div>
				</div>
				<div class="form-group text-right">
					<span><a href="login.jsp">返回登录</a></span>
				</div>
				<div class="form-group text-right">
					<button class="btn btn-primary btn-block btn-reg" type="submit">注册</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="sourceJs.jsp" %>
	<script>
		$(function(){
			$('.form-reg').bootstrapValidator({
				message:'输入的字段信息有误',
				feedbackIcons:{
					valid:'glyphicon glyphicon-ok',
					invalid:'glyphicon glyphicon-remove',
					validating:'glyphicon glyphicon-refresh',	
				},
				fields:{
					pwd:{
						message:'密码输入有误',
						validators:{							
							stringLength:{
								message:'密码必须保持在6~16之间',
								min:6,
								max:16
							}
						}
					},
					repwd:{
						message:'两次密码不一致',
						validators:{
							identical:{
								field:'password',
								message:'两次密码不一致'
							} 
						}
						
					}
				}
			});
			
			//
			if('${msg}'){
				layer.alert('${msg}',{
					icon:5
				})
			}
			
		})
	</script>
</body>
</html>