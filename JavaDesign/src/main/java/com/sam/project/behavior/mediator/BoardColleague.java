package com.sam.project.behavior.mediator;

//"同事"类(主板)
public class BoardColleague extends Colleague {

	public BoardColleague(String name) {
		super(name);
	}

	@Override
	public void create() {
		System.out.println("创建:" + name + " 主板");
	}
}
