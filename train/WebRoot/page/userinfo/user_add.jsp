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
		<script type="text/javascript" src="<%=path%>/js/userajax.js"></script>
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<link href="<%=path%>/css/add.css" type="text/css"
			rel="stylesheet" />
<style type="text/css">
  .as {
	text-align: center;
}
 span{
	color:red;
  }
  </style>
  <script type="text/javascript">

  </script>
	</head>
	<body>
		<form action="<%=path%>/useradd.action" method="post">
			
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';" align="center" bordercolor="#FFFFFF">
					<b>员工信息增加</b>
				</div>
               <table width="500"  height="300" border="1" align="center" cellpadding="1" cellspacing="0">
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">新一代编号</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<input style="width:280px"  type="text" id="newnumber" name="newnumber" onkeyup="this.value=value.replace(/[^\d.]/g,'')"  onafterpaste="this.value=value.replace(/[^\d.]/g,'')"/> 
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">姓名</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<input style="width:280px"  type="text" id="name" name="name" /> 
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">密码</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<input style="width:280px"  type="password" id="password" name="password" /> 
    				密码长度应该在6-20之间
    				
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
										
										<option value="U">中心培训管理员</option>
										<option value="V">处室培训管理员</option>
										<option value="E">普通角色</option>
						</select>
    				
    			</td>
    			
    		</tr>
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">操作</span><span></span>
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


