package com.sam.project.behavior.command;

//接收角色类
public class Receiver {
	/**
	 * @Description: 执行命令操作
	 * @param msg
	 */
	public void action(String msg) {
		System.out.println("接收：" + msg);
		System.out.println("命令执行处理!");
	}
}
