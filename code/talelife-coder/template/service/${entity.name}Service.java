package ${entity.packageName}.service;
import ${entity.packageName}.model.${entity.name};
import java.util.List;
/**
 * ${entity.comment}业务接口
 * date: $dateFormat.format(${config.date})
 * 
 * @author ${config.author}
 * @version 1.0
 */
public interface ${entity.name}Service{
	List<${entity.name}> findAll();
	
	List<${entity.name}> findList(${entity.name} ${entity.varName});
	
	int add(${entity.name} ${entity.varName});
	
	int delete(#foreach($property in $entity.primaryKeys)${property.type} ${property.name}#end);
	
	int update(${entity.name} ${entity.varName});
	
	${entity.name} findByPK(#foreach($property in $entity.primaryKeys)${property.type} ${property.name}#end);
}