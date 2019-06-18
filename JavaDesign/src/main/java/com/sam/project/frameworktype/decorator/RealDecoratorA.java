package com.sam.project.frameworktype.decorator;

//具体装饰角色A
public class RealDecoratorA extends Decorator {

	public RealDecoratorA(Component c) {
		super(c);
	}

	@Override
	public void operation() {
		super.operation();
		System.out.println("...自定义处理A...");
	}
}
