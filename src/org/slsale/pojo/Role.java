package org.slsale.pojo;

import java.util.Date;
//对应角色表
public class Role extends Base{
	//id
	private Integer id;
	//角色编号
	private String roleCode;
	//角色名称
	private String roleName;
	//是否启用		1.启用  2.未启用
	private Integer isStart;
	//创建时间
	private Date createDate;
	//创建者   取自au_user表中的loginCode
	private String createdBy;
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getIsStart() {
		return isStart;
	}
	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
