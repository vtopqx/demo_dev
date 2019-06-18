package com.sam.project.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Client
 * @Description: java设计模式(访问者模式)
 * @author mqx
 * @date 2017年10月14日 下午12:24:55
 */
public class Client {
	public static void main(String[] args) {
		List<AbstractElement> list = ObjectStruture.getList();
		for (AbstractElement e : list) {
			// 添加访问者
			e.accept(new RealVisitor());
		}
	}
}

//结构对象角色
class ObjectStruture {
	// 仿造测试元素数据
	public static List<AbstractElement> getList() {
		List<AbstractElement> list = new ArrayList<AbstractElement>();
		list.add(new ConcreteElementA());
		list.add(new ConcreteElementB());

		return list;
	}
}
