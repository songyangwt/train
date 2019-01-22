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
});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form  method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b>待评估</b>
							</td>
						</tr>
	
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
									<p>培训层级</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训经理</p>
								</div></td>			
					
							<td  width="140px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>												
						</tr>
							<c:forEach items="${list}" var="pxsq" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="125px" height="25" align="center" valign="middle" nowrap><div
										align="center">${pxsq.number}</div></td>
								<td width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center">${pxsq.date}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:typetostring(pxsq.type)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${pxsq.programname}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:chutostring(pxsq.chu)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${pxsq.manager}</div></td>
							
						
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">									
										<a href="<%=path%>/showscoredetail.action?number=${pxsq.number}&newnumber=${newnumber}">开始评估</a>
										</div></td>	
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="14">
					
								<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
							
								<br/>
							</td>
						</tr>
		</table>
		</form>
  </body>
</html>

