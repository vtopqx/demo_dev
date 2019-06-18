package com.sam.project.behavior.template;

/**
 * @ClassName: Client
 * @Description: java设计模式(模版模式)
 * @author mqx
 * @date 2017年10月13日 下午4:05:38
 */
public class Client {

	public static void main(String[] args) {
		// 创建模版
		AbstractTemplate tmp = new RealemplateA();
		tmp.request("测试");

		tmp = new RealemplateB();
		tmp.request("发布");
	}
}
