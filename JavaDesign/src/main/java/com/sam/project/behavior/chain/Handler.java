package com.sam.project.behavior.chain;

//　抽象处理者角色类
public abstract class Handler {

	/**
	 * @Description: 定义处理方法
	 * @param date	请假天数
	 */
	public abstract void requestHand(int date);

	// 过滤器对象
	private Handler resource;

	public Handler getResource() {
		return resource;
	}

	public void setResource(Handler resource) {
		this.resource = resource;
	}

}
