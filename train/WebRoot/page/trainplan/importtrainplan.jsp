<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<script language="javascript" type="text/javascript" src="<%=path%>/js/DatePicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<script language="javascript"> 

	 function tijiao() {
	      var authoU = "${authoU}";   
		  if(authoU=="U")
		  { 
		  var chutuan=document.getElementById("chutuan").value; 
		  }
		  
          var year=document.getElementById("year").value; 
		 
	
		  if(authoU=="U"&&chutuan=="wu")
		  {
			  alert("请选择培训实施层级！");
			  document.getElementById("chutuan").focus();return;
		   }
		  if(year=="wu")
		   {
			  alert("请选择导入计划表年份！");
			  document.getElementById("year").focus();return;
			}

		 	
		       with(document.forms[0]) {
						
						action='importtrainplan.action';
						method="post";
						submit();
					}
				
			
	  }
function download()
{
   window.location="<%=path%>/templet/trainplan.xls";
}

function show()
{
   var pchu = document.getElementById("chu").value;
   var newnumber = document.getElementById("newnumber").value;

   window.location="<%=path%>/showchuplan.action?chu="+pchu+"&newnumber="+newnumber;
}

</script>
<title>数据导入</title>
</head>
<body>

	<div class="layout" style="width:1200px">
		<form name="filename" method="post" action="importtrainplan.action"
			enctype="multipart/form-data">
			<div  style="width:1200px;text-align:center; font-size:26px; border-bottom:1px solid #AED0EA;line-height:36px; "><b>培训计划表导入,选择上传文件</b></div>
			<div id="content" style="width:1200px">
				<div class="four_columns">
					
					<div style="text-align:center;">
						<input type="file" name="file"  style="width:300px"/>
				        	<c:if test="${authoU=='U'}">
									培训实施层级
									<select id="chutuan" name="chutuan" style="width: 100px">
										<option value="wu">-请选择-</option>
										<option value="11">总行</option>
										<option value="12">分行</option>
										<option value="13">中心</option>
										<option value="14">分中心</option>
										<option value="15">其他</option>		
									</select>
							</c:if>
				        <input type="hidden" id="chu" name="chu" value="${chu}"/>&nbsp;&nbsp;&nbsp;
				                                          导入计划表年份：
									<select id="year" name="year" style="width: 100px">
										<option value="wu">请选择年份</option>
										 <c:forEach items="${listyear}" var="eachyear" varStatus="status">
        						          <option value="${eachyear}">${eachyear}</option>
        				                 </c:forEach>										
									</select>&nbsp;&nbsp;&nbsp;							
						 <input style="width:100px" type="button" onclick="tijiao()" value="上 传"/>
					</div>
						<br/>
					<div  style="text-align:center;">
						
						 <input type="button" style="width:200px" onclick="download()" value="培训计划模板下载">
						  <input type="button" style="width:200px" onclick="show()" value="查看本人上传计划">
						  <input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
					</div>
				</div>
			</div>
		</form>
		
	</div>
	<br/>
	
	
	<!--  
	<div class="layout">
			<form name="filename" method="post" action="exportkqjl.action"
			enctype="multipart/form-data">
			<div class="title">导出</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_input">
						 <select name="year">
						 	<option value="${year1}">${year1}</option>
						 	<option value="${year2}">${year2}</option>
						 </select>年
						  <select name="month">
						 	<option value="01">1</option>
						 	<option value="02">2</option>
						 	<option value="03">3</option>
						 	<option value="04">4</option>
						 	<option value="05">5</option>
						 	<option value="06">6</option>
						 	<option value="07">7</option>
						 	<option value="08">8</option>
						 	<option value="09">9</option>
						 	<option value="10">10</option>
						 	<option value="11">11</option>
						 	<option value="12">12</option>
						 </select>月
					</div>
					<div class="four_columns_input">
						 <input type="radio" name="type" value="daily" checked/>明细
					</div>
					<div class="four_columns_input">
						<input type="radio" name="type" value="month" />月报
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="导出">
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
	-->
	
</body>
</html>