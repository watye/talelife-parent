package com.talelife.utils.bean.excel;

import java.util.ArrayList;
import java.util.List;

public class Sheet {
	private String name;
	private Row title;
	private List<Row> rows = new ArrayList<Row>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Row> getRows() {
		return rows;
	}
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	public void addRow(Row row){
		this.rows.add(row);
	}
	public Row getTitle() {
		return title;
	}
	public void setTitle(Row title) {
		this.title = title;
	}
	
	
}
