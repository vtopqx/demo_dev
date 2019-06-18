package com.sam.project.behavior.strategy;

/**
 * @ClassName: Client
 * @Description: java设计模式(策略模式)
 * @author mqx
 * @date 2017年10月13日 下午2:38:27
 */
public class Client {

	public static void main(String[] args) {
		// 选择并创建需要使用的策略对象
		Strategy strategyA = new RealStrategyA();
		// 创建环境角色
		Context context = new Context(strategyA);
		// 执行请求
		context.request();
	}
}
