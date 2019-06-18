package com.sam.project.createtype.builder;

//抽象建造者（Builder）角色：
public interface Builder {
	//创建CPU组件
	public void createCpu();
	//创建主板组件
	public void createBoard();
	//.....
	//组装电脑
	public Computer buildComputer();
}
