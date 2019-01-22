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

    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <title>My JSP 'authorityfailed.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
	<script type="text/javascript">
	var num = 0;
	 $(document).ready(function(){ 
   
         $("#people").val("");
       
       });
     
	function tips()
	{
	
		alert("请先点击上传附件查看附件是否正确上传！");
	}
     function add()
     {
      
     	$("#fi").append("<input type='file' name='filen'  style='width:250px'/> ");
     	num++;
     	 
     }
	 function del()
	 {
	
	 	$("input[name='filen']").eq($("input[name='filen']").size()-1).remove();
	 	num--
	 }
	 
 /*function upload(num){
    
   
    var files =  document.getElementsByName("filen");
    var xmlhttp;
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			types=xmlhttp.responseText;
			arry=types.split("|"); 
			//alert(yesorno);
				
				//document.getElementById("chutuan").innerHTML=arr[0];
			 setfilename(types,num);
		}				
	} 
	xmlhttp.open("GET","uploadfile.action?num="+num+"&filen="+files,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}*/
function change(){


var chu=document.getElementById('chu').value;
var newnumber=document.getElementById('newnumber').value;

var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			yesorno=xmlhttp.responseText;
			
				var arr=yesorno.split("|");
				
					if(arr[1]=="xxxxxx")
					{
	                        alert("不能发起其他处室培训！");				
					}
					if(arr[1]=="xxxxxxxx")
					{
						alert("发起人为空！");	
					}
					//document.getElementById("chutuan").innerHTML=arr[0];
					bossname(arr[1]);
					//document.getElementById("identity").innerHTML=arr[2];
					
					//document.getElementById("username").innerHTML=arr[3]+arr[4];
			
					//document.getElementById("zxdate").innerHTML=arr[5];
					//document.getElementById("sex").value=arr[6];
					
					
		}				
	} 
	xmlhttp.open("GET","showtrainapplypageajax.action?chu="+chu+"&newnumber="+newnumber,true);
	xmlhttp.send();
}

function bossname(bossnames){

var arry= new Array();
arry=bossnames.split(";"); //字符分割 
var obj=document.getElementById('xuanze'); 
obj.options.length=0;
for (var i=0;i<arry.length;i++){	
	var brry= new Array();
	brry=arry[i].split(":");
	obj.options.add(new Option(brry[0],brry[1])); //这个兼容IE与firefox 
}
} 


	function upload()
	{
		with(document.forms[0]) {
			action='uploadfile.action';
			method="post";
			submit();
		}
	}

      /* function a(){	
		 $('#p').append("<input type='text' name='people' style='width:50px'/>");
		}
	  function b(){
		$("input[name='people']").eq($("input[name='people']").size()-1).remove();
		 }
		*/ 
    function hide()
    {
        var issign = document.getElementById("issign").value;
        if(issign==1)
        {
        	$("#trainpeople").css('display','none');
        } 
        if(issign==2)
        {
           $("#trainpeople").css('display','block');
        }  
    	
    }
	
	 function download(name)
	{
	    var filename = name;
		//window.open("<%=path%>/file/tempfile/"+filename,"","height=10,width=10,top=400,left=600");
		window.open("<%=path%>/file/tempfile/"+filename,"","height=1000,width=1000,top=1200,left=1400");
		window.close();
	}

	 function tijiao() {
	 
		  
		  var type=document.getElementById("type").value; 
		  var issign = document.getElementById("issign").value;
		  var isregister = document.getElementById("isregister").value;
		  var programname = document.getElementById("programname").value;
		  var chu = document.getElementById("chu").value; 
		  var manager = document.getElementById("manager").value;
		  var tel = document.getElementById("tel").value;
		  var time = document.getElementById("time").value;
		  var location = document.getElementById("location").value; 
		  var isexam = document.getElementById("isexam").value;
		  var isevaluate = document.getElementById("isevaluate").value;
		  var teacher = document.getElementById("teacher").value;
		  var content = document.getElementById("content").value; 
		  if(issign==2)
		  {
		  	var people = document.getElementById("people").value;
		  }
		  
		 // var requirement = document.getElementById("requirement").value;
		  //var remark = document.getElementById("remark").value;
		  var xuanze = document.getElementById("xuanze").value;
		     
	      if(Number(num)!=0)
	      {
	        tips();
	        return;
	      }
		  if(type=="wu")
		  {
			  alert("请选择培训类型！");
			  document.getElementById("type").focus();return;
		   }
		  if(issign=="wu")
		   {
			  alert("请选择是否报名！");
			  document.getElementById("issign").focus();return;
			}
		 if(isregister=="wu")
		  {
			  alert("请选择是否签到！");
			  document.getElementById("isregister").focus();return;
			}
		  if(trim(programname)=="")
		  {
			  alert("请填写项目名称！");
			  document.getElementById("programname").focus();return;
			}
		/*  if(chu=="wu")
		  {
			  alert("请选择实施部门！");
			  document.getElementById("chu").focus();return;
			  
		   }
		  if(trim(manager)=="")
		  {
			  alert("请填写培训经理！");
			  document.getElementById("manager").focus();return;
			}*/
		 if(trim(tel)=="")
		  {
			  alert("请填写联系方式！");
			  document.getElementById("tel").focus();return;
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
		
		/*  if(isexam=="wu")
		  {
			  alert("请选择是否考试！");
			  document.getElementById("isexam").focus();return;
		   }*/
		  if(isevaluate=="wu")
		   {
			  alert("请选择是否评估！");
			  document.getElementById("isevaluate").focus();return;
			}
		 if(trim(teacher)=="")
		  {
			  alert("请填写培训讲师！");
			  document.getElementById("teacher").focus();return;
			}
		 if(trim(content)=="")
		  {
			  alert("请填写培训内容！");
			  document.getElementById("content").focus();return;
			}
		  if(issign==2&&trim(people)=="")
		  {
			  alert("请填写参与培训人员！");
			  document.getElementById("people").focus();return;
		   }
		/*  if(trim(requirement)=="")
		  {
			  alert("请填写培训要求！");
			  document.getElementById("requirement").focus();return;
		 }*/
	     if(xuanze=="wu")
			{
				alert("请选择下一级审批人");return;
			}
		 
		 	
		       with(document.forms[0]) {
						
						action='subtrainapplypage.action';
						method="post";
						submit();
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
    <form action="subtrainapplypage.action" enctype="multipart/form-data" method="post">
    		<br>
    			<br>
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心成都分中心培训申请表</strong><strong> </strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr height="50">
    			<td width="150" class="as" >
    				培训类型<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    			   <select id="type" name="type" style="padding:0px;margin:0px;">&nbsp;&nbsp;&nbsp;&nbsp;
      		            <option value="wu">-请选择培训类型-</option>
      		              
      		               <option value="1">专题培训</option>
      		               <option value="2">日常业务培训</option>
      		               <option value="3">入职培训</option>
      		               <option value="4">精品课程</option>
      		               <option value="5">其他</option>
                    	</select>
                    <select id="issign" name="issign" onchange="hide();" style="padding:0px;margin:0px;">&nbsp;&nbsp;&nbsp;&nbsp;
      		            <option value="wu">-请选择是否开放报名-</option>
      		               <option value="1">开放</option>
      		               <option value="2">不开放</option>
                    	</select>
                    <select id="isregister" name="isregister" style="padding:0px;margin:0px;">
      		            <option value="wu">-请选择是否需要签到-</option>
      		               <option value="1">签到</option>
      		               <option value="2">不签到</option>
                    	</select>
    			</td>
    			
    		</tr>
    		<tr>	
    			<td width="150" class="as">
    				培训项目名称<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				<input style="width:450"  id="programname" name="programname" type="text" />
    			</td>
    		</tr>
    		
    		<tr height="40">
    			<td  class="as" >
    				培训层级<b>*</b>
    			</td>
    			<td width="150" class="as" >
    			
    				<select id="chu" name="chu" style="width: 200px" onblur="change()">
										<option value="wu">-请选择-</option>									
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
				  
    			
    			</td>
    			<td width="100" class="as" >
    				培训项目经理及联系方式<b>*</b>
    			</td>
    			<td width="250" >
    			 姓名：${ui.username}<input  id="manager" name="manager" type="hidden" value="${ui.username}" /><br>
    			 电话：<input style="width:100" id="tel" name="tel" type="text" />
    			</td>
    			
    		</tr>
    		
    			
    		<tr height="40">
    			<td  class="as" >
    				培训时间<b>*</b>
    			</td>
    			<td width="150" class="as" >
    				<input  style="width:100px" type="text" name="time" id="time" class="Wdate" onClick="WdatePicker()" >日期<br>
    				时<input type="text" name="hour" id="hour" style="width:50px" >:<input type="text" name="minute" id="minute" style="width:50px" >分(24小时制)
    				
    			</td>
    			<td width="100" class="as" >
    				培训地点<b>*</b>
    			</td>
    			<td width="250"  >
    			 <input id="location" name="location" type="text" />
    			
    			</td>
    			
    		</tr>
    		<tr height="40">
    			<td  class="as" >
    				是否考试<b>*</b>
    			</td>
    			<td width="150" class="as" >
    				<select id="isexam" name="isexam" style="padding:0px;margin:0px;" disabled="disabled"> &nbsp;&nbsp;&nbsp;&nbsp;
      		            <option value="wu">-请选择是否考试-</option>
      		               <option value="1">需考试</option>
      		               <option value="2">无需考试</option>
                    	</select>
    			</td>
    			<td width="100" class="as" >
    				是否评估<b>*</b>
    			</td>
    			<td width="250"  >
    			<select id="isevaluate" name="isevaluate" style="padding:0px;margin:0px;"> &nbsp;&nbsp;&nbsp;&nbsp;
      		            <option value="wu">-请选择是否评估-</option>
      		               <option value="1">需评估</option>
      		               <option value="2">无需评估</option>
                    	</select>
    			
    			</td>
    		</tr>
    		
    	     <tr>	
    			<td width="150" class="as">
    				培训讲师<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				<input  style="width:450" id="teacher" name="teacher" type="text" />
    			</td>
    		</tr>
    		
    		<tr>	
    			<td width="150" class="as">
    				培训内容<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3">
    				<input  style="width:450" id="content" name="content" type="text" />
    			</td>
    		</tr>
    		
    		
    		<tr id="trainpeople">	
    			<td width="150" class="as">
    				培训对象<b>*</b>
    			</td>
    			<td width="500" class="as" colspan="3" >
    			<textarea style="text-align:left;width:450px;height:100px" id="people" name="people" >  </textarea>
    				
			  
    			<br/>(名字之间用、隔开)
    			</td>
    			
    		</tr>
    		<tr>	
    		<td width="150" class="as">
    				相关要求
    			</td>
    			<td width="500" class="as" colspan="3">
    				<input  style="width:450" id="requirement" name="requirement" type="text" />
    			</td>
    		</tr>
    		<tr>
    	    <td width="150" class="as">
    				培训课件
    			</td>
    			<td id="fi" width="320" class="as" colspan="2">
    				
    			</td>	
    		     <td width="180" class="as">
    				<input style="width:50px" type="button" onclick="add()" value="增 加"/>
    			    <input style="width:50px" type="button" onclick="del()" value="减 少"/>
    			    <input style="width:70px" type="button" onclick="upload()" value="上传附件"/>
    			</td>
    		</tr>
    		
    		<tr>
    	    <td width="150" class="as">
    				备注
    			</td>
    			<td width="500" class="as" colspan="3">
    				<input style="width:450" id="remark" name="remark" type="text" />
    			</td>
    		</tr>
    		
          
    		<tr height="40">
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td width="500"  class="as" colspan="3">
    				<select name="thisunder" id="xuanze">
        				<option value="wu">请选择下一级审批人</option> 					
        			</select>
    			</td>
    		</tr>
    		<tr height="40">
    			<td>
    				&nbsp;
    			</td>
    		<td width="500" class="as" colspan="3">
    				<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    	</table>
    </form>
    <br>  <br>  <br>  <br>  <br>  <br>
  </body>
</html>
