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
     var people = "${tm.people}";
     if(people=="")
     {
     	$("#trainpeople").css('display','none');
     }
     
    });	

    function download(name)
	{
	    var filename = name;
		//window.open("<%=path%>/file/docfile/"+filename,"","height=10,width=10,top=400,left=600");
		window.open("<%=path%>/file/docfile/"+filename,"","height=1000,width=1000,top=1200,left=1400");
		window.close();
	}
	
	function tijiao()
	{
		  with(document.forms[0]) {
			action='fabunotice.action';
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
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心成都分中心培训公告</strong><strong> </strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as" rowspan='3'>
    				培训类型<b>*</b>
    			</td>
    			<td  class="as" >
    			 培训种类：  
    			</td>
    			<td  class="as"  colspan="2">
    			  ${fb:typetostring(tm.type)} 
    			</td>
    		
    		</tr>
    		<tr>
    			<td  class="as" >
    			是否开放报名：
    			</td>
    			<td  class="as"  colspan="2">
    			   ${fb:isbaotostring(tm.issign)}
    			</td>
    				
    		</tr>
    		
    		<tr>
    			<td  class="as" >
    			 是否需要签到：
    			</td>
    			<td  class="as"  colspan="2">
    			   ${fb:isqiantostring(tm.isregister)} 
    			</td>
    				
    		</tr>
    		<tr>	
    			<td width="150" class="as">
    				培训项目名称<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				${tm.programname}
    			</td>
    		</tr>
    		
    		<tr height="40">
    			<td width="150"  class="as" >
    				培训层级<b>*</b>
    			</td>
    			<td width="150" class="as" >
    			${fb:chutostring(ui.chu)} 
    			<input  id="chu" name="chu" type="hidden" />
    			</td>
    			<td width="100"  class="as" >
    				培训项目经理及联系方式<b>*</b>
    			</td>
    			<td width="250"   >
    			 姓名：${tm.manager}<br>
    			 电话：${tm.tel} 

    			</td>
    			
    		</tr>
    		
    			
    		<tr height="40">
    			<td  width="150"  class="as" >
    				培训时间<b>*</b>
    			</td>
    			<td width="150" class="as" >
    			   ${fb:timetoshow(tm.time)} 
    			   
    			</td>
    			<td width="100" class="as" >
    				培训地点<b>*</b>
    			</td>
    			<td width="250" class="as" >
    			   ${tm.location} 
    			
    			</td>
    			
    		</tr>
    		<tr height="40">
    			<td  class="as" >
    				是否考试<b>*</b>
    			</td>
    			<td width="150" class="as" >
    			  ${fb:isexamtostring(tm.isexam)} 
    			
    			</td>
    			<td width="100" class="as" >
    				是否评估<b>*</b>
    			</td>
    			<td width="250"  class="as" >
    			  ${fb:isevaluatetostring(tm.isevaluate)}
    			  			
    			</td>
    		</tr>
    		
    	     <tr>	
    			<td width="150" class="as">
    				培训讲师<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				${tm.teacher}
    				
    			</td>
    		</tr>
    		
    		<tr>	
    			<td width="150" class="as">
    				培训内容<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				
    				${tm.content}
    				
    			</td>
    		</tr>
    		
    		
    		<tr id="trainpeople">	
    			<td width="150" class="as">
    				培训对象<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				
    				${tm.people} 
    				
    			</td>
    		</tr>
    		<tr>	
    		<td width="150" class="as">
    				相关要求
    			</td>
    			<td width="500" class="as" colspan="3">
   				
    				${tm.requirement }
    			</td>
    		</tr>
    		<tr>
    	    <td width="150" class="as">
    				培训课件
    			</td>
    			<td id="fi" width="500" class="as" colspan="3">
    			<c:forEach items="${listtf}" var="tf" varStatus="status">
    				<a	href="javascript:download('${tf.name}')">${tf.filename}</a><br>
    			</c:forEach>	
    			</td>	
    		    
    		</tr>
    		
 	          
    		
    		<tr>
    	    <td width="150" class="as">
    				备注
    			</td>
    			<td width="500" class="as" colspan="3">
    				${tm.remark}   				
    			</td>
    		</tr>
    		
      
    		<tr height="40" >
    			<td width="150">
    				&nbsp;
    			</td>
    		<td width="500" class="as" colspan="3">
    				<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" id="number" name="number" value="${tm.number}"/>
    				 <input type="button" onclick="tijiao();" value="确认发布" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			    <input type="button" onclick="javascript:history.go(-1);" value="返回" />
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
