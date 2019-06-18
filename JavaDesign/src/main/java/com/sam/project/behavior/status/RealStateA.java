package com.sam.project.behavior.status;

//具体状态类实现A
public class RealStateA implements State {

	// 具体行为实现
	@Override
	public void handle() {
		System.out.println("状态A...");
		System.out.println("执行A操作...");
	}
}
