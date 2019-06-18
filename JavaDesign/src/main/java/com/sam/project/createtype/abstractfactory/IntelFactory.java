package com.sam.project.createtype.abstractfactory;

public class IntelFactory implements AbstractFactory {
	@Override
	public Cpu createCpu() {
		System.out.println("create intel cpu!");
		return new Cpu(6);
	}

	@Override
	public Memory createMemory() {
		System.out.println("create intel memory!");
		return new Memory(75);
	}
}
