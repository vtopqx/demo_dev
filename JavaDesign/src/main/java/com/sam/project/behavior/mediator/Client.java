package com.sam.project.behavior.mediator;

/**
 * @ClassName: Client
 * @Description: java设计模式(中介者模式)
 * @author mqx
 * @date 2017年10月10日 下午2:10:07
 */
public class Client {

	public static void main(String[] args) {
		String name = "Intel";
		CpuColleague cpuColleague = new CpuColleague(name);
		BoardColleague boardColleague = new BoardColleague(name);
		// 通过中介对象整合各个组件
		Mediator mediator = new Mediator(cpuColleague, boardColleague);

		mediator.createComputer();
	}
}
