package ${entity.packageName}.model;
import java.io.Serializable;
import java.util.Date;
/**
 * ${entity.comment}实体类
 * date: $dateFormat.format(${config.date})
 * 
 * @author ${config.author}
 * @version 1.0
 */
public class ${entity.name} implements Serializable{
#foreach($property in $entity.properties)
	//${property.comment}
	private ${property.type} ${property.name};
	
#end

#foreach($property in $entity.properties)
	public ${property.type} get${property.capName}(){
		return ${property.name};
	}
	
	public void set${property.capName}(${property.type} ${property.name}){
 	    this.${property.name}=${property.name};
    }
#end

}