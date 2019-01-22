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
 $(document).ready(function(){ 
   var contentshow = "${tp.content}";
   var chu = "${tp.chu}";
   var text=document.getElementById("content");
   text.innerHTML = contentshow;
   $('#chu').attr('value',chu);
   
 });
 
 
 function tijiao() {
	 
		 		
		  var chu = document.getElementById("chu").value; 
		  var manager = document.getElementById("manager").value;
		  var time = document.getElementById("time").value;
		  var location = document.getElementById("location").value; 
		  var people = document.getElementById("people").value; 
		  var content = document.getElementById("content").value; 
		 // var people = document.getElementById("people").value;
		  
	
		  if(chu=="wu")
		  {
			  alert("请选择处室！");
			  document.getElementById("chu").focus();return;
		   }
		
		 if(trim(time)=="")
		  {
			  alert("请填写培训时间！");
			  document.getElementById("time").focus();return;
			}
		 if(trim(location)=="")
		  {
			  alert("请填写培训地点！");
			  document.getElementById("location").focus();return;
			}
		
		 if(trim(content)=="")
		  {
			  alert("请填写培训内容！");
			  document.getElementById("content").focus();return;
			}
		 if(trim(manager)=="")
		  {
			  alert("请填写培训经理！");
			  document.getElementById("manager").focus();return;
			}
		 if(trim(people)=="")
		  {
			  alert("请填写培训人员！");
			  document.getElementById("people").focus();return;
			}
		/* if(trim(people)=="")
		  {
			  alert("请填写参与培训人员！");
			  document.getElementById("people").focus();return;
		 }*/
		 
		 	
		    with(document.forms[0]) {
						
						action='trainplanmodify.action';
						method="post";
						submit();
					}
						
	  }
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
		}  
		
 </script>
	</head>
	<body>
		<form action="<%=path%>/trainplanmodify.action" method="post">
			
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';" align="center" bordercolor="#FFFFFF">
					<b>培训计划修改</b>
				</div>
               <table width="850"  height="300" border="1" align="center" cellpadding="1" cellspacing="0">
    		 
    		 <tr>
    			<td width="150" class="as" >
    				<span style="font-size:12pt;color:black">培训实施处室</span><span>*</span>
    			</td>
    			<td width="700" >
    				<c:if test="${authoU=='U'}"> 
    				<select id="chu" name="chu" style="width: 300px">
										<option value="wu">-请选择-</option>									
										<option value="11">总行</option>
										<option value="12">分行</option>
										<option value="13">中心</option>
										<option value="14">分中心</option>	
										<option value="1">综合与生产管理处</option>
										<option value="2">合规与监督二处</option>
										<option value="3">通用业务二处</option>
										<option value="5">研发支持二处</option>
										<option value="6">专业处理二处</option>
				   </select>
				   </c:if>
				   <c:if test="${authoU!='U'}"> 
				   ${fb:chutostring(tp.chu)} 
    			    <input  id="chu" name="chu" type="hidden" value="${ui.chu}"/>
    				<!-- <input style="width:660px" type="text" id="chu" name="chu" value="${fb:chutostring(tp.chu)}"  readonly="readonly"/>  -->	
    			  </c:if>
    			</td>
    			
    		</tr>
    		
    		
    		 <tr>
    			<td width="150" class="as" >
    				<span style="font-size:12pt;color:black">项目经理</span><span>*</span>
    			</td>
    			<td width="700" class="as">
    				<input style="width:660px" type="text" id="manager" name="manager" value="${tp.manager }"/> 
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="150" class="as" >
    				<span style="font-size:12pt;color:black">培训内容</span><span>*</span>
    			</td>
    			<td width="700" class="as">
    				
    				<textarea style="text-align:left;width:660px;height:100px" id="content" name="content" >
    				
					</textarea>
    				
    			</td>
    			
    		</tr>
    		  <tr>
    			<td width="150" class="as" >
    				<span style="font-size:12pt;color:black">培训对象</span><span>*</span>
    			</td>
    			<td width="700" class="as">
    				<input  style="width:660px" type="text" id="people" name="people" value="${tp.people}"/> 
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="150" class="as" >
    				<span style="font-size:12pt;color:black">培训时间</span><span>*</span>
    			</td>
    			<td width="700" class="as">
    			<input  style="width:660px" type="text" id="time" name="time" value="${tp.time}"/> 
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="150" class="as" >
    				<span style="font-size:12pt;color:black">培训地点</span><span>*</span>
    			</td>
    			<td width="700" class="as">
    				<input  style="width:660px" type="text" id="location" name="location" value="${tp.location}"/> 
    				
    				
    			</td>
    			
    		</tr>
    		
    		 <tr>
    			<td width="150" class="as" >
    				<span style="font-size:12pt;color:black">备注</span><span>*</span>
    			</td>
    			<td width="700" class="as">
    				<input  style="width:660px" type="text" id="remark" name="remark" value="${tp.remark}"/> 
    				 				
    			</td>
    			
    		</tr>
    		 
    		  <tr>
    			<td width="150" class="as" >
    				<span style="font-size:12pt;color:black">操作</span><span>*</span>
    			</td>
    			<td width="700" class="as">
    			    <input style="width: 80px" type="button" onclick="tijiao();" value="提交" />
    				<input style="width: 80px" type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  				
    			</td>
    			
    		</tr>
    		 <tr><td colspan="2"><div style="color:red"><s:fielderror></s:fielderror></div></td></tr>
   
    	</table>
				
					
			 <input type="hidden" name="id" value="${id}"/>
		     <input type="hidden" name="authoU" value="${authoU}"/>
		</form>
	</body>

</html>


