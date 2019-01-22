package train.trainmanage.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class ViewTrainApplyProcessList {
	private String newnumber;// 新一代员工编号
	private List<TManage> list;
    
	private String authoU;
	private String authoV;

	/**
	* 获得默认的分页大小
	*/
	private int pageSize = 10;

	/**
	* 总页数
	*/
	private int totalPages = -1;

	/**
	* 当前页
	*/
	private int currentPage = -1;

	/**
	* 上一页
	*/
	private int previousPage = 1;

	/**
	* 下一页
	*/
	private int nextPage = 1;
	/**
	* 第一页
	*/
	private int firstPage = 1;
	/**
	* 最后一页
	*/
	private int lastPage = 1;
	/**
	* 总记录条数
	*/
	private long totalRows = -1;
	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	
	public List<TManage> getList() {
		return list;
	}

	public void setList(List<TManage> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public String getAuthoU() {
		return authoU;
	}

	public void setAuthoU(String authoU) {
		this.authoU = authoU;
	}

	public String getAuthoV() {
		return authoV;
	}

	public void setAuthoV(String authoV) {
		this.authoV = authoV;
	}

	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		Query query;
		String hql = "";	

		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			
		    String newnumber1=newnumber.substring(0,8);
			ui = uidao.findByNewNumber(newnumber1);
			authoU=ui.getAuthority().substring(20, 21);
			authoV=ui.getAuthority().substring(21, 22);
		    if(authoU.equals("U"))
		    {
		    	  hql += "from TManage as tm where tm.status not in (0,1,2,4,5,6) order by tm.id desc";	
		    }
		    else if(authoV.equals("V"))
		    {
		    
		    	int chu = ui.getChu();
		    	hql += "from TManage as tm where tm.status not in (0,1,2,4,5,6) and ((tm.chu="+chu+") or (tm.initiator="+newnumber1+"))order by tm.id desc";			
		    }
		    else if ((!authoU.equals("U"))&&(!authoV.equals("V")))
		    {
		    	hql += "from TManage as tm where tm.status not in (0,1,2,4,5,6) and tm.initiator="+newnumber1+"order by tm.id desc";			
		    }
		
			System.out.println(hql);
			query = session.createQuery(hql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows = session.createQuery(hql).list().size();
			initPageProperties();
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
	
	/**
	 * 初始化页面属性<br>
	 * 必须在已获得totalRows值之后再调用该函数<br>
	 * 调用方式为：<br>
	 * 
	 * 给totalRows赋值<br>
	 * 调用initPageProperties(form)方法<br>
	 * 给list赋值<br>
	 * 调用initAttribute(request)方法<br>
	 * 
	 * 该方法在调用查询语句之前调用<br>
	 * pageSize为系统默认的分页的大小，如要更改pageSize，应在掉用setPageSize方法后再调用该方法<br>
	 * 
	 * 
	 */
	protected void initPageProperties() {

		if (totalRows == -1) {
			
		}

		firstPage = 1;
		
		currentPage = currentPage <= 1 ? 1 : currentPage;

		totalPages = (totalRows % pageSize == 0) ? ((int) (totalRows / pageSize))
				: ((int) (totalRows / pageSize + 1));

		currentPage = currentPage >= totalPages ? totalPages : currentPage;

		previousPage = currentPage > 1 ? currentPage - 1 : 1;

		nextPage = currentPage < totalPages ? currentPage + 1 : totalPages;

		lastPage = totalPages;
	}
}
