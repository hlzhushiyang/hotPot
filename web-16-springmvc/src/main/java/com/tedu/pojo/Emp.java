package com.tedu.pojo;
/**
* @author ���ߣ�Fiona
* @version ����ʱ�䣺2019��9��18�� ����9:15:19
* @description ������
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
