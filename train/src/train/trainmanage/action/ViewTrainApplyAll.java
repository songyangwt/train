package train.trainmanage.action;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class ViewTrainApplyAll {
	
	private String newnumber;// 新一代员工编号
	private List<TManage> list;
	private String title;
	private String authoU;
	private String authoV ;
	private int chutuan;
	private String zxtd;
	private String begindate;
	private String enddate;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getChutuan() {
		return chutuan;
	}

	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}

	public String getZxtd() {
		return zxtd;
	}

	public void setZxtd(String zxtd) {
		this.zxtd = zxtd;
	}

	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		Query query;
		String hql = "";	
		String zhi = "";
		String chu = "";	
		String bd = "";
		String ed = "";
		
		title = "统计查询-明细查询";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			ui = uidao.findByNewNumber(newnumber);
			zhi = ui.getZhi().toString();
			chu = ui.getChu().toString();
			authoU = ui.getAuthority().substring(20, 21);
			authoV = ui.getAuthority().substring(21, 22);
			hql = "from TManage as tm";
			
			hql +=" where 1=1";
			if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
			{
				bd = begindate.replace("-","");
				ed = enddate.replace("-", "");
				hql += " and tm.date>='"+bd+"' and tm.date<='"+ed+"'";
			}
			if(zxtd!=null&&zxtd.equals("td"))
			{
			    if(chutuan!=0)
			    {
			    	hql += " and tm.chu='"+chutuan+"'";
			    }
				
				if(zhi.equals("1")||authoU.equals("U"))//主任看全部
				{
					hql += "";
				}
				else if(zhi.equals("3")||zhi.equals("4")||authoV.equals("V"))//团队负责人
				{
					hql += " and tm.chu='"+chu+"'";
				}
				
			
				result = "successtd";
			}
			else//普通员工
			{
				String newnumber1=newnumber.substring(0,8);
				hql += " and substr(tm.initiator,1,8)='"+newnumber1+"'";
			}
			hql += " order by tm.id desc";
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
