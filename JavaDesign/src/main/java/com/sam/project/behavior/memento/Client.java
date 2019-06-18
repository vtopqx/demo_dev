package com.sam.project.behavior.memento;

/**
 * @ClassName: Client
 * @Description: java设计模式(备忘录模式)
 * @author mqx
 * @date 2017年10月12日 下午1:31:58
 */
public class Client {

	public static void main(String[] args) {
		// 创建发起者
		Originator initiator = new Originator();
		// 设置初始化状态
		initiator.setStatus("start");
		// 创建备忘录对象
		Memento memento = initiator.createMemento();
		// 创建维护者
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(memento);

		System.out.println("当前状态:" + initiator.getStatus());

		// 修改状态
		initiator.setStatus("stop");
		System.out.println("当前状态:" + initiator.getStatus());

		// 恢复之前的状态
		initiator.replyMemento(caretaker.getMemento());
		System.out.println("当前状态:" + initiator.getStatus());
	}
}
