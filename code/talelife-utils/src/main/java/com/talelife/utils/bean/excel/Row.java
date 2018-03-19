package com.talelife.utils.bean.excel;

import java.util.ArrayList;
import java.util.List;

public class Row {
	private List<Cell> cells = new ArrayList<Cell>();
	
	public List<Cell> getCells() {
		return cells;
	}
	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}
	public void addCell(Cell cell){
		this.cells.add(cell);
	}
	
	public Cell getCell(int index){
		return cells.get(index);
	}
}
