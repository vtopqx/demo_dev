package com.sam.project.behavior.chain;

/**
 * @ClassName: Client
 * @Description: java设计模式(责任链模式)
 * @author mqx
 * @date 2017年10月9日 上午11:01:24
 */
public class Client {

	private static void vacation() {
		// 组装责任链
		Handler chainA = new RealHandlerA();
		Handler chainB = new RealHandlerB();
		Handler chainC = new RealHandlerC();

		// chainC => chainB =>chainA
		chainC.setResource(chainB);
		chainB.setResource(chainA);

		// 测试，模拟请假天数进行审批
		chainC.requestHand(1);
		System.out.println("------------分割线------------");
		chainC.requestHand(4);
		System.out.println("------------分割线------------");
		chainC.requestHand(6);
	}

	public static void main(String[] args) {
		vacation();
	}
}
