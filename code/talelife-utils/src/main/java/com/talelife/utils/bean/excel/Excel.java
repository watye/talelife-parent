package com.talelife.utils.bean.excel;

import java.util.ArrayList;
import java.util.List;

public class Excel {
	
	private String name;
	
	private List<Sheet> sheets = new ArrayList<Sheet>();

	public List<Sheet> getSheets() {
		return sheets;
	}

	public void setSheets(List<Sheet> sheets) {
		this.sheets = sheets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addSheet(Sheet sheet){
		this.sheets.add(sheet);
	}
}
