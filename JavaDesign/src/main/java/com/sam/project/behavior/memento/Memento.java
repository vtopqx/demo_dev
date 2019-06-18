package com.sam.project.behavior.memento;

//备忘录类
public class Memento {

	private String status;

	public Memento(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
