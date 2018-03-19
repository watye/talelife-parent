package com.talelife.util;

public class Result{
	private boolean success = false;
	private String message;
	private Object data;
	
	private Result(){}

	public static Result success(){
		Result rs = new Result();
		rs.setSuccess(true);
		return rs;
	}
	
	public static Result success(String data){
		Result rs = new Result();
		rs.setSuccess(true);
		rs.setData(data);
		return rs;
	}
	
	public static Result success(Object data){
		Result rs = new Result();
		if(data instanceof String) {
			rs.setMessage((String)data);
		}
		rs.setSuccess(true);
		rs.setData(data);
		return rs;
	}
	
	public static Result fail(){
		Result rs = new Result();
		rs.setSuccess(false);
		return rs;
	}
	
	public static Result fail(String msg){
		Result rs = new Result();
		rs.setSuccess(false);
		rs.setMessage(msg);
		return rs;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
