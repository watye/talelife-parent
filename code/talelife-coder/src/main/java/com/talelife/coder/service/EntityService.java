package com.talelife.coder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.talelife.coder.convertor.TypeConvertor;
import com.talelife.coder.entity.Column;
import com.talelife.coder.entity.Entity;
import com.talelife.coder.entity.Property;
import com.talelife.coder.entity.Table;

@Service
public class EntityService {
	@Autowired
	private TypeConvertor typeConvertor;
	
	public Entity getEntityInfo(Table table,Map<String,String> tableConfig){
		
		Entity entity = new Entity();
		List<Property> properties = new ArrayList<Property>();
		entity.setProperties(properties);
		
		entity.setName(tableConfig.get("entityName"));
		entity.setVarName(StringUtils.uncapitalize(entity.getName()));
		entity.setComment(tableConfig.get("entityComment"));
		entity.setPackageName(tableConfig.get("packageName"));
		
		if(StringUtils.isEmpty(table.getColumns()))
			return entity;
		
		for(int i=0;i<table.getColumns().size();i++){
			Column column = table.getColumns().get(i);
			Property property = new Property();
			//转成骆峰式
			String colName = column.getName();
			property.setName(colName.indexOf("_")==-1?StringUtils.uncapitalize(colName):com.talelife.coder.util.StringUtils.enCamel(colName));
			property.setColumnName(colName);
			property.setType(typeConvertor.getType(column.getType()));
			property.setComment(column.getComment());
			property.setIsPk(column.getIsPk());
			property.setCapName(StringUtils.capitalize(property.getName()));
			properties.add(property);
		}
		
		//主键
		List<Property> pks = new ArrayList<Property>();
		entity.setPrimaryKeys(pks);
		for(Property property : properties){
			if(property.getIsPk())
				pks.add(property);
		}
		
		return entity;
	}
	
}
