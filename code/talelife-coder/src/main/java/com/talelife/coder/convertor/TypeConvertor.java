package com.talelife.coder.convertor;

import java.util.HashMap;
import java.util.Map;

/**
 * 类型转换器
 * @author watye
 *
 */
public class TypeConvertor {
	private Map<String,String> typeMap = new HashMap<String,String>();

	public Map<String, String> getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(Map<String, String> typeMap) {
		this.typeMap = typeMap;
	}
	
	public String getType(String origType){
		//类型转换
		String type = origType;
		String destTye = typeMap.get(origType);
		if(destTye != null){
			type = destTye;
		}
		
		//类型缩写
		if(type.startsWith("java.lang.")){
			type = type.substring(10);
		}
		
		return type;
	}
}
