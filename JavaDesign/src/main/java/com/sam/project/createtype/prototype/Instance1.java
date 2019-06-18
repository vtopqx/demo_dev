package com.sam.project.createtype.prototype;

public class Instance1 extends Prototype {
	public Instance1() {
		type = "Instance1";
	}

	@Override
	void show() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
