package com.talelife.coder.entity;

import java.util.List;

/**
 * 数据库表
 * @author watye
 *
 */
public class Table {
	//表名
	private String name;
	//备注
	private String comment;
	//字段
	private List<Column> columns;
	//主键
	private List<Column> primaryKeys;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public List<Column> getPrimaryKeys() {
		return primaryKeys;
	}
	public void setPrimaryKeys(List<Column> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}
}
