package com.sam.project.behavior.visitor;

//元素具体实现B
public class ConcreteElementB extends AbstractElement {
	// 本身的业务逻辑
	public void doSomething() {
		System.out.println("这是元素2");
	}

	// 接收访问者访问
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
}
