package com.sam.project.frameworktype.flyweight;

//抽象具体实现
public class RealFlyweight implements Flyweight {

	private Character innerStatus = null;

	// 内蕴状态作为参数传入
	public RealFlyweight(char sta) {
		this.innerStatus = sta;
	}

	/**
	 * 外蕴状态作为参数传入方法中，改变方法的行为， 但是并不改变对象的内蕴状态。
	 */
	@Override
	public void operation(String param) {
		System.out.println("inner status:" + this.innerStatus);
		System.out.println("external status:" + param);
	}
}
