package com.sam.project.frameworktype.decorator;

//装饰角色
public class Decorator implements Component {

	private Component component;

	public Decorator(Component c) {
		this.component = c;
	}

	@Override
	public void operation() {
		this.component.operation();
	}
}
