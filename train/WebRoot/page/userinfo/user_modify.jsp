<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>acceptance_data</title>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path%>/js/userajax.js"></script>
	
		<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<style type="text/css">
  .as {
	text-align: center;
}
 span{
	color:red;
  }
  </style>
  
  <script type="text/javascript">
$(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 

var chu=document.getElementById("parachu").value;

var zhi=document.getElementById("parazhi").value;
//var pos=document.getElementById("parapos").value;


var authoU=document.getElementById("authoU").value;
var authoV=document.getElementById("authoV").value;
//var canscore=document.getElementById("paracanscore").value;


$('#chu').attr('value',chu);

$('#zhiwu').attr('value',zhi);
//$('#canscore').attr('value',canscore);
if(authoU!="U"&&authoV!="V")
{
	$('#role').attr('value',E);
}
if(authoU=="U")
{
	$('#role').attr('value',authoU);
}
if(authoV=="V")
{
	$('#role').attr('value',authoV);
}
 
 });
 //var chu=document.getElementById("parachu").value;


 </script>
	</head>
	<body>
		<form action="<%=path%>/userupdate.action" method="post">
			
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';" align="center" bordercolor="#FFFFFF">
					<b>用户信息修改</b>
				</div>
               <table width="500"  height="300" border="1" align="center" cellpadding="1" cellspacing="0">
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">新一代编号</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<input style="width:280px"  type="text" id="newnumber" name="newnumber" onkeyup="this.value=value.replace(/[^\d.]/g,'')"  onafterpaste="this.value=value.replace(/[^\d.]/g,'')" value="${ui.newnumber}" /> 
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">姓名</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<input style="width:280px"  type="text" id="name" name="name" value="${ui.username}" /> 
    				
    			</td>
    			
    		</tr>
    		

   
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">职务</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<select style="width:280px"  id="zhiwu" name="zhiwu" >
    				                   <option value="wu">-请选择职务-</option>
										<option value="1">主任</option>
										<option value="3">处室负责人</option>
										<option value="4">团队负责人</option>
										<option value="5">班组长</option>
										<option value="6">经办岗</option>
										
						</select>
    				
    			</td>
    			
    		</tr>
    		
    		
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">处室</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<select style="width:280px"  id="chu" name="chu" >
						 <option value="wu">-请选择处室名称-</option>
						  <option value="111">中心领导</option>
						  <option value="1">综合与生产管理处</option>
						  <option value="2">合规与监督二处</option>	
						  <option value="3">通用业务二处</option>	
						  <option value="5">研发支持二处</option>	
						  <option value="6">专业处理二处</option>				                        
					</select>
    				
    			</td>
    			
    		</tr>
    		
    			
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">系统角色</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<select id="role" name="role" style="width: 280px">
										<option value="wu">-请选择系统角色-</option>
										<option value="E">普通用户</option>
									    <option value="U">中心培训管理员</option>
										<option value="V">处室培训管理员</option>
						</select>
    				
    			</td>
    			
    		</tr>
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">操作</span><span></span>
    				<input type="hidden" id="parazhi" name="parazhi" value="${zhi}"/>
					<input type="hidden" id="parachu" name="parachu" value="${chu}"/>
					<input type="hidden" id="pararole" name="pararole" value="${role}"/>
					<input type="hidden" id="authoU" name="authoU" value="${authoU}"/>
					<input type="hidden" id="authoV" name="authoV" value="${authoV}"/>
					<input type="hidden" id="paraid" name="paraid" value="${id}"/>
				
    			</td>
    			<td width="300" class="as">
    				<input style="width: 80px" type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				   <input style="width: 80px" type="submit" class="but" value="提交" />
    				
    			</td>
    			
    		</tr>
    		 <tr><td colspan="2"><div style="color:red"><s:fielderror></s:fielderror></div></td></tr>
    	</table>
				
					
			
		
		</form>
	</body>

</html>


