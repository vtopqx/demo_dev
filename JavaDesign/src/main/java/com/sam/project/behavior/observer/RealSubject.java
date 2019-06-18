package com.sam.project.behavior.observer;

//具体主题角色类
public class RealSubject extends Subject {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void change(String status) {
		System.out.println("当前主题状态:" + status);
		super.change(status);
	}
}
