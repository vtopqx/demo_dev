package com.sam.project.frameworktype.decorator;

/**
 * @ClassName: Client 
 * @Description: java设计模式(装饰模式)
 * @author mqx 
 * @date 2017年9月29日 下午3:56:20
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Component c = new RealComponent();
		
		RealDecoratorA a = new RealDecoratorA(c);
		a.operation();
	}
}
