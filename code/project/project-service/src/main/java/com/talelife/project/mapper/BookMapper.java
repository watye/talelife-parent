package com.talelife.project.mapper;
import com.github.pagehelper.Page;
import com.talelife.project.model.Book;
import com.talelife.project.service.BookService.BookQuery;

import java.util.List;

/**
 * 书籍数据操作接口
 * date: 2017-02-09 14:38:55
 * 
 * @author Liuweiyao
 * @version 1.0
 */
public interface BookMapper{
	List<Book> findAll();
	
	List<Book> findList(BookQuery book);
	
	Page<Book> findPage(BookQuery book);
	
	int add(Book book);
	
	int update(Book book);
	
	Book findByPK(Long id);
	
	int delete(Long id);
}