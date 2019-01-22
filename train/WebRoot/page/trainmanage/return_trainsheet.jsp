<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <title>My JSP 'authorityfailed.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
	<script type="text/javascript">
   $(document).ready(function(){ 
       var names = "${names}";
       var listname = names.split("、");
       for(var i=0;i<listname.length;i++)
       {
            var name = listname[i];
            $("#fi").append(" <input type='checkbox' id='sign"+i+"'  name='signname' /> "+name+"&nbsp;&nbsp;&nbsp;&nbsp;");
       }
            
   });
      
	function chooseall()
	{
	   var names = "${names}";
       var listname = names.split("、");     
       for(var i=0;i<listname.length;i++)
       {
           var idnum = "sign"+i;
           document.getElementById(idnum).checked=true;
       }
      
		
	}
	
	function quitchooseall()
	{
	  
	   var names = "${names}";
       var listname = names.split("、");
       for(var i=0;i<listname.length;i++)
       {
           var idnum = "sign"+i;
           document.getElementById(idnum).checked=false;
       }
	}
	
	function tijiao()
	{
		  with(document.forms[0]) {
			action='subreturntrainsheet.action';
			method="post";
			submit();
		  }
	}
			
</script>

 

  <style type="text/css">
  .as {
	text-align: center;
}
b{
	color:red;
}
  </style>
  </head>
  
  <body>  
 ${daohang}  
    <form  method="post">
    		<br>
    			<br>
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>${tm.programname}签到表</strong><strong> </strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    	  
    			<td id="fi" width="500" class="as" >
    			
    			</td>	
    		    
    		</tr>
    		
      
    		<tr height="40" >
    		
    		<td width="500" class="as" >
    				<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" id="number" name="number" value="${tm.number}"/>
    				<input type="button" onclick="chooseall();" value="全选" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="quitchooseall();" value="取消全选" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			    <input type="button" onclick="tijiao();" value="确认提交" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			     <input type="button" onclick="javascript:history.go(-1);" value="返回" />
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
