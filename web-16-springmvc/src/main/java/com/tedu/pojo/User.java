package com.tedu.pojo;
/**
* @author 作者：Fiona
* @version 创建时间：2019年9月17日 下午5:21:41
* @description 描述：
*/
public class User {
	private String name;
	private Integer age;
	private String addr;
	
	public User(){}
	public User(String name, Integer age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
}
