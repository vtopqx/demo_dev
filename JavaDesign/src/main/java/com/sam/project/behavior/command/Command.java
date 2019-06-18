package com.sam.project.behavior.command;

//抽象命令角色
public interface Command {
	//命令执行处理方法
	public void execute(String msg);
}
