package com.sam.project.behavior.strategy;

//具体策略实现B
public class RealStrategyB implements Strategy {

	@Override
	public void handle() {
		System.out.println("策略B开始执行...");
	}
}
