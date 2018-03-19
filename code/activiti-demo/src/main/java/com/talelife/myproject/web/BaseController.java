package com.talelife.myproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.talelife.util.Result;

public class BaseController {
	protected static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@ExceptionHandler
	public Result exceptionHandle(Exception exception){
		logger.error(exception.getMessage(),exception);
		return Result.fail(exception.getMessage());
	}
}
