package com.sam.project.behavior.template;

//模版具体实现类B
public class RealemplateB extends AbstractTemplate {

	@Override
	public void methodA(String msg) {
		System.out.println("B类 业务A处理..." + msg);
	}

	@Override
	public void methodB(String msg) {
		System.out.println("B类 业务B处理..." + msg);
	}
}
