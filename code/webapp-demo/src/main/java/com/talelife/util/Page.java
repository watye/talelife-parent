package com.talelife.util;

import java.io.Serializable;
import java.util.List;

public final class Page<E> implements Serializable{
	private static final long serialVersionUID = -2775453835720800655L;
	private int pageNum;
    /**
     * 妞ょ敻娼版径褍鐨�
     */
    private int pageSize;
    /**
     * 鐠у嘲顫愮悰锟�
     */
    private int startRow;
    /**
     * 閺堫偉顢�
     */
    private int endRow;
    /**
     * 閹粯鏆�
     */
    private long total;
    /**
     * 閹銆夐弫锟�
     */
    private int pages;
    /**
     * 閸栧懎鎯坈ount閺屻儴顕�
     */
    private boolean count = true;
    /**
     * 閸掑棝銆夐崥鍫㈡倞閸栵拷
     */
    private Boolean reasonable;
    /**
     * 瑜版捁顔曠純顔昏礋true閻ㄥ嫭妞傞崐娆欑礉婵″倹鐏塸agesize鐠佸墽鐤嗘稉锟�0閿涘牊鍨≧owBounds閻ㄥ埐imit=0閿涘绱濈亸鍙樼瑝閹笛嗩攽閸掑棝銆夐敍宀冪箲閸ョ偛鍙忛柈銊х波閺嬶拷
     */
    private Boolean pageSizeZero;
    
    private List<E> data;

    
	public Page() {
		super();
	}
	
	public Page(com.github.pagehelper.Page<E> page) {
		super();
		this.data = page.getResult();
		this.pageSize = page.getPageSize();
		this.count = page.isCount();
		this.endRow = page.getEndRow();
		this.pageNum = page.getPageNum();
		this.pageSizeZero = page.getPageSizeZero();
		this.reasonable = page.getReasonable();
		this.startRow = page.getStartRow();
		this.total = page.getTotal();
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public boolean isCount() {
		return count;
	}

	public void setCount(boolean count) {
		this.count = count;
	}

	public Boolean getReasonable() {
		return reasonable;
	}

	public void setReasonable(Boolean reasonable) {
		this.reasonable = reasonable;
	}

	public Boolean getPageSizeZero() {
		return pageSizeZero;
	}

	public void setPageSizeZero(Boolean pageSizeZero) {
		this.pageSizeZero = pageSizeZero;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}
	
    
}
