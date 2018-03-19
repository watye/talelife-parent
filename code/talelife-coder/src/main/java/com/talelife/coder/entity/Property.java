package com.talelife.coder.entity;
/**
 * 实体属性
 * @author watye
 *
 */
public class Property {
	//属性名称
	private String name;
	//字段名
	private String columnName;
	//类型
	private String type;
	//属性备注
	private String comment;
	//名称首字母大写
	private String capName;
	//是否主键
	private Boolean isPk;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCapName() {
		return capName;
	}
	public void setCapName(String capName) {
		this.capName = capName;
	}
	public Boolean getIsPk() {
		return isPk;
	}
	public void setIsPk(Boolean isPk) {
		this.isPk = isPk;
	}
}
