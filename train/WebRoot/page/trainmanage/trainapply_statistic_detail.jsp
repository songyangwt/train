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

   function showscoredetail()
   {
   		 var number=document.getElementById("number").value;
   		 window.location = "<%=path%>/showstatisticscoredetail.action?number="+number;  
   }
   
   function showremarkdetail()
   {
   		 var number=document.getElementById("number").value;
   		 window.location = "<%=path%>/showstatisticremarkdetail.action?number="+number;  
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
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>${tm.programname}结果统计</strong><strong> </strong></p>
      
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    
          
             <tr height="50">
    			<td width="150" class="as" >
    				培训名称：
    			</td>
    			<td width="150" class="as" >
    				${tm.programname}
    			</td>
    			<td width="150" class="as" >
    				培训层级：
    			</td>
    			<td width="150" class="as" >
    				${fb:chutostring(tm.chu)} 
    			</td>
    			
             </tr> 
             
              <tr height="50">
    			<td width="150" class="as" >
    				培训类型：
    			</td>
    			<td width="150" class="as" >
    				${fb:typetostring(tm.type)}
    			</td>
    			<td width="150" class="as" >
    			            培训时间：
    			</td>
    			<td width="150" class="as" >
    				 ${fb:timetoshow(tm.time)} 
    			</td>
    			
             </tr> 
             
              
              <tr height="50">
    			<td width="150" class="as" >
    				培训地点：
    			</td>
    			<td width="150" class="as" >
    				${tm.location}
    			</td>
    			<td width="150" class="as" >
    			            项目经理：
    			</td>
    			<td width="150" class="as" >
    				${tm.manager}
    			</td>
    			
             </tr> 
           
            <tr height="50">
    			<td width="150" class="as" >
    				培训报名人数：
    			</td>
    			<td width="150" class="as" >
    				${trainpeoplenum}
    			</td>
    			<td width="150" class="as" >
    				培训签到人数：
    			</td>
    			<td width="150" class="as" >
    				
    				<c:if test="${tm.isregister==1}">
    				${signpeoplenum}
    				</c:if>
    				 <c:if test="${tm.isregister==2}">
    			           此培训无签到
    			   </c:if>
    				
    				
    			</td>
    			
             </tr> 
             
           
             
              <tr height="50">
    			<td width="150" class="as" >
    				完成测试人数：
    			</td>
    			<td width="150" class="as" >
    			  <c:if test="${tm.isexam==1}">
    				${exampeoplenum} 
    				</c:if>
    				 <c:if test="${tm.isexam==2}">
    			           此培训无测试
    			   </c:if>
    			
    			</td>
    			<td width="150" class="as" >
    				完成评估人数：
    			</td>
    			<td width="150" class="as" >
    				<c:if test="${tm.isevaluate==1}">
    				${markpeoplenum} 
    				</c:if>
    				 <c:if test="${tm.isevaluate==2}">
    			           此培训无评估
    			   </c:if>
    			</td>
             </tr> 
             
        
            <c:if test="${tm.isexam==1}">
              <tr height="50">
    			<td width="150" class="as" >
    				考试得分：
    			</td>
    			<td width="450" class="as" colspan="3" >		
    				<c:forEach items="${listexamscore}" var="pxsq" varStatus="status">
    				${pxsq}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				</c:forEach>
    				<br>	 		 
    			</td>
    			
             </tr> 
             </c:if>
    			<c:if test="${tm.isevaluate==1}">	  
              <tr height="50">
    			<td width="150" class="as" >
    				培训评估得分：
    			</td>
    			<td width="300" class="as" colspan="2">
    			 平均分：${avg} &nbsp;&nbsp;&nbsp;&nbsp;最高分：${top1} &nbsp;&nbsp;&nbsp;&nbsp;最低分：${low}&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    		  <td width="150" class="as" >
    				<input type="button" onclick="showscoredetail()" value="查看评分详情" />
    			</td>
    			
             </tr>
                  
                <tr height="50">
    			<td width="150" class="as" >
    				相关建议：
    			</td>
    			<td width="300" colspan="2" >
    			         一共有${peoplemarknum}条建议
    				<!--<c:forEach items="${peopleremark}" var="pxsq" varStatus="status">-->
    				<!--<span>${status.index+1}</span>--> <!--  ${pxsq} <br>-->
    				<!--</c:forEach>-->
    				
    				
    			</td>
    			 <td width="150" class="as" >
    				<input type="button" onclick="showremarkdetail()" value="查看建议详情" />
    			</td>
    			
             </tr> 
             </c:if>
    		
    		<tr height="40" >
    			
    		<td width="600" class="as" colspan="4">
    				
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    				<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" id="number" name="number" value="${tm.number}"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
