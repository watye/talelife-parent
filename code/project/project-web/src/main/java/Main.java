

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.talelife.project.service.BookService;

public class Main {

	public static void main(String[] args) throws IOException {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring-context.xml"});
		 BookService bookService = context.getBean(BookService.class);
		 System.out.println(bookService.findAll());
	}

}
