package com.sam.project.behavior.visitor;

//访问者具体实现
public class RealVisitor implements IVisitor {

	public void visit(AbstractElement element) {
		element.doSomething();
	}
}
