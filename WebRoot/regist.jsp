<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 <body >
 
    <form name="fm" action="${pageContext.request.contextPath}/user/registUserAction" method="post"  >
    <div align="center">
      <table  align="center" border="0">
        <tr>
          <td>用户名:</td>
          <td><input type="text" name="user.username" size="15"/></td>
           <td><font color="red"><s:property value="errors.name[0]"/>
           </font></td>
        </tr>
        <tr>
          <td>密码:</td>
          <td><input type="password" name="user.password" size="15" /></td>
      
           <td><font color="red"><s:property value="errors.psw[0]"/>
           </font></td>
        </tr>
        <tr>
          <td>新密码:</td>
          <td><input type="password" name="newpsw" size="15" /></td>
          <td><font color="red"><s:property value="errors.npsw[0]"/>
           </font></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="确定"/></td>
          
        </tr>
      </table>
      </div>
    </form>
   
    <p align="left"><a href="index.jsp">&lt;&lt;back</a></p>
  </body>
</html>
