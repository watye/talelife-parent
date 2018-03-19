package com.talelife.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
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
		book.setName("涔�1");
		bookService.add(book);
		return Result.success();
	}
	
	@RequestMapping("/test_session")
    public Result testSession(HttpServletRequest request) {
		Book book = new Book();
		book.setName("booook");
		request.getSession().setAttribute("book",book);
		return Result.success();
    }
}
