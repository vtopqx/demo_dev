package com.sam.project.behavior.command;

/**
 * @ClassName: Client
 * @Description: java设计模式(命令模式)
 * @author mqx
 * @date 2017年10月9日 下午2:33:57
 */
public class Client {

	public static void main(String[] args) {
		// 创建接收者
		Receiver receiver = new Receiver();
		// 创建命令
		Command command = new RealCommand(receiver);
		// 创建发送者请求者
		Invoker invok = new Invoker(command);
		// 执行请求操作
		String msg = "./start.sh";
		invok.handler(msg);
	}
}
