package com.talelife.util;

/**
 * 业务运行异常
 * @author Liuweiyao
 *
 */
public class BusinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7331592920433471715L;

	public BusinessException() {
		super();
	}

	public BusinessException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public BusinessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BusinessException(String arg0) {
		super(arg0);
	}

	public BusinessException(Throwable arg0) {
		super(arg0);
	}
	

}
