package train.trainmanage.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import train.util.ExportExcel;
import train.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.pojo.NameBean;
import train.trainmanage.pojo.TManage;
import ccb.hibernate.HibernateSessionFactory;

public class MakeTrainSheet {
	private String newnumber;
	private String number;
    private String message;
    private String [] listname;
	private String Path;
	
	
	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String[] getListname() {
		return listname;
	}

	public void setListname(String[] listname) {
		this.listname = listname;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}



	public String execute() throws Exception
	{
		
		TManageDAO tmdao = new TManageDAO();
		List<NameBean> uiblist = new ArrayList<NameBean>();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		TManage tm = tmdao.findAllBynumber(number);
		listname = tm.getPeople().split("、");
		String time = tm.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String systime = df.format(new Date());// new Date()为获取当前系统时间
		int flag = timecompare(time,systime);
		if(flag==1)
		{
			  tm.setStatus(10);
			  tmdao.merge(tm);
			    trans.commit();
			    session.flush();
			    session.clear();
			    session.close();
			    return "failed";
		}
		else
		{
		
		String filePath = "";
		
		ExportExcel<NameBean> ex = new ExportExcel<NameBean>();
		String[] headers = {"姓名","签到"};
		
		for(int i=0;i<listname.length;i++)
			
		{
			NameBean uib = new NameBean();
		    uib.setName(listname[i]);
		    uib.setIssign("");
			uiblist.add(uib);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"traininfo.xls";
				Path = "traininfo.xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("培训人员签到表",headers, uiblist, out);
				out.close();
				System.out.println("excel导出成功！");
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			    trans.commit();
			    session.flush();
			    session.clear();
			    session.close();
			    return "success";
		}	
	 
		
	}
	
	
	public int timecompare(String time, String systime)
	{
		String times[] = time.split(",");
		String datetime = times[0];
		String hour = times[1].split(":")[0];
		String minute = times[1].split(":")[1];
		String systimes[] = systime.split(" ");
	    String sysdate = systimes[0];
	    String syshour = systimes[1].split(":")[0];
	    String sysminute = systimes[1].split(":")[1];
	    int dateflag = datecompare(sysdate,datetime);
	    if(dateflag==1)
	    {
	    	return 1;//培训已开始，不准下载签到表
	    }
	    else if(dateflag ==2)
	    {
	    	return 2;//培训未开始，可以下载签到表
	    }
	    else
	    {
	    	if(Integer.parseInt(syshour)>Integer.parseInt(hour))
	    	{
	    		return 1;//培训已开始，不准下载签到表
	    	}
	    	else if (Integer.parseInt(syshour)<Integer.parseInt(hour))
	    	{
	    		return 2;//培训未开始，可以下载签到表
	    	}
	    	else
	    	{
	    		if(Integer.parseInt(sysminute)>Integer.parseInt(minute))
		    	{
		    		return 1;//培训已开始，不准下载签到表
		    	}
	    		else if (Integer.parseInt(sysminute)<Integer.parseInt(minute))
		    	{
		    		return 2;//培训未开始，可以下载签到表
		    	}
	    		else
	    		{
	    			return 1;//培训已开始，不准下载签到表
	    		}
	    		
	    	}
	    }
	
	}
	
	public int datecompare(String date1,String date2)
	{
		/*String dates1[] = date1.split("-");
		String dates2[] = date2.split("-");
		String date1year = dates1[0];
		String date1month = dates1[1];
		String date1day = dates1[2];
		String date2year = dates2[0];
		String date2month = dates2[1];
		String date2day = dates2[2];
		*/
		String date1form = date1.replaceAll("-", "");
		String date2form = date2.replaceAll("-", "");
		int date1int = Integer.parseInt(date1form);
		int date2int = Integer.parseInt(date2form);
		if(date1int>date2int)
		{
			return 1;
			
			
		}
		if(date1int<date2int)
		{
			return 2;
		}
		else
		{		
			return 3;
			
		}
	
	}
	
}
