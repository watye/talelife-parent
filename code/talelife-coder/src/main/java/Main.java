import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.talelife.coder.CoderService;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		new ClassPathXmlApplicationContext("config.xml").getBean(CoderService.class).generate();
	}

}
