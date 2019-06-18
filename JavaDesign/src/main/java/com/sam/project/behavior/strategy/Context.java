package com.sam.project.behavior.strategy;

//环境角色类
public class Context {
	// 引用策略
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	// 执行请求
	public void request() {
		this.strategy.handle();
	}
}
