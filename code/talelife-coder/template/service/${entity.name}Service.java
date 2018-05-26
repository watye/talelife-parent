package ${entity.packageName}.service;
import ${entity.packageName}.model.${entity.name};
import java.util.List;

import ${entity.packageName}.service.${entity.name}Service.${entity.name}Query;
import com.talelife.util.Page;
/**
 * ${entity.comment}业务接口
 * date: $dateFormat.format(${config.date})
 * 
 * @author ${config.author}
 * @version 1.0
 */
public interface ${entity.name}Service{
	List<${entity.name}> findAll();
	
	List<${entity.name}> findList(${entity.name}Query query);
	
	Page<${entity.name}> findPage(${entity.name}Query query);
	
	int add(${entity.name} ${entity.varName});
	
	int delete(#foreach($property in $entity.primaryKeys)${property.type} ${property.name}#end);
	
	int update(${entity.name} ${entity.varName});
	
	${entity.name} findByPK(#foreach($property in $entity.primaryKeys)${property.type} ${property.name}#end);
	
	public static class ${entity.name}Query extends ${entity.name}{

		private Integer pageNum=1;
		private Integer pageSize=Page.DEFAULT_PAGE_SIZE;
		public Integer getPageNum() {
			return pageNum;
		}
		public void setPageNum(Integer pageNum) {
			this.pageNum = pageNum;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
	}
}