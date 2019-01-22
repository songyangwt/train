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
var year = "${year}";
years(year); 
var x=document.getElementsByName("para");
$('#year').attr('value',x[0].value);

 });
 
function years(year){

var arry= new Array();
arry=[(Number(year)+1).toString(),year,year-1,year-2,year-3,year-4];
var obj=document.getElementById('year'); 
obj.options.length=0;
obj.options.add(new Option("-请选择年份-","wu"));

for (var i=0;i<arry.length;i++){	

	obj.options.add(new Option(arry[i],arry[i])); //这个兼容IE与firefox 
}
} 

 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form action="<%=path%>/showtrainplanallyear.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="13" align="center" bordercolor="#FFFFFF"><b>${year}年度培训计划表</b>
							</td>
						</tr>
						<tr>
							<td colspan="13" height="10px">
								<div align="center">
															
									年份
									<select id="year" name="year" style="width: 100px">
										<option value="wu">请选择年份</option>										
									</select>						
								
									<input type="submit" value="查询"/>
									<input type="hidden" name="para" value="${year}"/>
									
							</div></td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="130px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训实施层级</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>项目经理</p>
								</div></td>	
							<td  width="200px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训内容</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训对象</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训时间</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训地点</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>备注</p>
								</div></td>	
							
																
						</tr>
							<c:forEach items="${listtp}" var="tp" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="130px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:chutostring(tp.chu)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tp.manager}</div></td>
								<td width="200px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tp.content}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tp.people}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tp.time}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tp.location}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tp.remark}</div></td>		
									
								
								
							</tr>
							</c:forEach>
						
		</table>
		</form>
  </body>
</html>
