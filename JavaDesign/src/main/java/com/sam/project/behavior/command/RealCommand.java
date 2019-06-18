package com.sam.project.behavior.command;

//具体命令角色类
public class RealCommand implements Command {
	//接收者
	private Receiver receiver;

	public RealCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute(String msg) {
		this.receiver.action(msg);
	}
}
