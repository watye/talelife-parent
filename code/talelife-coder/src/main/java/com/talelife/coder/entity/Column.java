package com.talelife.coder.entity;

public class Column {
	//列名
	private String name;
	//类型
	private String type;
	//长度
	private Integer length;
	//是否主键
	private Boolean isPk;
	//是否必填
	private Boolean isNull;
	//备注
	private String comment;
	//对应的属性名
	private String propertyName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Boolean getIsPk() {
		return isPk;
	}
	public void setIsPk(Boolean isPk) {
		this.isPk = isPk;
	}
	public Boolean getIsNull() {
		return isNull;
	}
	public void setIsNull(Boolean isNull) {
		this.isNull = isNull;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
}
