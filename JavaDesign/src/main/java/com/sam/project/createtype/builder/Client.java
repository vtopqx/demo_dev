package com.sam.project.createtype.builder;

/**
 * @ClassName: Client 
 * @Description: java设计模式(建造者模式)
 * @author mqx 
 * @date 2017年9月25日 下午3:30:21
 */
public class Client {

	private static void build() {
		ComputerDirector cd = new ComputerDirector();
		Computer computer = cd.createComputer(new ComputerBuilder());
		System.out.println(computer.getCpu().getName());
		System.out.println(computer.getBoard().getName());
	}

	public static void main(String[] args) {
		build();
	}
}
