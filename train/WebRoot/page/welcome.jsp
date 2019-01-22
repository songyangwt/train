<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ffffff;
}
-->
</style>
<script type="text/javascript">
$(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
   var length1=document.getElementById("listwb").value;
   var length2=document.getElementById("listwb2").value;
  
   if(Number(length1)!=0)
   {
    
   	 document.getElementById("scroll1").style.height=Number(length1)*30+'px';
   	 //alert(Number(length1)*30+'px');
   }
   if(Number(length1)>30)
     {
     	document.getElementById("scroll1").style.height='900px';
     	//alert("450px");
     }
     
    
   if(Number(length2)!=0)
   {
    
   	 document.getElementById("scroll2").style.height=Number(length2)*30+'px';
   	 //alert(Number(length1)*30+'px');
   }
   if(Number(length2)>30)
     {
     	document.getElementById("scroll2").style.height='900px';
     	//alert("450px");
     }

 
 });
 
 
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
 <form action="" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0" cellspacing="2" >
					  <c:if test="${fn:length(listwb)!=0}">  	
						<tr>
							 <td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>待办事宜</b>
							</td>
						</tr>
					<tr>
			        <td style="padding-left:1px">
						<table height="80" align="center" cellpadding="0" cellspacing="2" >
					<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="125px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>	
						
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训类型</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训项目名称</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>实施部门</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训经理</p>
								</div></td>			
					
							<td  width="80px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>当前承办人</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>		
							<td  width="140px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>												
						</tr>
						</table>
						</td>
					</tr>
					<tr>
			        <td style="padding-left:18px">
			         <div id="scroll1" align="center" style="overflow-y: scroll; overflow-x: hidden;height:200px">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
					<c:forEach items="${listwb}" var="wb" varStatus="status">
				<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="125px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.number}</div></td>
								<td width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.date}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:typetostring(wb.type)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.programname}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:chutostring(wb.chu)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.manager}</div></td>
							
								<td width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(wb.thisunder)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:statustostring(wb.status)}</div></td>
								 
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">
									
										<c:if test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletetrainapplypage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewtrainapplydetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										</c:if>
                                         <c:if test="${wb.status==1}">
                                               <a href="<%=path%>/viewtrainapplyunderdetail.action?number=${wb.number}">处理</a>
                                         </c:if>
                                          <c:if test="${wb.status==2}">
                                              <a href="<%=path%>/showtrainapplynotice.action?number=${wb.number}&newnumber=${newnumber}">发布培训公告</a>
                                          </c:if>
                                          <c:if test="${wb.status==3&&wb.isregister==1}">
										  <a href="<%=path%>/maketrainsheet.action?number=${wb.number}&newnumber=${newnumber}">生成签到表</a>
		
										  </c:if>
										  
										  <c:if test="${wb.status==3&&wb.isregister==2}">
										  <a href="<%=path%>/issuescore.action?number=${wb.number}&newnumber=${newnumber}">发布评估信息</a>
										  </c:if>
									      <c:if test="${wb.status==10&&wb.isregister==1}">
										  <a href="<%=path%>/returntrainsheet.action?number=${wb.number}&newnumber=${newnumber}">反馈签到表</a>
										  </c:if>
									      
									       <c:if test="${wb.status==9}">
										 	<a href="<%=path%>/showscoredetail.action?number=${wb.number}&newnumber=${newnumber}">开始评估</a>
										  </c:if>
										</div></td>	
							</tr>
									</c:forEach>
								</table>
			                     </div>  
			                     </td>	
			            </tr>
			            </c:if>	
		<!--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 培训公告 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■--> 	            
			             <c:if test="${fn:length(listwb2)!=0}">  	
			            <tr>
							 <td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>培训公告</b>
							</td>
						</tr>
					<tr>
			        <td style="padding-left:1px">
						<table height="80" align="center" cellpadding="0" cellspacing="2" >
						 <tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="125px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>	
						
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训类型</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训项目名称</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>实施部门</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训经理</p>
								</div></td>			
					
							<td  width="80px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>当前承办人</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>		
							<td  width="200px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>												
						</tr>
						</table>
						</td>
					</tr>
					<tr>
			        <td style="padding-left:18px">
			         <div id="scroll2" align="center" style="overflow-y: scroll; overflow-x: hidden;height:200px">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
					<c:forEach items="${listwb2}" var="wb" varStatus="status">
					<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="125px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.number}</div></td>
								<td width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.date}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:typetostring(wb.type)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.programname}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:chutostring(wb.chu)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.manager}</div></td>
							
								<td width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(wb.thisunder)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:statustostring(wb.status)}</div></td>
								 
								<td width="200px" height="25" align="center" valign="middle" nowrap><div
										align="center">
									   
										<a href="<%=path%>/viewtrainnoticedetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a>
									
										</div></td>	
							  </tr>
									</c:forEach>
								</table>
			                     </div>  
			                     </td>	
			            </tr>
			              </c:if>	
		 		
			
				  <input type="hidden" id="listwb" value="${fn:length(listwb)}"/>
				  <input type="hidden" id="listwb2" value="${fn:length(listwb2)}"/>
				  		
		</table>
		<br><br><br><br><br>
		</form>
  </body>
 
</html>
