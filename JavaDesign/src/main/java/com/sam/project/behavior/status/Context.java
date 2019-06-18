package com.sam.project.behavior.status;

//环境角色类
public class Context {
	// 内部状态
	private State status;

	public void setStatus(State status) {
		this.status = status;
	}

	// 行为
	public void request() {
		status.handle();
	}
}
