package com.sam.project.behavior.chain;

//具体处理者角色B(部门经理)
public class RealHandlerB extends Handler {

	@Override
	public void requestHand(int date) {
		System.out.println("B 条件过滤...");
		if (date <= 5) {
			System.out.println("B处理请求!");
		} else {
			if (this.getResource() != null) {
				System.out.println("天数为" + date + ",B交给下一级处理!");
				this.getResource().requestHand(date);
			}
		}
	}
}
