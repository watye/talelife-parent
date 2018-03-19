package com.talelife.coder.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Config {
	//生成的文件输出路径
	private String fileOutputPath;
	//作者
	private String author;
	//创建日期
	private Date date = new Date();
	//生成表
	private List<Map<String,String>> tableConfig = new ArrayList<Map<String,String>>();
	
	public String getFileOutputPath() {
		return fileOutputPath;
	}
	public void setFileOutputPath(String fileOutputPath) {
		this.fileOutputPath = fileOutputPath;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Map<String, String>> getTableConfig() {
		return tableConfig;
	}
	public void setTableConfig(List<Map<String, String>> tableConfig) {
		this.tableConfig = tableConfig;
	}
	
}
