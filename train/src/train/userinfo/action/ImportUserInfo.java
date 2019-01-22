package train.userinfo.action;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;

public class ImportUserInfo {
	
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		String realpath = "D:/import/train/";
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
			if(type.equals("fugai"))//如果选择的是覆盖，先删除原表
			{
				String sql = "truncate userinfo";
				session.createSQLQuery(sql).executeUpdate();
				
				for (int i = 1; i < nn; i++) {
					UserInfo ui = new UserInfo();
					
					if((sheet.getCell(0, i).getContents().trim()!=null)&&(sheet.getCell(0, i).getContents().trim().equals("")))
					{
						ui.setUsername(sheet.getCell(0, i).getContents().trim());
						ui.setNewnumber(sheet.getCell(1, i).getContents().trim());
					    ui.setChu(Integer.valueOf(sheet.getCell(2, i).getContents().trim()));
					    ui.setZhi(Integer.valueOf(sheet.getCell(3, i).getContents().trim()));
						ui.setAuthority(sheet.getCell(4, i).getContents().trim());
					
						uidao.merge(ui);
					}
					
				}
			}
			else//如果选择的是更新新增，
			{
				for (int i = 1; i < nn; i++) {
					if((sheet.getCell(0, i).getContents().trim()!=null)&&(sheet.getCell(0, i).getContents().trim().equals("")))
					{
						UserInfo ui = uidao.findByName(sheet.getCell(0, i).getContents().trim());
						if(ui==null)
						{
							ui=new UserInfo();
						}
						
						ui.setUsername(sheet.getCell(0, i).getContents().trim());
						ui.setNewnumber(sheet.getCell(1, i).getContents().trim());
					    ui.setChu(Integer.valueOf(sheet.getCell(2, i).getContents().trim()));
					    ui.setZhi(Integer.valueOf(sheet.getCell(3, i).getContents().trim()));
						ui.setAuthority(sheet.getCell(4, i).getContents().trim());
						uidao.merge(ui);
					}
					
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
