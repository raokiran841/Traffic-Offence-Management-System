package com.tms.tmsapplication.entity;

import javax.persistence.*;

@Entity
@Table(name="TM_ROLEMASTER")
public class RoleEO {
	@Id
	@Column(name="ROLENAME")
	private String roleName;
	
	@Column(name="ROLE_DESC")
	private String roleDesc;
	
	public RoleEO() {
		
	}

	public RoleEO(String roleName, String roleDesc) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "RoleEO [roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
	}

}