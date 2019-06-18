package com.sam.project.behavior.template;

//模版具体实现类A
public class RealemplateA extends AbstractTemplate {

	@Override
	public void methodA(String msg) {
		System.out.println("A类 业务A处理..."+msg);
	}

	@Override
	public void methodB(String msg) {
		System.out.println("A类 业务B处理..."+msg);
	}
}
