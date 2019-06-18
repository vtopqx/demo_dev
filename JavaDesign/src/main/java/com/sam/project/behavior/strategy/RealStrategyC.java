package com.sam.project.behavior.strategy;

//具体策略实现C
public class RealStrategyC implements Strategy {

	@Override
	public void handle() {
		System.out.println("策略C开始执行...");
	}
}
