package com.sam.project.createtype.prototype;

public class Instance2 extends Prototype {
	public Instance2() {
		type = "Instance2";
	}
	@Override
	void show() {
		System.out.println("Inside Square::draw() method.");
	}
}
