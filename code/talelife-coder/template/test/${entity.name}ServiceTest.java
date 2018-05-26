package ${entity.packageName}.test;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ${entity.packageName}.service.${entity.name}Service;
import ${entity.packageName}.service.${entity.name}Service.${entity.name}Query;

/**
 * ${entity.comment}测试用例
 * date: $dateFormat.format(${config.date})
 * 
 * @author ${config.author}
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ${entity.name}ServiceTest {
	
	 @Autowired
	 private ${entity.name}Service ${entity.varName}Service;
	 
	 @Test
	 public void testFindAll(){
		 ${entity.varName}Service.findAll();
	 }
	 
	 @Test
	 public void testFindPage(){
		 ${entity.name}Query query = new ${entity.name}Query();
		 query.setPageNum(2);
		 ${entity.varName}Service.findPage(query);
	 }
}
