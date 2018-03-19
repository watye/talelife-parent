package com.talelife.project.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talelife.project.model.Book;
import com.talelife.project.service.BookService;
import com.talelife.util.Page;
import com.talelife.util.Result;

@RestController
@RequestMapping("/book")
public class BookController extends BaseController{
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/all")
    public Result findAll() {
		List<Book> list= bookService.findAll();
		return Result.success(list);
    }
	
	@RequestMapping("/page")
	public Result page() {
		 BookService.BookQuery query = new BookService.BookQuery();
		 query.setPageNum(1);
		 Page<Book> list = bookService.findPage(query);
		 return Result.success(list);
	}
	
	@RequestMapping("/add")
	public Result add() {
		Book book = new Book();
		book.setName("书1");
		book.setPrice(100);
		bookService.add(book);
		return Result.success();
	}
}
