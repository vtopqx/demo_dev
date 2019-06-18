package com.sam.project.behavior.status;

//具体状态类实现B
public class RealStateB implements State {

	// 具体行为实现
	@Override
	public void handle() {
		System.out.println("状态B...");
		System.out.println("执行B操作...");
	}
}
