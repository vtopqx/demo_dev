package com.sam.project.behavior.mediator;

//"同事"类(CPU)
public class CpuColleague extends Colleague {
	public CpuColleague(String name) {
		super(name);
	}

	@Override
	public void create() {
		System.out.println("创建:" + name + " cpu");
	}
}
