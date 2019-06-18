package com.sam.project.frameworktype.flyweight;

public class Client {
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Character status = 'a';

		Flyweight item1 = factory.create(status);
		Flyweight item2 = factory.create(status);
		System.out.println(item1 == item2);
	}
}
