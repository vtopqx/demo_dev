package com.sam.project.createtype.factory;

/**
 * @ClassName: Client 
 * @Description: java设计模式(工厂模式)
 * @author mqx 
 * @date 2017年9月25日 下午3:30:46
 */
public class Client {
	
	public static void main(String[] args) {
		Cpu cpu = CpuFactory.createCpu("amd",987);
		cpu.run();
	}
}
