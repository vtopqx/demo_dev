package com.sam.project.frameworktype.facade;

/**
 * @ClassName: Client 
 * @Description: java设计模式(外观模式)
 * @author mqx 
 * @date 2017年9月25日 下午3:15:49
 */
public class Client {
	public static void main(String[] args) {
		ModuleFacade facade = new ModuleFacade();
		facade.Save("张三",100000);
	}
}
