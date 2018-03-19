package ${entity.packageName}.test;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ${entity.packageName}.service.${entity.name}Service;

/**
 * ${entity.comment}测试用例
 * date: $dateFormat.format(${config.date})
 * 
 * @author ${config.author}
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/spring-context.xml")
public class ${entity.name}Test {
	 @Autowired
	 private ${entity.name}Service ${entity.varName}Service;
	 
	 @Test
	 public void testFindAll(){
		 ${entity.varName}Service.findAll();
	 }
}
