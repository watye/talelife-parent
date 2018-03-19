package com.talelife.project.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talelife.project.mapper.BookMapper;
import com.talelife.project.model.Book;
import com.talelife.project.service.BookService;
import com.talelife.project.service.BookService.BookQuery;
import com.talelife.util.Page;
/**
 * 娑旓妇鐫勬稉姘鐎圭偟骞囩猾锟�
 * date: 2017-02-09 14:38:55
 * 
 * @author Liuweiyao
 * @version 1.0
 */
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookMapper bookMapper;
	
	public List<Book> findAll(){
		return bookMapper.findAll();
	}
	
	public List<Book> findList(BookQuery query){
		query.setPageNum(-1);
		return bookMapper.findList(query);
	}
	
	public Page<Book> findPage(BookQuery query) {
		return new Page<Book>(bookMapper.findPage(query));
	}
	
	public int add(Book book){
		return bookMapper.add(book);
	}
	
	public int delete(Long id){
		return bookMapper.delete(id);
	}
	
	public int update(Book book){
		return bookMapper.update(book);
	}
	
	public Book findByPK(Long id){
		return bookMapper.findByPK(id);
	}
	
	
}