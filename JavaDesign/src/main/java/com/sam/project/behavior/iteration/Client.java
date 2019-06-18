package com.sam.project.behavior.iteration;

/**
 * @ClassName: Client
 * @Description: java设计模式(迭代模式)
 * @author mqx
 * @date 2017年10月9日 下午5:15:25
 */
public class Client {

	public static void operation() {
		Object[] objArray = { "One", "Two", "Three", "Four", "Five", "Six" };
		// 创建聚合对象
		Aggregate aggregate = new RealAggregate(objArray);
		// 循环输出聚合对象中的值
		Iterator it = aggregate.createIterator();
		while (!it.isDone()) {
			System.out.println(it.currentItem());
			it.next();
		}
	}

	public static void main(String[] args) {
		operation();
	}
}
