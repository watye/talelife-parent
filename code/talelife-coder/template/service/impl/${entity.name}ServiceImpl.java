package ${entity.packageName}.service.impl;
import ${entity.packageName}.service.${entity.name}Service;
import ${entity.packageName}.mapper.${entity.name}Mapper;
import ${entity.packageName}.model.${entity.name};
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.talelife.util.Page;
/**
 * ${entity.comment}业务实现类
 * date: $dateFormat.format(${config.date})
 * 
 * @author ${config.author}
 * @version 1.0
 */
@Service
public class ${entity.name}ServiceImpl implements ${entity.name}Service{
	
	@Resource
	private ${entity.name}Mapper ${entity.varName}Mapper;
	
	public List<${entity.name}> findAll(){
		return ${entity.varName}Mapper.findAll();
	}
	
	public List<${entity.name}> findList(${entity.name}Query query){
		query.setPageNum(null);
		return ${entity.varName}Mapper.findList(query);
	}
	
	public Page<${entity.name}> findPage(${entity.name}Query query) {
		return new Page<${entity.name}>(${entity.varName}Mapper.findPage(query));
	}
	
	public int add(${entity.name} ${entity.varName}){
		return ${entity.varName}Mapper.add(${entity.varName});
	}
	
	public int delete(#foreach($property in $entity.primaryKeys)${property.type} ${property.name}#end){
		return ${entity.varName}Mapper.delete(#foreach($property in $entity.primaryKeys)${property.name}#end);
	}
	
	public int update(${entity.name} ${entity.varName}){
		return ${entity.varName}Mapper.update(${entity.varName});
	}
	
	public ${entity.name} findByPK(#foreach($property in $entity.primaryKeys)${property.type} ${property.name}#end){
		return ${entity.varName}Mapper.findByPK(#foreach($property in $entity.primaryKeys)${property.name}#end);
	}
	
	
	
	
	
}