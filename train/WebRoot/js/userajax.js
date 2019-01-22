function chuidtoname(id)
{
    var result="";
    
    if(id=="1")
    {
       result="综合与生产管理处";
    }
    else if(id=="2")
    {
    	result="合规与监督二处";
    }
    else if(id=="3")
    {
    	result="通用业务二处";
    }
    else if(id=="4")
    {
    	result="专业处理二处";
    }
    else if(id=="5")
    {
    	result="研发支持二处";
    }
    else if(id=="A")
    {
    	result="综合管理处";
    }
    else if(id=="B")
    {
    	result="生产管理处";
    }
    else if(id=="C")
    {
    	result="研发支持一处";
    }
    else if(id=="D")
    {
    	result="通用业务一处";
    }
    else if(id=="E")
    {
    	result="专业处理一处";
    }
    else if(id=="F")
    {
    	result="合规与监督一处";
    }
    else if(id=="G")
    {
    	result="远程支持处";
    }
    else if(id=="U")
    {
    	result="物业服务处";
    }
    else if(id=="V")
    {
    	result="安保及基础设施运维处";
    }
    return result;
}

function tuanidtoname(id)
{
   var	chu=document.getElementById('chu').value;
   var result="";
   if(chu=="A")
   { 
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="综合管理团队";
    }
    else if(id=="2")
    {
    	result="财务（采购）管理团队";
    }
    else if(id=="3")
    {
    	result="人力资源（党群）团队";
    }
    }
   else if(chu=="B")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="运营规划与外包管理团队";
    }
    else if(id=="2")
    {
    	result="质量控制与合规管理团队";
    }
    else if(id=="3")
    {
    	result="监控调度与参数运维团队";
    }
   }
   else if(chu=="C")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="需求分析团队";
    }
    else if(id=="2")
    {
    	result="推广响应团队";
    }
   
   }
   else if(chu=="D")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="本币支付结算团队";
    }
    else if(id=="2")
    {
    	result="代理签约团队";
    }
   
   }
    else if(chu=="E")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="柜面外汇团队";
    }
    else if(id=="2")
    {
    	result="外汇汇款清算团队";
    }
   
   }
    else if(chu=="F")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="稽核监督团队";
    }
    else if(id=="2")
    {
    	result="集中授权 团队";
    }
   
   }
   else if(chu=="G")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="智慧银行业务团队";
    }
    else if(id=="2")
    {
    	result="集团子公司业务团队";
    }
   }
   else if(chu=="1")//综合与生产管理处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="综合与财务管理团队";
    }
    else if(id=="2")
    {
    	result="人力资源团队";
    }
    else if(id=="3")
    {
    	result="生产管理团队";
    }
   }
   else if(chu=="2")//合规与监督二处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="集中稽核团队";
    }
    else if(id=="2")
    {
    	result="集中业务处理团队";
    }
   }
   else if(chu=="3")//通用业务二处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="业务处理团队";
    }
   }
   else if(chu=="4")//专业处理二处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="专业处理团队";
    }
   }
   else if(chu=="5")//研发支持二处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="研发支持团队";
    }
   }
   else if(chu=="U")//物业服务处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="综合保障团队";
    }
    else if(id=="2")
    {
       result="物业服务团队";
    }
   }
   else if(chu=="V")//安保及基础设施运维处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="安保团队";
    }
    else if(id=="2")
    {
       result="基础设施运维团队";
    }
    else if(id=="3")
    {
       result="商务及合规团队";
    }
    else if(id=="4")
    {
       result="基建团队";
    }
   }
   
    return result;
}

function zuidtoname(id)
{
    var result="";
    
    if(id=="1")
    {
       result="班组一";
    }
    else if(id=="2")
    {
    	result="班组二";
    }
    else if(id=="3")
    {
    	result="班组三";
    }
    else if(id=="A")
    {
    	result="综合维修组";
    }
    else if(id=="B")
    {
    	result="常规物业组";
    }
    else if(id=="C")
    {
    	result="安全管理";
    }
    else if(id=="D")
    {
    	result="消安防管理";
    }
    else if(id=="E")
    {
    	result="能源动力";
    }
    else if(id=="F")
    {
    	result="空调暖通";
    }
    else if(id=="G")
    {
    	result="弱电监控";
    }
    else if(id=="H")
    {
    	result="运行管理";
    }
   
    return result;
}

