package com.sam.project.behavior.memento;

//发起人角色类
public class Originator {
	// 状态
	private String status;

	// 创建备忘录对象
	public Memento createMemento() {
		return new Memento(status);
	}

	// 恢复状态
	public void replyMemento(Memento memento) {
		this.status = memento.getStatus();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
