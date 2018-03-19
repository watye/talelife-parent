package com.syswin.budget.model;
import java.io.Serializable;
import java.util.Date;
/**
 * 组实体类
 * date: 2017-02-20 10:01:41
 * 
 * @author Liuweiyao
 * @version 1.0
 */
public class Group implements Serializable{
	//主键
	private String id;
	
	//群组名
	private String groupname;
	
	//群头像
	private String avatar;
	
	//创建者
	private String createBy;
	
	//创建时间
	private Date createDate;
	
	//更新者
	private String updateBy;
	
	//更新时间
	private Date updateDate;
	
	//备注信息
	private String remarks;
	
	//逻辑删除标记（0：显示；1：隐藏）
	private String delFlag;
	

	public String getId(){
		return id;
	}
	
	public String setId(String id){
 	    return this.id=id;
    }
	public String getGroupname(){
		return groupname;
	}
	
	public String setGroupname(String groupname){
 	    return this.groupname=groupname;
    }
	public String getAvatar(){
		return avatar;
	}
	
	public String setAvatar(String avatar){
 	    return this.avatar=avatar;
    }
	public String getCreateBy(){
		return createBy;
	}
	
	public String setCreateBy(String createBy){
 	    return this.createBy=createBy;
    }
	public Date getCreateDate(){
		return createDate;
	}
	
	public Date setCreateDate(Date createDate){
 	    return this.createDate=createDate;
    }
	public String getUpdateBy(){
		return updateBy;
	}
	
	public String setUpdateBy(String updateBy){
 	    return this.updateBy=updateBy;
    }
	public Date getUpdateDate(){
		return updateDate;
	}
	
	public Date setUpdateDate(Date updateDate){
 	    return this.updateDate=updateDate;
    }
	public String getRemarks(){
		return remarks;
	}
	
	public String setRemarks(String remarks){
 	    return this.remarks=remarks;
    }
	public String getDelFlag(){
		return delFlag;
	}
	
	public String setDelFlag(String delFlag){
 	    return this.delFlag=delFlag;
    }

}