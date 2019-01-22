package train.trainmanage.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import train.process.action.GetProcessByPosition;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.FileReadAndWrite;
import train.util.Util;
import org.apache.commons.io.FileUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import train.trainmanage.dao.TFileDAO;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.dao.TempFileDAO;
import train.trainmanage.pojo.TFile;
import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TempFile;
import train.util.DateUtil;
import ccb.hibernate.HibernateSessionFactory;

public class SubTrainApplyPage {
	private int type;
	private int chu;
	private String manager;
	private String content;
	private String people;
	private String time;
	private String hour;
	private String minute;
	private String location;
	private String requirement;
	private String number;
	private String programname;
	private String tel;
	private int process;
	private String date;
	private int status;
	private int issign;
	private int isregister;
	private int isexam;
	private int isevaluate;
	private String remark;
	private String teacher;
	//private File [] filen; //上传的文件
	//private String [] filenFileName;
	//private String [] filenContentType;
	private String message;
	private String newnumber;
	private String thisunder;
	private String tempnumber;
	
	
	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getTempnumber() {
		return tempnumber;
	}

	public void setTempnumber(String tempnumber) {
		this.tempnumber = tempnumber;
	}

	public String getThisunder() {
		return thisunder;
	}

	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}



	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getRequirement() {
		return requirement;
	}


	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getProgramname() {
		return programname;
	}


	public void setProgramname(String programname) {
		this.programname = programname;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public int getProcess() {
		return process;
	}


	public void setProcess(int process) {
		this.process = process;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIssign() {
		return issign;
	}


	public void setIssign(int issign) {
		this.issign = issign;
	}

	public int getIsregister() {
		return isregister;
	}

	public void setIsregister(int isregister) {
		this.isregister = isregister;
	}

	public int getIsexam() {
		return isexam;
	}

	public void setIsexam(int isexam) {
		this.isexam = isexam;
	}

	public int getIsevaluate() {
		return isevaluate;
	}

	public void setIsevaluate(int isevaluate) {
		this.isevaluate = isevaluate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}


	public String execute() throws Exception
	{
		FileReadAndWrite fraw = new FileReadAndWrite();
		GetProcessByPosition gpbp = new GetProcessByPosition();
		TFile tf = new TFile();
		TFileDAO tfdao = new TFileDAO();
		TManage tm = new TManage();
		TManageDAO tmdao = new TManageDAO();
		DateUtil du = new DateUtil();
	    UserInfo ui = new UserInfo();
	    UserInfoDAO uidao = new UserInfoDAO();
	    List<TempFile> listtmf  = new ArrayList<TempFile>();
	    TempFileDAO tmfdao = new TempFileDAO();
	    
	    ui = uidao.findByNewNumber(newnumber);
//		int zhi = 0;
		int zhi = ui.getZhi();
		int process = 0;
		String realpath = Util.docpath;
		String temppath = Util.temppath;
		String date = du.getStringDate();
		String index = "000";
	
		String number = "";
		String result = "success";
		
		message = "失败，姓名";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
		index = "000"+fraw.readandwrite("PXSQ");
		index = index.substring(index.length() - 3, index.length());
		number = date + "PXSQ" +  index;
        
	//是否表中有重复项
	  if(tmdao.findAllBynumber(number)!=null)
	   {
		  result = "failed";
		  message = "提交失败，原因异常";
		  trans.rollback();
		  return result;
	      }
	  if(issign==2&&isnameright(ui,uidao,people)==0)
	  {
		  result = "failed";
		  message = "提交失败，培训对象名字非本单位人员！";
		  trans.rollback();
		  return result;
	  }

	//获得公干流程编号
	//process = gpbp.getPxsqProcess(zhi,chu);
	process = gpbp.getPxsqProcess(ui,chu);
	/*if(process==0)
	{
		result = "nopxsq";
		message = "您不需要填此表";
	}*/

	tm.setChu(chu);
	tm.setContent(content);
	tm.setDate(date);
	tm.setInitiator(newnumber);
	tm.setIsevaluate(isevaluate);
	tm.setIsexam(2);
	tm.setIsregister(isregister);
	tm.setIssign(issign);
	tm.setJindu("E");
	tm.setLocation(location);
	tm.setManager(manager);
	tm.setNumber(number);
	tm.setPeople(people);
	tm.setProcess(process);
	tm.setProgramname(programname);
	tm.setRemark(remark);
	tm.setRequirement(requirement);
	tm.setStatus(1);
	tm.setTeacher(teacher);
	tm.setTel(tel);
	tm.setThisunder(thisunder);
	tm.setTime(time+","+hour+":"+minute);
	tm.setType(type);
	tm.setPreunder("");
	if(tempnumber!=null&&tempnumber!="")
	{
		listtmf = tmfdao.findAllByNumber(tempnumber);
	}
	else
	{
		listtmf = null;
	}

	if(listtmf!=null)
	{
		
 	 for(int i=0;i<listtmf.size();i++)
 	 {
 		 TempFile tmf = listtmf.get(i);
 		 String name = tmf.getName();
 		 File file=new File(temppath,name);
 		String fileFileName = tmf.getFilename();
 		String[] listtype = fileFileName.split("\\.");
 		 String newname = number+String.valueOf(i)+"."+listtype[1];
 		if (file != null) {
			//file1FileName = number+"_file1."+file1FileName.split("\\.")[1];
		       File savefile = new File(new File(realpath), newname);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file, savefile);
		           tf.setFilename(fileFileName);
		          // String name = du.getSimpleDateTime();
		           tf.setName(newname);
		           tf.setNumber(number);
		           tfdao.merge(tf);
		     }
 	    }
	}
 	 tmdao.merge(tm);
 	 
 	 trans.commit();
     session.flush();
     session.clear();
     session.close();
	return "success";
	
	}
	
	public int isnameright(UserInfo ui , UserInfoDAO uidao ,String peoplename)
	{
		String names [] = peoplename.split("、");
		int flag = 0;
		for(int i=0;i<names.length;i++)
		{
			String trainname = names[i];
			ui = uidao.findByName(trainname);
			if(ui==null)
			{
			   flag++;	
			}
			
		}
		if(flag==0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
