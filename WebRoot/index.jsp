<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登陆界面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="CSS/main.css">
<script type="text/javascript">
</script>
</head>
<body>
	<form name="frmLogin" action="${pageContext.request.contextPath}/user/loginUserAction" method="post">
		<div align="center">
			<table align="center" border="0">
				<tr>
					<td>用户名
					<td><input type="text" name="user.username" size="15" value="${user.username}" />
					</td>
					<td><font color="red"><s:property
								value="errors.name[0]" /> </font>
					</td>
				</tr>
				<tr>
					<td>密码
					</td>
					<td><input type="password" name="user.password" size="15" value="${user.password}"/>
					
					</td>
					<td><font color="red"><s:property value="errors.psw[0]" />
					</font>
					</td>
				</tr>

			</table>
		</div>
		<p align="center">
			<input type="submit" value="登陆" /> &nbsp;&nbsp;
			  <a href = "regist.jsp">
			   注册
			 </a>
			 </p>
		<p>
	</form>

</body>
</html>