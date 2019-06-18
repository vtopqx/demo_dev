package com.sam.project.behavior.strategy;

//具体策略实现A
public class RealStrategyA implements Strategy {

	@Override
	public void handle() {
		System.out.println("策略A开始执行...");
	}
}
