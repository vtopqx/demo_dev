package com.sam.project.behavior.template;

//抽象模板角色类
public abstract class AbstractTemplate {

	// 模板方法
	public final void request(String msg) {
		methodA(msg);
		methodB(msg);
		success();
	}

	// 基本方法留给子类实现
	public abstract void methodA(String msg);

	// 基本方法留给子类实现
	public abstract void methodB(String msg);

	// 基本方法，已经实现
	private void success() {
		System.out.println("执行处理完成!");
		// 业务处理逻辑...
	}

}
