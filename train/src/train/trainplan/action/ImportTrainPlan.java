package train.trainplan.action;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import train.trainplan.dao.TplanDAO;
import train.trainplan.pojo.Tplan;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;

public class ImportTrainPlan {

	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String year;
    private int chu;
    private int chutuan;
    
     
	public int getChutuan() {
		return chutuan;
	}
	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}
	public int getChu() {
		return chu;
	}
	public void setChu(int chu) {
		this.chu = chu;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 标准文件名ygxx.xls
	 * 文件上传和读取内容
	 * @return "success"执行成功
	 * @throws Exception
	 */
	public String execute() throws Exception
	{
		int nn=0;
		String realpath = "D:/import/office/";
		TplanDAO tpdao = new TplanDAO();
		message = "导入成功";
		UserInfoDAO uidao = new UserInfoDAO();
		if (file != null) {
		       File savefile = new File(new File(realpath), fileFileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file, savefile);
		     }
		    else
		    {
		    	ActionContext.getContext().put("message", "传入文件有误");
		    }
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一列第一行的单元格
			nn = sheet.getRows();
			    if(chutuan==0)
			    {
			    	String sql = "delete from t_plan where chu = "+chu+" and year = '"+year+"'";
					session.createSQLQuery(sql).executeUpdate();
			    }
			    else
			    {
			    	String sql = "delete from t_plan where chu = "+chutuan+" and year = '"+year+"'";
					session.createSQLQuery(sql).executeUpdate();
			    }
				
				for (int i = 1; i < nn; i++) {
			         Tplan tp = new Tplan();
			         if((sheet.getCell(0, i).getContents().trim()!=null)&&!(sheet.getCell(0, i).getContents().trim().equals("")))
			         {
			        	 tp.setManager(sheet.getCell(0, i).getContents().trim());
						 if(chutuan==0)
						 {
							 tp.setChu(chu);
						 }
						 else
						 {
							 tp.setChu(chutuan);
						 }
						 tp.setContent(sheet.getCell(1, i).getContents().trim());
						 tp.setPeople(sheet.getCell(2, i).getContents().trim());
						 tp.setTime(sheet.getCell(3, i).getContents().trim());
						 tp.setLocation(sheet.getCell(4, i).getContents().trim());
						 tp.setRemark(sheet.getCell(5, i).getContents().trim());
						 tp.setYear(year);
						 tpdao.merge(tp);
			         }
				     
				}
			
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		
		return "success";
	}
}
