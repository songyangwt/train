<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form name="frmLogin" method="post"  action="<%=path%>/login.action" >
	<!-- <form name="frmLogin" method="post"  action="http://localhost:8080/security/login.action"  onsubmit="return validateLogin()">-->
 		<table width="282" height="172" border="0" align="center" >
     <tr>
     <td width="88" align="right" bordercolor="#FFFFFF"><div align="center">用  户</div></td>
     <td width="170" bordercolor="#FFFFFF"><input size=14 type="text" name="username"></td>
   </tr>
   

   
   <tr>
   
     <td colspan="2" align="center" bordercolor="#FFFFFF"><input  class="tijiao" name="submit" type="submit" id="submit" value="提交"></td>
   </tr>
 </table>
</form>
  </body>
</html>
