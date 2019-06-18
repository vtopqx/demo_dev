package com.sam.project.frameworktype.facade;

//门面外观角色
public class ModuleFacade {
	//用户存款入口操作
	public void Save(String account,long money) {
		System.out.println("用户存钱开始...");
		ModuleA a = new ModuleA();
		ModuleB b = new ModuleB();
		ModuleC c = new ModuleC();
		
		a.validate(money);
		b.account(account,money);
		c.record(account,money);
	}
}
