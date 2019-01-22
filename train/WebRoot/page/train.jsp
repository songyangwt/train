<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String username = (String)request.getSession().getAttribute("username");
	String IP=request.getRemoteAddr();
	session.setAttribute("IP",IP);
	
%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/cccx_old.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style_old.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style_menu_top.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>培训管理工具</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js"></script>

<script language="javascript"> 


function startTime()
{
	
var today=new Date();
var h=today.getHours();
var m=today.getMinutes();
var s=today.getSeconds();
// add a zero in front of numbers<10
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
t=setTimeout('startTime()',500);

}

function checkTime(i)
{
if (i<10) 
  {i="0" + i;}
  return i;
}
 
</script>
<script type="text/javascript">

function frame(o)
{
	var id = document.getElementById("id").value;
	var zhi = document.getElementById("zhi").value;
	var chu = document.getElementById("chu").value;
	var authoA = document.getElementById("authoA").value;
    var authoB = document.getElementById("authoB").value;
	var authoC = document.getElementById("authoC").value;
	var authoD = document.getElementById("authoD").value;
	var authoE = document.getElementById("authoE").value;
	var authoF = document.getElementById("authoF").value;
	var authoG = document.getElementById("authoG").value;
	var authoH = document.getElementById("authoH").value;
	var authoI = document.getElementById("authoI").value;
	var authoJ = document.getElementById("authoJ").value;
	var authoK = document.getElementById("authoK").value;
	var authoL = document.getElementById("authoL").value;
	var authoM = document.getElementById("authoM").value;
	var authoN = document.getElementById("authoN").value;
	var authoO = document.getElementById("authoO").value;
	var authoP = document.getElementById("authoP").value;
	var authoQ = document.getElementById("authoQ").value;
	var authoR = document.getElementById("authoR").value;
	var authoS = document.getElementById("authoS").value;
	var authoT = document.getElementById("authoT").value;
	var authoU = document.getElementById("authoU").value;		
	var authoV = document.getElementById("authoV").value;												
	var obj = " ";
	obj=o;
	if(obj=="userinfo")
	{
		document.getElementById("frame").src="<%=path%>/user.action?type=find_all";
		//document.getElementById("daohang").innerHTML="用户信息->查询所有";
	}
	
		
	else if(obj=="home")//返回首页
	{
		topmenu.style.display="none";
		document.getElementById("frame").src="<%=path%>/welcome.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="首页";
	}
	
	else if(obj=="plan_manage")//培训计划管理
	{
		document.getElementById("frame").src="<%=path%>/showtrainplanimport.action?newnumber=${newnumber}";
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->代发起";
	}
	
	else if(obj=="userinfo_manage")//用户管理
	{
		document.getElementById("frame").src="<%=path%>/userlistall.action?newnumber=${newnumber}";
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->代发起";
	}
	
	else if(obj=="userinfo_init")//用户信息初始化
	{
		document.getElementById("frame").src="<%=path%>/page/userinfo/importuserinfo.jsp";
	
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->代发起";
	}
	
	else if(obj=="plan_view")//培训计划查看
	{
		document.getElementById("frame").src="<%=path%>/showtrainplanall.action";
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->流转中";
	}
	else if(obj=="trainnotice_sign")
	{
		document.getElementById("frame").src="<%=path%>/trainnoticeselfsign.action?newnumber=${newnumber}";
		
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->流转中";
	}
  
	
	else if(obj=="train_notice")//培训公告
	{
		
		document.getElementById("frame").src="<%=path%>/showtrainnoticelist.action?newnumber=${newnumber}";
		
		topmenu.style.display="inline-block";
		
		document.getElementById("22").style.display="none";
		document.getElementById("21").style.display="none";
		
		document.getElementById("31").style.display="none";
	    document.getElementById("32").style.display="none";
	    //document.getElementById("33").style.display="none";
	    document.getElementById("34").style.display="none";
	    document.getElementById("35").style.display="inline-block";
		document.getElementById("51").style.display="none";
		
		document.getElementById("53").style.display="none";
	    document.getElementById("1").style.display="none";
	    document.getElementById("3").style.display="none";
		document.getElementById("57").style.display="none";
	
		document.getElementById("55").style.display="none";
	
		

		document.getElementById("35").onclick=function(){frame('trainnotice_sign');};
	}
		
		
	else if(obj=="trainapply_page")//培训管理-发起申请
	{
		document.getElementById("frame").src="<%=path%>/showtrainapplypage.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->待办事宜";
	}

	else if(obj=="trainapply_viewlzz")//培训管理-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewtrainapplylzz.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->待办事宜";
	}
	else if(obj=="trainapply_viewunder")//培训管理-待办事宜
	{
		document.getElementById("frame").src="<%=path%>/viewtrainapplyunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->统计查询->明细查询";
	}
	else if(obj=="trainapply_viewalltd")//培训管理-查询全部
	{
		document.getElementById("frame").src="<%=path%>/viewtrainapplyall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="收入证明->统计查询->明细查询";
	}
	else if(obj=="trainapply_viewall")//培训管理-查询处室
	{
		document.getElementById("frame").src="<%=path%>/viewtrainapplyall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->已承办";
	}
    else if(obj=="trainapply_viewfb")//培训管理-查询处室
	{
		document.getElementById("frame").src="<%=path%>/viewtrainapplyfblist.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->已承办";
	}
	 else if(obj=="trainapply_viewshenpi")//
	{
		document.getElementById("frame").src="<%=path%>/viewtrainapplyshenpilist.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->已承办";
	}
     else if(obj=="trainapply_estimate")//
	{
		document.getElementById("frame").src="<%=path%>/viewtrainapplyscorelist.action?newnumber=${newnumber}";
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->已承办";
	}
	 else if(obj=="trainapply_statistic")//
	{
		document.getElementById("frame").src="<%=path%>/viewtrainapplystatisticlist.action?newnumber=${newnumber}";
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->已承办";
	}
     else if(obj=="trainapply_process")//
	{
		document.getElementById("frame").src="<%=path%>/viewtrainapplyprocesslist.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->已承办";
	}
	
	
	else if(obj=="train_apply")//培训申请
	{
		if(zhi=='1')
		{
			document.getElementById("frame").src="<%=path%>/viewtrainapplyunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showtrainapplypage.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
		
		document.getElementById("22").style.display="none";
			
		document.getElementById("35").style.display="none";
		document.getElementById("21").style.display="inline-block";
		document.getElementById("1").style.display="inline-block";
	    document.getElementById("3").style.display="inline-block";
		document.getElementById("31").style.display="inline-block";
	    document.getElementById("32").style.display="inline-block";
	   // document.getElementById("33").style.display="inline-block";
	    document.getElementById("34").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("55").style.display="inline-block";
	    document.getElementById("57").style.display="none";
	    document.getElementById("53").style.display="none";
		if(zhi=='1'||authoU=='U')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		  
		   //document.getElementById("54").style.display="inline-block";
		}
		
		if(zhi=='3'||zhi=='4'||authoV=='V')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  
		  //document.getElementById("58").style.display="inline-block";
		}
		
		//document.getElementById("53").style.display="inline-block";
		

		document.getElementById("21").onclick=function(){frame('trainapply_page');};
		//document.getElementById("22").onclick=function(){frame('wcgg_df');}; 
		document.getElementById("31").onclick=function(){frame('trainapply_viewlzz');};
		document.getElementById("32").onclick=function(){frame('trainapply_viewunder');};
		//document.getElementById("33").onclick=function(){frame('trainapply_viewfb');};
		document.getElementById("34").onclick=function(){frame('trainapply_viewshenpi');};
		document.getElementById("51").onclick=function(){frame('trainapply_viewall');};
		document.getElementById("53").onclick=function(){frame('trainapply_viewalltd');};
		document.getElementById("57").onclick=function(){frame('trainapply_viewalltd');};
		document.getElementById("55").onclick=function(){frame('trainapply_process');};
	}
	
	
	//if(obj=="test_leave"||obj=="test_wcgg"||obj=="test_mjgl"||obj=="tbsq_page"||obj=="ygxx_page"||obj=="test_kqqs"||obj=="test_jbsp"||obj=="test_mjgl")
}
</script>

<script type="text/javascript">
$(document).ready(function(){

	topmenu.style.display="none";			   
	/* 滑动/展开 */
	$("ul.expmenu li > div.header").click(
	function()
	{
		var arrow = $(this).find("span.arrow");
	
		$(this).parent().find("ul.menu1").slideToggle("fast").parents(".a").siblings(".a").children("ul.menu1").hide(300);
	}
);
	$(".cc").click(
			function()
			{
				$(".cc").css("width","155px");
				$(this).css("width","168px");	
			}
			);
});
</script>
<style>
.menu1 ol { padding-left:15px; border:#E7E7E7 1px solid; border-top:none;background: #f7f2e5;}
.menu1 li i{background-color: #ae9c7e;padding: 1px 4px;color: #fff;text-shadow: 0px 0px 0px rgba(255, 255, 255, 0.8);font-family: 宋体;font-style:normal;}
.menu1 a{color: #3f3f3f;text-decoration: none;}
.menu1 .no {display:none;}
.menu1 ol a{width: 228px;display: block;line-height: 2em;margin-left: 20px;}
</style>

<style media="print" type="text/css"> 
.noprint{display:none;} 
</style> 
</head>
<body onload="startTime()"> 
	<div id="zhuti" style="position:absolute">
		<div id="top" class="noprint">
			<img src="<%=path%>/images/logo.gif" width="276" height="50" style="margin-top:0px" />
		</div>
		<div class="x_beijing">
			<div class="x_anniu noprint">
				<div>
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b
						class="b4 d1"></b>
					<div class="b d1 k" style="height:150px">
						<div >
							<!-- 登陆用户信息 -->
							<p style="margin:0px；padding:0px">${username }</p>
							<p style="font-size:14px">欢迎访问培训管理工具</p>
							<p>
								
								<input align="right" name="logout" type="button" value="回到首页" onclick="location='/office/mainccb.jsp'" />
								<input type="hidden" id="id" name="id" value="${id}"/> 
							</p>
							<p><%=new SimpleDateFormat("yyyy年MM月dd日").format(new java.util.Date())%></p>
							<p id="txt"></p>
							<p>累计访问量：${views}</p>
							
						</div>
						
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b
						class="b1b"></b>
				</div>
					<div class="menu1" style="margin-top: 5px; background-color: #188AE7;">
						<ul class="expmenu">
							<li class="a">
								<div class="header">
									<span class="label" >待办事宜</span>
								</div>
								<ul class="menu1">
									<li class="cc"  onclick="frame('home')">待办事宜</li>
								</ul>
							</li>
						
							<li class="a">
								<div class="header">
									<span class="label">培训计划</span>
								</div>
								<ul class="menu1">
								 <c:if test="${authoU=='U'||authoV=='V'}">
									<li class="cc"  onclick="frame('plan_manage')">培训计划管理</li>
								 </c:if>
									<li class="cc"  onclick="frame('plan_view')">培训计划查看</li>
								</ul>
							</li>
						 
							<li class="a">
								<div class="header">
									<span class="label">培训管理</span>
								</div>
								<ul class="menu1">
								
									<li class="cc"  onclick="frame('train_apply')">培训申请</li>
									<li class="cc"  onclick="frame('trainapply_estimate')">培训评估</li>
									 <c:if test="${authoU=='U'||authoV=='V'||zhi==1||zhi==3}">
									<li class="cc"  onclick="frame('trainapply_statistic')">培训统计</li>
							         </c:if>
								</ul>
							</li>
							<li class="a">
								<div class="header">
									<span class="label">培训公告</span>
								</div>
								<ul class="menu1">								
									<li class="cc"  onclick="frame('train_notice')">培训公告</li>
								</ul>
							</li>
							<c:if test="${authoU=='U'}">
							<li class="a">
								<div class="header">
									<span class="label">参数维护</span>
								</div>
								<ul class="menu1">								
									<li class="cc"  onclick="frame('userinfo_manage')">用户信息管理</li>
									<li class="cc"  onclick="frame('userinfo_init')">用户信息初始化</li>
								</ul>
							</li>	
							</c:if>			
						</ul>
					</div>
			</div>
			<div class="x_xianshi" style="overflow:hidden;">
				<div style="overflow:hidden;">
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b class="b4 d1"></b>
					<div class="b d1 k3">
 <!--代码开始-->
					 <div class="top noprint" id="topmenu">
								<ul class="menu noprint">
									<!-- <li id="daohang" style="background-color:#FFFFFF;width:220px;font-weight:bold">首页</li> -->
									<li id="1">
										<a  class="tablink arwlink noprint">发起申请</a>
										<ul>
											<li><a id="21" href="#" onclick="">本人发起</a></li>
											<li><a id="22" href="#" onclick="">代发起</a></li>
								
										</ul>
							 		</li>
							            
							       <li id="2">
 							      		<a href="#" class="tablink arwlink noprint">查看本人申请</a>
  							           <ul>
											<li><a id="35" href="#" onclick="">已报名</a></li>
											<li><a id="31" href="#" onclick="">流转中</a></li>
											<li><a id="32" href="#" onclick="">待办事宜</a></li>
											<!--  <li><a id="33" href="#" onclick="">已发布</a></li>-->
											<li><a id="34" href="#" onclick="">已审批</a></li>
											
 							           </ul>
							                <div class="hot"></div>
							      </li>
							    
							      <li id="3">
							            <a href="#"  class="tablink arwlink noprint">统计查询</a>
 							           <ul>
<!-- 
											<li><a id="51" href="#" style="width:80px" onclick="frame('tjcx_mx')">个人明细</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="53" href="#" onclick="frame('tjcx_tdmx')"><c:if test="${autho=='I'||autho=='J'||zhi=='0'||zhi=='1'}">中心明细</c:if><c:if test="${zhi=='2'||zhi=='4'||autho=='NT'||autho=='Q'}">团队明细</c:if></a></li>
											<li><a id="52" href="#" style="width:80px" onclick="frame('tjcx_hz')">个人汇总</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="54" href="#" onclick="frame('tjcx_tdhz')"><c:if test="${autho=='I'||autho=='J'||zhi=='0'||zhi=='1'}">中心汇总</c:if><c:if test="${zhi=='2'||zhi=='4'}">团队汇总</c:if></a></li>
-->
											<li><a id="51" href="#" style="width:80px" onclick="">明细查询</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="53" href="#" style="width:80px" onclick="">中心明细</a><a id="57" href="#" style="width:80px" onclick="">处室明细</a></li>
                                            <li><a id="55" href="#" style="width:80px" onclick="">进程管理</a></li>
							               
							                <!--<li><a id="56" href="#" style="width:90px" onclick="frame('mjgl_qxcx')">个人门禁权限</a></li>  -->
							            </ul>
							            
							      </li>
						    
							   
							     
							   </ul>
							   
							</div> 

<!--代码结束-->
						
						
						<iframe id="frame" class="mainpage"	src="<%=path%>/welcome.action?newnumber=${newnumber}" marginwidth='0' marginheight='0' frameborder='0'></iframe>
						<input type="hidden" id="zhi" value="${zhi}"/>
						<input type="hidden" id="chu" value="${chu}"/>
						<!-- <input type="hidden" id="autho" value="${autho}"/> -->
						<input type="hidden" id="authoA" value="${authoA}"/>
						<input type="hidden" id="authoB" value="${authoB}"/>
						<input type="hidden" id="authoC" value="${authoC}"/>
						<input type="hidden" id="authoD" value="${authoD}"/>
						<input type="hidden" id="authoE" value="${authoE}"/>
						<input type="hidden" id="authoF" value="${authoF}"/>
						<input type="hidden" id="authoG" value="${authoG}"/>
						<input type="hidden" id="authoH" value="${authoH}"/>
						<input type="hidden" id="authoI" value="${authoI}"/>
						<input type="hidden" id="authoJ" value="${authoJ}"/>
						<input type="hidden" id="authoK" value="${authoK}"/>
						<input type="hidden" id="authoL" value="${authoL}"/>
						<input type="hidden" id="authoM" value="${authoM}"/>
						<input type="hidden" id="authoN" value="${authoN}"/>
						<input type="hidden" id="authoO" value="${authoO}"/>
						<input type="hidden" id="authoP" value="${authoP}"/>
						<input type="hidden" id="authoQ" value="${authoQ}"/>
						<input type="hidden" id="authoR" value="${authoR}"/>
						<input type="hidden" id="authoS" value="${authoS}"/>
						<input type="hidden" id="authoT" value="${authoT}"/>
						<input type="hidden" id="authoU" value="${authoU}"/>
						<input type="hidden" id="authoV" value="${authoV}"/>
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b class="b1b"></b>
				</div>
			</div>
		</div>
	</div>
</body>
</html>