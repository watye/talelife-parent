package com.talelife.project.model;
import java.io.Serializable;
/**
 * 书籍实体类
 * date: 2017-02-09 14:38:55
 * 
 * @author Liuweiyao
 * @version 1.0
 */
public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -82271414026020928L;

	//
	private Long id;
	
	//名称
	private String name;
	
	//价格
	private Double price;
	

	public Long getId(){
		return id;
	}
	
	public Long setId(Long id){
 	    return this.id=id;
    }
	public String getName(){
		return name;
	}
	
	public String setName(String name){
 	    return this.name=name;
    }
	public Double getPrice(){
		return price;
	}
	
	public Double setPrice(double price){
 	    return this.price=price;
    }

}