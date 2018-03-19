package ${entity.packageName}.service.impl;
import org.springframework.stereotype.Service;
import ${entity.packageName}.service.${entity.name}Service;
import ${entity.packageName}.mapper.${entity.name}Mapper;
import ${entity.packageName}.model.${entity.name};
import javax.annotation.Resource;
import java.util.List;
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
	
	public List<${entity.name}> findList(${entity.name} ${entity.varName}){
		return ${entity.varName}Mapper.findList(${entity.varName});
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