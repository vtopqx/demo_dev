package com.sam.project.behavior.memento;

//负责人角色
public class Caretaker {
	//备忘录
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
