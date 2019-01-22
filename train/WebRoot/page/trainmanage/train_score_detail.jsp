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

   function tijiao()
	{
		
		var score1 = document.getElementById("score1").value; 
		var score2 = document.getElementById("score2").value; 
		var score3 = document.getElementById("score3").value; 
		var score4 = document.getElementById("score4").value; 
		var score5 = document.getElementById("score5").value; 
		var score6 = document.getElementById("score6").value; 
		var score7 = document.getElementById("score7").value; 
		var score8 = document.getElementById("score8").value; 
		var score9 = document.getElementById("score9").value; 
		var score10 = document.getElementById("score10").value; 
		
		if(Number(score1)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score1").focus();return;
		}
		if(Number(score2)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score2").focus();return;
		}
		if(Number(score3)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score3").focus();return;
		}
		if(Number(score4)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score4").focus();return;
		}
		if(Number(score5)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score5").focus();return;
		}
		if(Number(score6)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score6").focus();return;
		}
		if(Number(score1)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score1").focus();return;
		}
		if(Number(score7)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score1").focus();return;
		}
		if(Number(score8)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score8").focus();return;
		}
		if(Number(score9)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score9").focus();return;
		}
		if(Number(score10)>10)
		{
		      alert("分数不能大于10！");
			  document.getElementById("score10").focus();return;
		}
		 if(trim(score1)=="")
		  {
			  alert("请填写分数！");
			  document.getElementById("score1").focus();return;
			}
			
		if(trim(score2)=="")
		  {
			  alert("请填写分数！");
			  document.getElementById("score2").focus();return;
			}
		if(trim(score3)=="")
		  {
			  alert("请填写分数！");
			  document.getElementById("score3").focus();return;
			}
		if(trim(score4)=="")
		  {
			  alert("请填写分数！");
			  document.getElementById("score4").focus();return;
			}
			
		if(trim(score5)=="")
		  {
			  alert("请填写分数！");
			  document.getElementById("score5").focus();return;
			}
			
		if(trim(score6)=="")
		  {
			  alert("请填写分数！");
			  document.getElementById("score6").focus();return;
			}
			
		if(trim(score7)=="")
		  {
			  alert("请填写分数！");
			  document.getElementById("score7").focus();return;
			}
			
		if(trim(score8)=="")
		  {
			  alert("请填写分数！");
			  document.getElementById("score8").focus();return;
			}
			
		if(trim(score9)=="")
		  {
			  alert("请填写分数！");
			  document.getElementById("score9").focus();return;
			}
			
		if(trim(score10)=="")
		  {
			  alert("请填写分数！");
			  document.getElementById("score10").focus();return;
			}
			

		 
		  with(document.forms[0]) {
			action='subscoredetail.action';
			method="post";
			submit();
		  }
	}
	
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
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
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>${tm.programname}培训评估</strong><strong> </strong></p>
      
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		
    	<tr height="40" >
    			<td width="600" class="as" colspan="6">
    				评分标准为(1分-10分)1分为很差，10分为很好
    			</td>
    		
    		</tr>
    		<tr height="50">
    			<td width="100" class="as" >
    				指标
    			</td>
    			<td width="100" class="as" >
    				组织有序
    			
    			</td>
    			<td width="100" class="as" >
    				内容丰富
    			</td>
    			<td width="100" class="as" >
    				重点突出
    			</td>
    			<td width="100" class="as" >
    				思路清晰
    			</td>
    			<td width="100" class="as" >
    				感染力强
    			</td>
    			
    			
    		</tr>
    		
    		<tr height="50">
    			<td width="100" class="as" >
    				得分：
    			</td>
    			<td width="100" class="as" >
    				<input  id="score1" name="score1" style="width:90px" type="text" />
    			</td>
    			<td width="100" class="as" >
    				<input  id="score2"  name="score2" style="width:90px" type="text" />
    			</td>
    			<td width="100" class="as" >
    				<input  id="score3" name="score3"  style="width:90px" type="text" />
    			</td>
    			<td width="100" class="as" >
    				<input  id="score4" name="score4"  style="width:90px" type="text" />
    			</td>
    			<td width="100" class="as" >
    				<input  id="score5"  name="score5" style="width:90px" type="text" />
    			</td>
    			
    			
    		</tr>
    		
       <tr height="50">
    			<td width="100" class="as" >
    				指标
    			</td>
    			<td width="100" class="as" >
    				资料完备
    			</td>
    			<td width="100" class="as" >
    				注重实效
    			</td>
    			<td width="100" class="as" >
    				开展及时
    			</td>
    			<td width="100" class="as" >
    				引发思考
    			</td>
    			<td width="100" class="as" >
    				前瞻性
    			</td>
    			
    			
    		</tr>
    		
    		<tr height="50">
    			<td width="100" class="as" >
    				得分：
    			</td>
    			<td width="100" class="as" >
    				<input  id="score6" name="score6" style="width:90px" type="text" />
    			</td>
    			<td width="100" class="as" >
    				<input  id="score7"  name="score7" style="width:90px" type="text" />
    			</td>
    			<td width="100" class="as" >
    				<input  id="score8" name="score8"  style="width:90px" type="text" />
    			</td>
    			<td width="100" class="as" >
    				<input  id="score9" name="score9"  style="width:90px" type="text" />
    			</td>
    			<td width="100" class="as" >
    				<input  id="score10"  name="score10" style="width:90px" type="text" />
    			</td>
    			
    			
    		</tr>
    		<tr height="40" >
    			<td width="200" class="as" colspan="2">
    				改进建议：
    			</td>
    		<td width="400" class="as" colspan="4">
    				<input  id="remark" name="remark" style="width:390px" type="text" />
    			</td>
    		</tr>
    		
    		
    		<tr height="40" >
    			
    		<td width="600" class="as" colspan="6">
    				<input type="button" onclick="tijiao()" value="提  交" />
    				<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" id="number" name="number" value="${tm.number}"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
