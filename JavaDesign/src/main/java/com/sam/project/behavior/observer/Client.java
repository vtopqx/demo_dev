package com.sam.project.behavior.observer;

/**
 * @ClassName: Client
 * @Description: java设计模式(观察者模式)
 * @author mqx
 * @date 2017年10月12日 下午5:39:18
 */
public class Client {

	public static void main(String[] args) {
		// 创建主题
		RealSubject subject = new RealSubject();

		// 创建观察者
		Observer observerA = new RealObserver("张三");
		Observer observerB = new RealObserver("李四");
		// 给主题添加观察者
		subject.register(observerA);
		subject.register(observerB);

		// 改变主题内容状态
		subject.change("start");
	}
}
