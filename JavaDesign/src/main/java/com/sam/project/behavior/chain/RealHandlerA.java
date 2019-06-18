package com.sam.project.behavior.chain;

//具体处理者角色A(总经理)
public class RealHandlerA extends Handler {

	@Override
	public void requestHand(int date) {
		System.out.println("A 条件过滤...");
		if (date > 5) {
			System.out.println("A处理请求!");
		} else {
			if (this.getResource() != null) {
				System.out.println("天数为" + date + ",A交给下一级处理!");
				this.getResource().requestHand(date);
			}
		}
	}
}
