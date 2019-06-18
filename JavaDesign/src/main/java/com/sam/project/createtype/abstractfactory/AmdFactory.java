package com.sam.project.createtype.abstractfactory;

public class AmdFactory implements AbstractFactory {
	@Override
	public Cpu createCpu() {
		System.out.println("create amd cpu!");
		return new Cpu(4);
	}

	@Override
	public Memory createMemory() {
		System.out.println("create amd memory!");
		return new Memory(800);
	}
}
