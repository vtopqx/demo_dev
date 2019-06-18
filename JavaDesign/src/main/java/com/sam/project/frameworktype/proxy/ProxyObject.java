package com.sam.project.frameworktype.proxy;

public class ProxyObject extends AbstractObject {
	private RealObject real = new RealObject();

	@Override
	public void method() {
		// TODO Auto-generated method stub
		before();
		real.method();
		after();
	}
	//执行方法前后自定义处理
	private void before() {
		System.out.println("before....");
	}

	private void after() {
		System.out.println("after....");
	}
}
