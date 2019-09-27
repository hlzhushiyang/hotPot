package com.tedu.pojo;
/**
* @author 作者：Fiona
* @version 创建时间：2019年9月18日 上午9:15:19
* @description 描述：
*/
public class Emp {
	private String name;
	private String job;
	private Double sal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", job=" + job + ", sal=" + sal + "]";
	}
	
}
