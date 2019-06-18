package com.sam.project.behavior.command;

//请求角色类
public class Invoker {
	// 命令对象
	private Command command;

	public Invoker(Command command) {
		this.command = command;
	}

	//请求行动方法
	public void handler(String msg) {
		this.command.execute(msg);
	}
}
