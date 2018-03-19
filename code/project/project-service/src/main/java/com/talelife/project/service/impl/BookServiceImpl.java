package com.talelife.project.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talelife.project.service.BookService;
import com.talelife.util.BusinessException;
import com.talelife.util.Page;
import com.talelife.project.mapper.BookMapper;
import com.talelife.project.model.Book;
import javax.annotation.Resource;
import java.util.List;
/**
 * 涔︾睄涓氬姟瀹炵幇绫�
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
		query.setPageNum(null);
		return bookMapper.findList(query);
	}
	
	public Page<Book> findPage(BookQuery query) {
		return new Page<Book>(bookMapper.findPage(query));
	}
	
	@Transactional
	public int add(Book book){
		int r = bookMapper.add(book);
		if(true){
			throw new BusinessException("aa");
		}
		return r;
	}
	
	public int delete(long id){
		return bookMapper.delete(id);
	}
	
	public int update(Book book){
		return bookMapper.update(book);
	}
	
	public Book findByPK(long id){
		return bookMapper.findByPK(id);
	}

	
}