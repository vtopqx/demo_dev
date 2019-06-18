package com.sam.project.behavior.mediator;

//中介类
public class Mediator {
	// 将多个"同事"类进行集成
	private CpuColleague cpuColleague;
	private BoardColleague boardColleague;

	public Mediator(CpuColleague cpuColleague, BoardColleague boardColleague) {
		this.cpuColleague = cpuColleague;
		this.boardColleague = boardColleague;
	}

	// 提供对外入口方法
	public void createComputer() {
		System.out.println("开始组装电脑...");
		cpuColleague.create();
		boardColleague.create();
	}
}
