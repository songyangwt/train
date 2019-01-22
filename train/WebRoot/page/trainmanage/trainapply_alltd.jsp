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
var x=document.getElementsByName("para");
$('#chutuan').attr('value',x[0].value);

});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form action="<%=path%>/viewtrainapplyall.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b>明细查询</b>
							</td>
						</tr>
						
								<tr>
							<td colspan="26" height="10px">
								<div align="center">
									
									起始日期					
									<input size=10 type="text" name="begindate" id="begindate" class="Wdate" value="${begindate}" onClick="WdatePicker()" >
									截止日期
									<input size=10 type="text" name="enddate" id="enddate" class="Wdate" value="${enddate}" onClick="WdatePicker()" >
									<c:if test="${authoU=='U'||zhi=='1'}">
									培训层级
									<select id="chutuan" name="chutuan" style="width: 100px">
										<option value="0">全部</option>
										<option value="11">总行</option>
										<option value="12">分行</option>
										<option value="13">中心</option>
										<option value="14">分中心</option>
										<option value="15">其他</option>	
										<option value="1">综合与生产管理处</option>
										<option value="2">合规与监督二处</option>
										<option value="3">通用业务二处</option>
										<option value="5">研发支持二处</option>
										<option value="6">专业处理二处</option>
								
									</select>
									</c:if>
										
									<input type="hidden" name="para" value="${chutuan}"/>
									<input type="hidden" name="zxtd" value="td"/>							
									<input type="submit" value="查询"/>
									
							</div></td>	
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
							
								<td width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(pxsq.thisunder)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:statustostring(pxsq.status)}</div></td>
								 
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">
									    <c:if test="${(authoU=='U'||authoV=='V')&&(pxsq.status!=4)&&(pxsq.status!=6)}">
										<a onClick="return confirm('确定撤销?');"  href="<%=path%>/deletetrainapplypage.action?number=${pxsq.number}&newnumber=${newnumber}">撤销</a>
										&nbsp;&nbsp;
										</c:if>
										<a href="<%=path%>/viewtrainapplydetail.action?number=${pxsq.number}&newnumber=${newnumber}">查看详情</a>
										</div></td>	
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="14">
								<div align="center">
								<a	href="<%=path%>/viewtrainapplyall.action?zxtd=td&begindate=${begindate}&enddate=${enddate}&chutuan=${chutuan}&newnumber=${newnumber}&currentPage=${previousPage}&authoU=${authoU}&authoV=${authoV}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/viewtrainapplyall.action?zxtd=td&begindate=${begindate}&enddate=${enddate}&chutuan=${chutuan}&newnumber=${newnumber}&currentPage=${nextPage}&authoU=${authoU}&authoV=${authoV}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
									&nbsp;&nbsp;&nbsp;
								第<input style="width:30px" type="text" name="currentPage"/>页
								<input type="hidden" name="type" value="${type}"/>
								<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
								<input type="hidden" name="authoU" value="${authoU}"/>
								<input type="hidden" name="authoV" value="${authoV}"/>		
								<input type="submit" value="跳转"/>	
								</div>
								<br/>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>

