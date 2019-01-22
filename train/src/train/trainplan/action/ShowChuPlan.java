package train.trainplan.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainplan.dao.TplanDAO;
import train.trainplan.pojo.Tplan;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.util.Util;
import ccb.hibernate.HibernateSessionFactory;

public class ShowChuPlan {
private int chu ;
private List<Tplan> listtp;
private String newnumber;
private String title;
private String year;
private int pageSize = Util.pagesize;


public String getNewnumber() {
	return newnumber;
}


public void setNewnumber(String newnumber) {
	this.newnumber = newnumber;
}


public String getYear() {
	return year;
}


public void setYear(String year) {
	this.year = year;
}

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


public int getChu() {
	return chu;
}


public void setChu(int chu) {
	this.chu = chu;
}


public List<Tplan> getListtp() {
	return listtp;
}


public void setListtp(List<Tplan> listtp) {
	this.listtp = listtp;
}


public String execute() throws Exception
{
	DateUtil du = new DateUtil();
	Query query;
	String hql="";
    year = String.valueOf(du.getThisYear());
	Session session = HibernateSessionFactory.getSession();
	Transaction trans = session.beginTransaction();
	UserInfoDAO uidao = new UserInfoDAO();
	UserInfo ui = uidao.findByNewNumber(newnumber);
	String authoU = ui.getAuthority().substring(20, 21);
	if(authoU.equals("U"))
	{
		hql = "from Tplan as tp where tp.chu in (11,12,13,14) and tp.year= '"+year+"'";
		title=year+"年度培训计划表";
	}
	else
	{
		hql = "from Tplan as tp where tp.chu ="+chu+" and tp.year= '"+year+"'";
		title = chutotitle(chu,year);
	}
	TplanDAO tpdao = new TplanDAO();  
	query = session.createQuery(hql);
	query.setFirstResult(pageSize * (currentPage - 1));
	query.setMaxResults(pageSize);
	totalRows = session.createQuery(hql).list().size();
	initPageProperties();
	listtp = query.list();
	//listtp = tpdao.findByChuAndYear(chu,year);
	
	trans.commit();
	session.flush();
	session.clear();
	session.close();

	return "success";
}

protected void initPageProperties() {

	if (totalRows == -1) {
		//log.error("没有初始化totalRows参数！");
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

public String chutotitle(int chu, String year)
{
	if(chu==1)
	{
		return year+"年度综合与生产管理处培训计划表";
	}
	else if (chu==3)
	{
		return year+"年度通用业务二处培训计划表";
	}
	
	else if (chu==2)
	{
		return year+"年度合规与监督二处培训计划表";
	}
	else if (chu==5)
	{
		return year+"年度研发支持二处培训计划表";
	}
	else
	{
		return year+"年度专业处理二处培训计划表";
	}
}
}
