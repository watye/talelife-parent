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
	List<Book> findAll();
	
	List<Book> findList(BookQuery book);
	
	Page<Book> findPage(BookQuery query);
	
	int add(Book book);
	
	int delete(Long id);
	
	int update(Book book);
	
	Book findByPK(Long id);
	
	public static class BookQuery extends Book{

		private static final long serialVersionUID = 2267247332350702957L;
		private Integer pageNum=0;
		private Integer pageSize=5;
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