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

   $(document).ready(function(){ 
     var people = "${tm.people}";
     if(people=="")
     {
     	$("#trainpeople").css('display','none');
     }
     
    });	
   
   
    function download(name)
	{
	    var filename = name;
		//window.open("<%=path%>/file/docfile/"+filename,"","height=10,width=10,top=400,left=600");
		window.open("<%=path%>/file/docfile/"+filename,"","height=1000,width=1000,top=1200,left=1400");
		window.close();
	}
	
	  function sel(o)
    {
	  if(o==11)
	  {
		  document.getElementById("xuanze").style.display="inline-block";
			
		}else{
			alert("请确认您选择的意见是【不同意】");
			document.getElementById("xuanze").style.display="none"; 
		} 
	 } 
	function tijiao() {
	  var radio=document.getElementsByName("radio");
	  var xuanze = document.getElementById("xuanze").value;
	  var message = "确认提交？";
	  if(radio[0].checked!=true&&radio[1].checked!=true)
		{
			alert("请选择审批意见");
		}
	  else if(xuanze=="wu"&&radio[0].checked==true)
		{
			alert("请选择下一级审批人");
		}
		else
		{
			if (window.confirm(message)) {
				with(document.forms[0]) {
					action='trainapplyshenpi.action';
					method="post";
					submit();
				}
			}
		}
  }
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
		}  
		
      function onlyNum() {
           if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39))
           if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
           event.returnValue=false;
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
    <form action="subtrainapplypage.action" method="post">
    		<br>
    			<br>
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心成都分中心培训申请表</strong><strong> </strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as" rowspan='3'>
    				培训类型<b>*</b>
    			</td>
    			<td  class="as" >
    			 培训种类：  
    			</td>
    			<td  class="as"  colspan="2">
    			  ${fb:typetostring(tm.type)} 
    			</td>
    		
    		</tr>
    		<tr>
    			<td  class="as" >
    			是否开放报名：
    			</td>
    			<td  class="as"  colspan="2">
    			   ${fb:isbaotostring(tm.issign)}
    			</td>
    				
    		</tr>
    		
    		<tr>
    			<td  class="as" >
    			 是否需要签到：
    			</td>
    			<td  class="as"  colspan="2">
    			   ${fb:isqiantostring(tm.isregister)} 
    			</td>
    				
    		</tr>
    		<tr>	
    			<td width="150" class="as">
    				培训项目名称<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				${tm.programname}
    			</td>
    		</tr>
    		
    		<tr height="40">
    			<td  class="as" >
    				培训层级<b>*</b>
    			</td>
    			<td width="150" class="as" >
    			${fb:chutostring(tm.chu)} 
    			<input  id="chu" name="chu" type="hidden" />
    			</td>
    			<td width="100" class="as" >
    				培训项目经理及联系方式<b>*</b>
    			</td>
    			<td width="250"  >
    			 姓名：${tm.manager}
    			 电话：${tm.tel} 

    			</td>
    			
    		</tr>
    		
    			
    		<tr height="40">
    			<td  class="as" >
    				培训时间<b>*</b>
    			</td>
    			<td width="150" class="as" >
    				
    			   ${fb:timetoshow(tm.time)} 
    				
    			</td>
    			<td width="100" class="as" >
    				培训地点<b>*</b>
    			</td>
    			<td width="250"  >
    			   ${tm.location} 
    			
    			</td>
    			
    		</tr>
    		<tr height="40">
    			<td  class="as" >
    				是否考试<b>*</b>
    			</td>
    			<td width="150" class="as" >
    			  ${fb:isexamtostring(tm.isexam)} 
    			
    			</td>
    			<td width="100" class="as" >
    				是否评估<b>*</b>
    			</td>
    			<td width="250"  >
    			  ${fb:isevaluatetostring(tm.isevaluate)}
    			  			
    			</td>
    		</tr>
    		
    	     <tr>	
    			<td width="150" class="as">
    				培训讲师<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				${tm.teacher}
    				
    			</td>
    		</tr>
    		
    		<tr>	
    			<td width="150" class="as">
    				培训内容<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				
    				${tm.content}
    				
    			</td>
    		</tr>
    		
    		
    		<tr id="trainpeople">	
    			<td width="150" class="as">
    				培训对象<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				
    				${tm.people} 
    				<br/>
    			</td>
    		</tr>
    		<tr>	
    		<td width="150" class="as">
    				相关要求
    			</td>
    			<td width="500" class="as" colspan="3">
   				
    				${tm.requirement }
    			</td>
    		</tr>
    		<tr>
    	    <td width="150" class="as">
    				培训课件
    			</td>
    			<td id="fi" width="380" class="as" colspan="3">
    			<c:forEach items="${listtf}" var="tf" varStatus="status">
    				<a	href="javascript:download('${tf.name}')">${tf.filename}</a><br>
    			</c:forEach>	
    			</td>	
    		    
    		</tr>
    		<tr>
    	    <td width="150" class="as">
    				审批意见<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				<c:if test="${(undersign=='U')||undersign=='V'}"> 
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						不同意
     					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="textfield" >
    				</c:if> 
    			
    				
    			</td>
    		</tr>
    		
    		<tr>
    	    <td width="150" class="as">
    				备注
    			</td>
    			<td width="500" class="as" colspan="3">
    				${tm.remark}
    				
    			</td>
    		</tr>
    		
          <c:if test="${youshenpi==1}"> 
    		<tr height="40">
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td width="500"  class="as" colspan="3">
    				<select name="thisunder" id="xuanze">
        				<option value="wu">请选择下一级审批人</option>
        					<c:forEach items="${list}" var="user" varStatus="status">
        						<option value="${user.newnumber}">${user.username}</option>
        					</c:forEach>
        			</select>
    			</td>
    		</tr>
    		</c:if>
    		<c:if test="${youshenpi!=1}"> 
    			<input type="hidden" id="xuanze" name="xuanze" value=""/>
    		</c:if>
    		<tr height="40">
    			<td>
    				&nbsp;
    			</td>
    		<td width="500" class="as" colspan="3">
    		        <input type="hidden" id="number" name="number" value="${tm.number}"/>
    				<input type="hidden" name="thisunder" value="${undersign}"/>
    				<input type="hidden" name="thisnewnumber" value="${newnumber}"/>
    				<input type="hidden" name="thisundername" value="${username}"/>
    				<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
