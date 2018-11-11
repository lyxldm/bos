package cn.ldm.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 鏉冮檺瀹炰綋
 */

public class Function implements java.io.Serializable {

	// Fields

	private String id;
	private Function parentFunction;//褰撳墠鏉冮檺鐨勪笂绾ф潈闄�
	private String name;
	private String code;
	private String description;
	private String page;
	private String generatemenu;//鏄惁鐢熸垚鑿滃崟锛�1锛氭槸 0锛氬惁
	private Integer zindex;
	private Set roles = new HashSet(0);//褰撳墠鏉冮檺瀵瑰簲鐨勫涓鑹�
	private Set children = new HashSet(0);//褰撳墠鏉冮檺鐨勪笅绾ф潈闄�
	private String pId;
	
	public String getpId() {
		if(parentFunction==null){
			return "0";
		}else{
			return parentFunction.getId();
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Function getParentFunction() {
		return parentFunction;
	}
	public void setParentFunction(Function parentFunction) {
		this.parentFunction = parentFunction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getGeneratemenu() {
		return generatemenu;
	}
	public void setGeneratemenu(String generatemenu) {
		this.generatemenu = generatemenu;
	}
	public Integer getZindex() {
		return zindex;
	}
	public void setZindex(Integer zindex) {
		this.zindex = zindex;
	}
	public Set getRoles() {
		return roles;
	}
	public void setRoles(Set roles) {
		this.roles = roles;
	}
	public Set getChildren() {
		return children;
	}
	public void setChildren(Set children) {
		this.children = children;
	}
}