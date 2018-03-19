package ${entity.packageName}.mapper;
import ${entity.packageName}.model.${entity.name};
import java.util.List;
/**
 * ${entity.comment}数据操作接口
 * date: $dateFormat.format(${config.date})
 * 
 * @author ${config.author}
 * @version 1.0
 */
public interface ${entity.name}Mapper{
	List<${entity.name}> findAll();
	
	List<${entity.name}> findList(${entity.name} ${entity.varName});
	
	int add(${entity.name} ${entity.varName});
	
	int update(${entity.name} ${entity.varName});
	
	${entity.name} findByPK(#foreach($property in $entity.primaryKeys)${property.type} ${property.name}#end);
	
	int delete(#foreach($property in $entity.primaryKeys)${property.type} ${property.name}#end);
}