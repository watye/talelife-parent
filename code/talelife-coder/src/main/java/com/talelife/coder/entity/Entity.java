package com.talelife.coder.entity;

import java.util.List;
/**
 * 表对应的java类
 * @author watye
 *
 */
public class Entity {
	//名称
	private String name;
	//变量名称
	private String varName;
	//实体描述
	private String comment;
	//实体包名
	private String packageName;
	//主键
	private List<Property> primaryKeys;
	//属性
	private List<Property> properties;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Property> getPrimaryKeys() {
		return primaryKeys;
	}
	public void setPrimaryKeys(List<Property> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
}
