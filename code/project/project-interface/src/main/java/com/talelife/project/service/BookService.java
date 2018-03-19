package com.talelife.project.service;
import java.util.List;

import com.talelife.project.model.Book;
import com.talelife.util.Page;
/**
 * 书籍业务接口
 * date: 2017-02-09 14:38:55
 * 
 * @author Liuweiyao
 * @version 1.0
 */
public interface BookService{
	/**
	 * 查询全部
	 * @return
	 */
	List<Book> findAll();
	
	/**
	 * 带条件查询
	 * @param query
	 * @return
	 */
	List<Book> findList(BookQuery query);
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	Page<Book> findPage(BookQuery query);
	
	/**
	 * 新增
	 * @param book
	 * @return
	 */
	int add(Book book);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delete(long id);
	
	/**
	 * 修改
	 * @param book
	 * @return
	 */
	int update(Book book);
	
	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	Book findByPK(long id);
	
	public static class BookQuery extends Book{

		private static final long serialVersionUID = 2267247332350702957L;
		private Integer pageNum=1;
		private Integer pageSize=Page.DEFAULT_PAGE_SIZE;
		public Integer getPageNum() {
			return pageNum;
		}
		public void setPageNum(Integer pageNum) {
			this.pageNum = pageNum;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
	}
}