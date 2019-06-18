package com.sam.project.createtype.abstractfactory;

/**
 * @ClassName: Client 
 * @Description: java设计模式(抽象工厂)
 * @author mqx 
 * @date 2017年9月25日 下午3:30:04
 */
public class Client {
	/**
	 * @Description: 创建电脑组装，根据产品工厂
	 * @param factory
	 */
	private static void createComputer(AbstractFactory factory){
		factory.createCpu();
		factory.createMemory();
	}

	//run
	public static void main(String[] args) {
		AbstractFactory factory = new IntelFactory();
		createComputer(factory);
	}
}
