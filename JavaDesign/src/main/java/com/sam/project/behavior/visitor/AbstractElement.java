package com.sam.project.behavior.visitor;

//抽象元素类
public abstract class AbstractElement {
	// 接收访问者访问
	public abstract void accept(IVisitor visitor);

	// 本身的业务逻辑
	public abstract void doSomething();
}
