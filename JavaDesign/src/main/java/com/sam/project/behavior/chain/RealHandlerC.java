package com.sam.project.behavior.chain;

//具体处理者角色C(项目经理)
public class RealHandlerC extends Handler {

	@Override
	public void requestHand(int date) {
		System.out.println("C 条件过滤...");
		if (date <= 2) {
			System.out.println("C处理请求!");
		} else {
			if (this.getResource() != null) {
				System.out.println("天数为" + date + ",C交给下一级处理!");
				this.getResource().requestHand(date);
			}
		}
	}
}
