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

   function tijiao()
	{
		  var message = "确认强制结束？";
		  if (window.confirm(message)) {
		  with(document.forms[0]) {
			action='endtrainapply.action';
			method="post";
			submit();
		  }
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
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>${tm.programname}进程管理</strong><strong> </strong></p>
      
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    
    	<tr height="50">
    			<td width="250" class="as" >
    				是否反馈签到表：
    			</td>
    			<td width="250" class="as" >
    				
    				<c:if test="${tm.isregister==2}">
    				不签到，无需反馈
    				</c:if>
    				<c:if test="${tm.isregister==1}">
    				${isregister} 
    				</c:if>
    			</td>
    			
             </tr>
             
            <tr height="50">
    			<td width="250" class="as" >
    				参与培训人数：
    			</td>
    			<td width="250" class="as" >
    				
    				${trainpeoplenum}
    				
    			</td>
    			
             </tr> 
             
              <tr height="50">
    			<td width="250" class="as" >
    				培训签到人数：
    			</td>
    			<td width="250" class="as" >
    			  <c:if test="${tm.isregister==1}">
    				${signpeoplenum}
    				</c:if>
    				 <c:if test="${tm.isregister==2}">
    				此培训无需签到
    				</c:if>
    			</td>
    			
             </tr> 
             
              <tr height="50">
    			<td width="250" class="as" >
    				完成测试人数：
    			</td>
    			<td width="250" class="as" >
    				 <c:if test="${tm.isexam==1}">
    				${exampeoplenum}
    				</c:if>
    				 <c:if test="${tm.isexam==2}">
    				此培训无需考试
    				</c:if>
    				
    			</td>
    			
             </tr> 
             
              <tr height="50">
    			<td width="250" class="as" >
    				完成评估人数：
    			</td>
    			<td width="250" class="as" >
    				 <c:if test="${tm.isevaluate==1}">
    				${markpeoplenum} 
    				</c:if>
    				 <c:if test="${tm.isevaluate==2}">
    				此培训无需评估
    				</c:if>
    				 <c:if test="${(tm.status!=9)&&(tm.isevaluate==1)}">
    				评估尚未开始
    				</c:if>
    				 
    			</td>
    			
             </tr> 
              <c:if test="${tm.isexam==1}">
              <tr height="50">
    			<td width="250" class="as" >
    				未完成测试人员：
    			</td>
    			<td width="250" class="as" >
    				<c:forEach items="${unexampeople}" var="pxsq" varStatus="status">
    				${pxsq}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				</c:forEach>
    			    <br>
    			</td>
    			
             </tr> 
             </c:if>
             <c:if test="${tm.isevaluate==1}">
              <tr height="50">
    			<td width="250" class="as" >
    				未完成评估人员：
    			</td>
    			<td width="250" class="as" >
    				<c:forEach items="${unmarkpeople}" var="pxsq" varStatus="status">
    				${pxsq}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				</c:forEach>
    				<br>
    			</td>
    			
             </tr> 
    		</c:if>
    		<tr height="40" >
    			
    		<td width="500" class="as" colspan="2">
    				<input type="button" onclick="tijiao()" value="强制结束" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    				<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" id="number" name="number" value="${tm.number}"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
