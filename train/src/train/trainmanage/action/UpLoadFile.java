package train.trainmanage.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.process.action.GetProcessByPosition;
import train.process.dao.ProcessDAO;
import train.process.pojo.Process;
import train.trainmanage.dao.TFileDAO;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.dao.TempFileDAO;
import train.trainmanage.pojo.TFile;
import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TempFile;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.util.FileReadAndWrite;
import train.util.Util;
import ccb.hibernate.HibernateSessionFactory;

public class UpLoadFile {
	private File [] filen; //上传的文件
	private String [] filenFileName;
	private String [] filenContentType;
	private TempFile tf;
	private List<TempFile> listtf;
	private String tempnumber;
	private String newnumber;
	private UserInfo ui;
	private List<UserInfo> list;
	private int type;
	private int chu;
	private String manager;
	private String content;
	private String people;
	private String time;
	private String location;
	private String requirement;
    private int hour;
    private int minute;
	private String programname;
	private String tel;
	private int issign;
	private int isregister;
	private int isevaluate;
	private String teacher;
	private String bossname;
	
	

	public String getBossname() {
		return bossname;
	}

	public void setBossname(String bossname) {
		this.bossname = bossname;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public List<TempFile> getListtf() {
		return listtf;
	}

	public void setListtf(List<TempFile> listtf) {
		this.listtf = listtf;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public List<UserInfo> getList() {
		return list;
	}

	public void setList(List<UserInfo> list) {
		this.list = list;
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

	public int getIsevaluate() {
		return isevaluate;
	}

	public void setIsevaluate(int isevaluate) {
		this.isevaluate = isevaluate;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTempnumber() {
		return tempnumber;
	}

	public void setTempnumber(String tempnumber) {
		this.tempnumber = tempnumber;
	}

	public TempFile getTf() {
		return tf;
	}

	public void setTf(TempFile tf) {
		this.tf = tf;
	}

	public File[] getFilen() {
		return filen;
	}

	public void setFilen(File[] filen) {
		this.filen = filen;
	}

	public String[] getFilenFileName() {
		return filenFileName;
	}

	public void setFilenFileName(String[] filenFileName) {
		this.filenFileName = filenFileName;
	}

	public String[] getFilenContentType() {
		return filenContentType;
	}

	public void setFilenContentType(String[] filenContentType) {
		this.filenContentType = filenContentType;
	}

	public String execute() throws Exception
	{
    FileReadAndWrite fraw = new FileReadAndWrite();
	String realpath = Util.temppath;
	DateUtil du = new DateUtil();
	UserInfoDAO uidao = new UserInfoDAO();
	ProcessDAO pdao = new ProcessDAO();
	int process = 0;
	TempFileDAO tfdao = new TempFileDAO();
	//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	//String timenum = df.format(new Date());// new Date()为获取当前系统时间
	String date = du.getStringDate();
	tf = new TempFile();
	String index = "000";
	
	Session session = HibernateSessionFactory.getSession();
	Transaction trans = session.beginTransaction();
	
	    GetProcessByPosition gpbp = new GetProcessByPosition();
	    ui = uidao.findByNewNumber(newnumber);
	    
	 	 process = gpbp.getPxsqProcess(ui,chu);
		 Process p = pdao.findByItemAndApplicant("PXSQ", process);
		 String thisunder = "";
		      
		    if(p!=null)
		    {
		    	thisunder = p.getProcess().substring(1, 2);//EDCA
		    	list = uidao.findByAuthorityAndPosition(thisunder,ui.getChu());
		    	bossname = uidao.findBoss(list);
		    }
	    
	   
	if(tempnumber==null||tempnumber.equals(""))
	{
		index = "000"+fraw.readandwrite("UPFILE");
		index = index.substring(index.length() - 3, index.length());
		tempnumber = date + "UPFILE" +  index;
	}
	else
	{
		String sql = "delete from t_tempfile where number= '"+tempnumber+"'";
		session.createSQLQuery(sql).executeUpdate();
	}
	if(filen!=null)
	{
		
 	     for(int i=0;i<filen.length;i++)
 	     {
 	 		 File file = filen[i];
 	 		 String fileFileName = filenFileName[i];
 	 		 String[] listtype = fileFileName.split("\\.");
 	 		 String name = tempnumber+String.valueOf(i)+"."+listtype[1];
 	 		 if (file != null) {
 				//file1FileName = number+"_file1."+file1FileName.split("\\.")[1];
 			       File savefile = new File(new File(realpath), name);
 			       if (!savefile.getParentFile().exists())
 			            savefile.getParentFile().mkdirs();
 			           FileUtils.copyFile(file, savefile);
 			           tf.setFilename(fileFileName);
 			          // String name = du.getSimpleDateTime();
 			           tf.setName(name);
 			           tf.setNumber(tempnumber);
 			           tfdao.merge(tf);
 			     }
 	 	    
 	     }
 	     
	}

	listtf = tfdao.findAllByNumber(tempnumber);
	
	
 	 
 	 trans.commit();
     session.flush();
     session.clear();
     session.close();
	 return "success";
	
	}
}
