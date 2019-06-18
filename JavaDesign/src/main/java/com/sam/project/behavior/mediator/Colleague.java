package com.sam.project.behavior.mediator;

//"同事"类抽象类
public abstract class Colleague {

	public String name;

	public Colleague(String name) {
		this.name = name;
	}

	public abstract void create();
}
