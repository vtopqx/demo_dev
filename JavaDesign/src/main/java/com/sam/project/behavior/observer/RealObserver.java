package com.sam.project.behavior.observer;

//具体观察者类
public class RealObserver implements Observer {

	private String name;
	private String innerStatus;

	public RealObserver(String name) {
		super();
		this.name = name;
	}

	@Override
	public void update(String status) {
		this.innerStatus = status;
		System.out.println("观察者" + name + "，状态:" + innerStatus);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
