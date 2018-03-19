package com.talelife.project.test;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.talelife.project.model.Book;
import com.talelife.project.service.BookService;
import com.talelife.util.Page;

/**
 * 书籍测试用例
 * date: 2017-02-09 14:38:55
 * 
 * @author Liuweiyao
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/spring-context.xml")
public class BookTest {
	 @Autowired
	 private BookService bookService;
	 
	 @Test
	 public void findAll(){
		 List<Book> list = bookService.findAll();
		 System.out.println(list);
	 }
	 
	 @Test
	 public void findList(){
		 BookService.BookQuery query = new BookService.BookQuery();
		 List<Book> list = bookService.findList(query);
		 System.out.println(JSON.toJSONString(list));
	 }
	 
	 @Test
	 public void findPage(){
		 BookService.BookQuery query = new BookService.BookQuery();
		 query.setPageNum(2);
		 Page<Book> list = bookService.findPage(query);
		 
		 System.out.println(JSON.toJSONString(list));
	 }
}
