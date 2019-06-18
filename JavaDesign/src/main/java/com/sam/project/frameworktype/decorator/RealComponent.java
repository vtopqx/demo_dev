package com.sam.project.frameworktype.decorator;

//具体实现
public class RealComponent implements Component{

	@Override
	public void operation() {
		System.out.println("具体操作...");
	}
}
