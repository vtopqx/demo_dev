package com.sam.project.behavior.status;

/**
 * @ClassName: Client
 * @Description: java设计模式(状态模式)
 * @author mqx
 * @date 2017年10月13日 上午10:48:56
 */
public class Client {

	public static void main(String[] args) {
		// 创建环境
		Context context = new Context();
		// 设置环境状态
		context.setStatus(new RealStateA());
		// 状态改变时行为也自动改变
		context.request();

		// 状态改变时行为也自动改变
		context.setStatus(new RealStateB());
		context.request();
	}
}
